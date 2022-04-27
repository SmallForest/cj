package JDBCL;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDML {
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

    public int insertData(String sql) throws Exception {
        //加载驱动
        Class.forName(driver);
        try (//获取数据库连接
             Connection conn = DriverManager.getConnection(url, user, pass);
             //使用 Connection 创建 Statement对象
             Statement stmt = conn.createStatement()) {
            //执行DML语句，返回受影响的记录条数
            return stmt.executeUpdate(sql);
        }
    }

    public static void main(String[] args) throws Exception {
        var ed = new ExecuteDML();
        ed.initParam("mysql.ini");
        int result = ed.insertData("insert into jdbc_test(" +
                "jdbc_name,jdbc_desc)" +
                "select s.student_name,t.teacher_name " +
                "from student_table as s,teacher_table as t " +
                "where s.java_teacher = t.teacher_id;");
        System.out.println("--一共有" + result + "条记录受到影响--");
    }
}
