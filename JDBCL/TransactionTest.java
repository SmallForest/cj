package JDBCL;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class TransactionTest {
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

    public void insertInTransaction(String[] sqls) throws Exception {
        Class.forName(driver);
        try (
                Connection conn = DriverManager.getConnection(url, user, pass);
        ) {
            //关闭自动提交，开始事务
            conn.setAutoCommit(false);
            try (Statement stmt = conn.createStatement()) {
                for (var sql : sqls) {
                    stmt.executeUpdate(sql);
                }
            }
            conn.commit();
        }
    }

    public static void main(String[] args) throws Exception {
        var tt = new TransactionTest();
        tt.initParam("mysql.ini");
        var sqls = new String[]{
                "insert into student_table value(null,'aaa',1)",
                "insert into student_table value(null,'ccc',1)",
                "insert into student_table value(null,'bbb',1)",
                //报错，违背外键约束，teacher_table没有id=5的 。程序崩溃触发回滚
                "insert into student_table value(null,'aaa',5)",
        };
        tt.insertInTransaction(sqls);
    }
}
