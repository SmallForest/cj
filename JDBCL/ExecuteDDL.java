package JDBCL;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDDL {
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
    }

    public void createTable(String sql) throws Exception {
        //加载驱动
        Class.forName(driver);
        try (//获取数据库连接
             Connection conn = DriverManager.getConnection(url, user, pass);
             //使用 Connection 创建 Statement对象
             Statement stmt = conn.createStatement())
        {
            //执行DDL语句
            stmt.executeUpdate(sql);
        }
    }

    public static void main(String[] args) throws Exception {
        var ed = new ExecuteDDL();
        //mysql.ini 在项目根目录
        ed.initParam("mysql.ini");
        ed.createTable("create table jdbc_test "
                +"( jdbc_id int auto_increment primary key," +
                " jdbc_name varchar(255)," +
                "jdbc_desc text) CHARSET=utf8mb4 COLLATE=utf8mb4_bin;");
        System.out.println("建表成功");

        /*CREATE TABLE `jdbc_test` (
         `jdbc_id` int(11) NOT NULL AUTO_INCREMENT,
         `jdbc_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
         `jdbc_desc` text COLLATE utf8mb4_bin,
         PRIMARY KEY (`jdbc_id`)
         ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;*/
    }
}
