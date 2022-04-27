package JDBCL;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class PreparedStatementTest {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public void initParam(String paramFile) throws Exception {
        //使用properties加载属性文件，配置文件
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
        //加载驱动
        Class.forName(driver);
    }
    public void insertUseStatement() throws Exception {
        long start = System.currentTimeMillis();
        try (//获取数据库连接
             Connection conn = DriverManager.getConnection(url, user, pass);
             //使用 Connection 创建 Statement对象
             Statement stmt = conn.createStatement())
        {
            //插入 100条SQL
            for (int i = 0; i < 100; i++) {
                stmt.executeUpdate("insert into student_table values("+"null,'姓名"+i+"',1)");
            }
            System.out.println("使用Statement费时"+(System.currentTimeMillis()-start));
        }
    }
    public void insertUsePrepare() throws Exception{
        long start = System.currentTimeMillis();
        try (//获取数据库连接
             Connection conn = DriverManager.getConnection(url, user, pass);
             //使用 Connection 创建 Statement对象
             PreparedStatement pstmt = conn.prepareStatement("insert into student_table values(null,?,1)"))
        {
            //插入 100条SQL 预生成
            for (int i = 0; i < 100; i++) {
                pstmt.setString(1,"姓名"+i);
                pstmt.executeUpdate();
            }
            System.out.println("使用PreparedStatement费时"+(System.currentTimeMillis()-start));
        }
    }

    public static void main(String[] args) throws Exception {
        var pt = new PreparedStatementTest();
        pt.initParam("mysql.ini");
        pt.insertUseStatement();
        pt.insertUsePrepare();
    }
}
