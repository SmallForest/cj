package JDBCL;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class LoginFrame2 {
    private final String PROP_FILE = "mysql.ini";
    private String driver;
    private String url;
    private String user;
    private String pass;
    //登录界面的GUI
    private JFrame jf = new JFrame("登录");
    private JTextField userField = new JTextField(20);
    private JTextField passField = new JTextField(20);
    private JButton loginButton = new JButton("登录");

    public void init() throws Exception {
        var props = new Properties();
        props.load(new FileInputStream(PROP_FILE));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
        //加载驱动
        Class.forName(driver);
        //为登录按钮添加事件监听器
        loginButton.addActionListener(e -> {
            //登录成功 显示"登录成功"
            if (validate(userField.getText(), passField.getText())) {
                JOptionPane.showMessageDialog(jf, "登录成功");
            } else {
                JOptionPane.showMessageDialog(jf, "登录失败");
            }
        });
        jf.add(userField, BorderLayout.NORTH);
        jf.add(passField);
        jf.add(loginButton, BorderLayout.SOUTH);
        jf.pack();
        jf.setVisible(true);
    }

    private boolean validate(String userName, String userPass) {
        //执行查询语句
        var sql = "select * from jdbc_test " +
                "where jdbc_name=?" +
                " and jdbc_desc=?";
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, userName);
            pstmt.setString(2, userPass);
            try (ResultSet rs = pstmt.executeQuery();
            ) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new LoginFrame2().init();
    }
}
