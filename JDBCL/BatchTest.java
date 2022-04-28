package JDBCL;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class BatchTest {
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

    public void insertBatch(String[] sqls) throws Exception {
        Class.forName(driver);
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
        ) {
            //关闭自动提交，开始事务
            conn.setAutoCommit(false);

            try (Statement stmt = conn.createStatement()) {
                for (var sql : sqls) {
                    stmt.addBatch(sql);
                }
                //同时提交所有SQL语句
                stmt.executeLargeBatch();
                //提交修改
                conn.commit();
            }
            conn.commit();
        }
    }

    public static void main(String[] args) throws Exception {
        var bt = new BatchTest();
        bt.initParam("mysql.ini");
        var sqls = new String[]{
                "insert into student_table value(null,'aaa',1)",
                "insert into student_table value(null,'ccc',1)",
                "insert into student_table value(null,'bbb',1)",
                //错误的SQL
                "insert into student_table value(null,'bbb',5)",
        };
        bt.insertBatch(sqls);
    }

}
