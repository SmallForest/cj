package JDBCL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;

public class QueryExecutor {
    JFrame jf = new JFrame("查询执行器");
    private JScrollPane scrollPane;
    private JButton execBn = new JButton("查询");
    //用于输入查询语句的文本框
    private JTextField sqlField = new JTextField(30);
    private static Connection conn;
    private static Statement stmt;

    //采用静态初始化块来初始化Connection Statement对象
    static {
        try {
            var props = new Properties();
            props.load(new FileInputStream("mysql.ini"));
            var driver = props.getProperty("driver");
            var url = props.getProperty("url");
            var user = props.getProperty("user");
            var pass = props.getProperty("pass");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //初始化界面
    public void init() {
        var top = new JPanel();
        top.add(new JLabel("输入查询语句"));
        top.add(sqlField);
        top.add(execBn);
        execBn.addActionListener(new ExceListener());
        sqlField.addActionListener(new ExceListener());
        jf.add(top, BorderLayout.NORTH);
        jf.setSize(680, 480);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    class ExceListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            if (scrollPane != null) {
                jf.remove(scrollPane);
            }
            try (ResultSet rs = stmt.executeQuery(sqlField.getText())) {
                ResultSetMetaData rsmd = rs.getMetaData();
                Vector<String> columnNames = new Vector<>();
                Vector<Vector<String>> data = new Vector<>();
                //
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    columnNames.add(rsmd.getColumnName(i + 1));
                }
                while (rs.next()) {
                    Vector<String> v = new Vector<>();
                    for (int i = 0; i < rsmd.getColumnCount(); i++) {
                        v.add(rs.getString(i + 1));
                    }
                    data.add(v);
                }
                //创建新的JTable
                var table = new JTable(data, columnNames);
                scrollPane = new JScrollPane(table);
                //添加新的Table
                jf.add(scrollPane);
                //更新主窗口
                jf.validate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new QueryExecutor().init();
    }
}
