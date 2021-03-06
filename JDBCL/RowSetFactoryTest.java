package JDBCL;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.FileInputStream;
import java.util.Properties;

public class RowSetFactoryTest {
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

    public void update(String sql) throws Exception {
        //加载驱动
        Class.forName(driver);
        //创建工厂
        RowSetFactory factory = RowSetProvider.newFactory();
        try (JdbcRowSet jdbcRs = factory.createJdbcRowSet()) {
            //设置必要的链接信息
            jdbcRs.setUrl(url);
            jdbcRs.setUsername(user);
            jdbcRs.setPassword(pass);
            //设置SQL查询语句
            jdbcRs.setCommand(sql);
            //执行查询
            jdbcRs.execute();
            jdbcRs.afterLast();
            //向前滚动结果集
            while (jdbcRs.previous())
            {
                System.out.println(jdbcRs.getString(1) + "\t" +
                        jdbcRs.getString(2) + "\t" + jdbcRs.getString(3));
                if (jdbcRs.getInt("student_id") == 3) {
                    //修改指定记录行
                    jdbcRs.updateString("student_name", "xunwukong");
                    jdbcRs.updateRow();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        var jt = new RowSetFactoryTest();
        jt.initParam("mysql.ini");
        jt.update("select * from student_table");
    }
}
