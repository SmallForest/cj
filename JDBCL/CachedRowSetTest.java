package JDBCL;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class CachedRowSetTest {
    private static String driver;
    private static String url;
    private static String user;
    private static String pass;

    public void initParam(String paramFile) throws Exception {
        //使用properties加载属性文件，配置文件
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public CachedRowSet query(String sql) throws Exception{
        //加载驱动
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        //创建工厂
        RowSetFactory factory = RowSetProvider.newFactory();
        CachedRowSet cachedRs = factory.createCachedRowSet();
        //使用ResultSet装填RowSet
        cachedRs.populate(rs);
        //关闭资源
        rs.close();
        stmt.close();
        return cachedRs;
    }

    public static void main(String[] args) throws Exception{
        var ct = new CachedRowSetTest();
        ct.initParam("mysql.ini");
        CachedRowSet rs = ct.query("select * from student_table");
        rs.afterLast();
        //向前滚动结果集
        while (rs.previous())
        {
            System.out.println(rs.getString(1) + "\t" +
                    rs.getString(2) + "\t" + rs.getString(3));
            if (rs.getInt("student_id") == 3) {
                //修改指定记录行
                rs.updateString("student_name", "xunwukong");
                rs.updateRow();
            }
        }
        //重新获取数据库连接，之前断开了
        Connection conn = DriverManager.getConnection(url, user, pass);
        conn.setAutoCommit(false);
        //RowSet所做的修改同步到数据库底层
        rs.acceptChanges(conn);
    }
}
