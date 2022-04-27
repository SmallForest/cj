package JDBCL;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class BlobTest {
    JFrame jf = new JFrame("图片管理程序smallForest");
    private static Connection conn;
    private static PreparedStatement insert;
    private static PreparedStatement query;
    private static PreparedStatement queryAll;
    //定义一个DefaultListModel对象
    private DefaultListModel<ImageHolder> imageModel =
            new DefaultListModel<>();
    private JList<ImageHolder> imageList =
            new JList<>(imageModel);

    private JTextField filePath = new JTextField(26);
    private JButton browserBn = new JButton("...");
    private JButton uploadBn = new JButton("上传");
    private JLabel imageLabel = new JLabel();
    //以当前路径创建文件选择器
    JFileChooser chooser = new JFileChooser(".");
    //创建文件过滤器
    ExtensionFileFilter filter = new ExtensionFileFilter();

    static {
        try {
            var props = new Properties();
            props.load(new FileInputStream("mysql.ini"));
            var driver = props.getProperty("driver");
            var url = props.getProperty("url");
            var user = props.getProperty("user");
            var pass = props.getProperty("pass");
            Class.forName(driver);

            //获取数据库连接
            conn = DriverManager.getConnection(url, user, pass);
            insert = conn.prepareStatement("insert into img_table" +
                    " values(null,?,?)", Statement.RETURN_GENERATED_KEYS);
            //创建两个预处理对象
            query = conn.prepareStatement("select img_data from img_table" +
                    " where img_id = ?");
            queryAll = conn.prepareStatement("select img_id, " +
                    "img_name from img_table");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() throws SQLException {
        //初始化文件选择器
        filter.addExtension("jpg");
        filter.addExtension("jpeg");
        filter.addExtension("gif");
        filter.addExtension("png");
        filter.setDescription("图片文件(*.jpg,*.jpeg,*.gif,*.png)");
        chooser.addChoosableFileFilter(filter);
        //禁止 文件类型 下拉列表显示 所有文件 选项
        chooser.setAcceptAllFileFilterUsed(false);
        //初始化程序界面
        fillListModel();
        filePath.setEditable(false);
        //只能单选
        imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        var jp = new JPanel();
        jp.add(filePath);
        jp.add(browserBn);
        browserBn.addActionListener(event -> {
            //显示文件对话框
            int result = chooser.showDialog(jf, "浏览图片文件上传");
            if (result == JFileChooser.APPROVE_OPTION) {
                filePath.setText(chooser.getSelectedFile().getPath());
            }
        });
        jp.add(uploadBn);
        uploadBn.addActionListener(avt -> {
            if (filePath.getText().trim().length() > 0) {
                //将文件保存数据库
                upload(filePath.getText());
                //清空
                filePath.setText("");
            }
        });
        var left = new JPanel();
        left.setLayout(new BorderLayout());
        left.add(new JScrollPane(imageLabel), BorderLayout.CENTER);
        left.add(jp, BorderLayout.SOUTH);
        jf.add(left);

        imageList.setFixedCellWidth(200);
        jf.add(new JScrollPane(imageList), BorderLayout.EAST);
        imageList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //双击
                if (e.getClickCount() >= 2) {
                    ImageHolder cur = (ImageHolder) imageList.getSelectedValue();
                    try {
                        //显示选中的图
                        showImage(cur.getId());
                    } catch (SQLException sqle) {
                        sqle.getErrorCode();
                    }
                }
            }
        });
        jf.setSize(660, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    //查找img_table
    public void fillListModel() throws SQLException {
        try (ResultSet rs = queryAll.executeQuery()) {
            //先清楚所有元素
            imageModel.clear();
            while (rs.next()) {
                imageModel.addElement(new ImageHolder(rs.getInt(1), rs.getString(2)));
            }
        }
    }

    //将指定图片放数据库
    public void upload(String fileName) {
        //截取文件名
        String imageName = fileName.substring(fileName.lastIndexOf('\\') + 1, fileName.lastIndexOf('.'));
        var f = new File(fileName);
        System.out.println(imageName);
        try (var is = new FileInputStream(f))
        {
            //设置图片名参数
            insert.setString(1, imageName);
            //设置二进制流参数
            insert.setBinaryStream(2, is, (int) f.length());
            int affect = insert.executeUpdate();
            if (affect == 1) {
                //重新更新ListModel，将会展示最新的图片列表
                fillListModel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //根据图片ID展示图片
    public void showImage(int id) throws SQLException {
        //设置参数
        query.setInt(1, id);
        try (ResultSet rs = query.executeQuery()) {
            if (rs.next()) {
                //取出Blob列
                Blob imgBlob = rs.getBlob(1);
                //取出Blob列的数据
                var icon = new ImageIcon(imgBlob.getBytes(1L, (int) imgBlob.length()));
                imageLabel.setIcon(icon);
            }
        }
    }

    //启动
    public static void main(String[] args) throws SQLException {
        new BlobTest().init();
    }
}

//创建子类实现文件过滤
class ExtensionFileFilter extends FileFilter {
    private String description = "";
    private ArrayList<String> extensions = new ArrayList<>();

    //自定义方法
    public void addExtension(String extension) {
        if (!extension.startsWith(".")) {
            extension = "." + extension;
            extensions.add(extension.toLowerCase());
        }
    }

    //用于设置该文件过滤器的描述文本
    public void setDescription(String a) {
        description = a;
    }

    //继承FileFilter类必须实现的抽象方法，
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) return true;
        String name = f.getName().toLowerCase();
        //遍历所有可接手的拓展名
        for (var e : extensions) {
            if (name.endsWith(e)) {
                return true;
            }
        }
        return false;
    }
}

//创建一个ImageHolder类
class ImageHolder {
    private int id;
    private String name;

    public ImageHolder() {
    }

    public ImageHolder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
