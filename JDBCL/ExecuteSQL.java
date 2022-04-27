package JDBCL;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ExecuteSQL {
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
    public void executeSql(String sql) throws Exception {
        //加载驱动
        Class.forName(driver);
        try (//获取数据库连接
             Connection conn = DriverManager.getConnection(url, user, pass);
             //使用 Connection 创建 Statement对象
             Statement stmt = conn.createStatement())
        {
            //执行SQL语句
            boolean hasResultSet = stmt.execute(sql);
            if (hasResultSet){
                //有结果集的区间
                try (ResultSet rs = stmt.getResultSet())
                {
                    //ResultSetMetaData用于分析结果集的元数据接口
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount =rsmd.getColumnCount();
                    //迭代输出ResultSet对象
                    while (rs.next())
                    {
                        //依次输出每列的值
                        for (int i = 0; i < columnCount; i++) {
                            System.out.print(rs.getString(i+1)+" ");
                        }
                        System.out.print("\n");
                    }

                }
            }else {
                System.out.println("该SQL语句影响的记录有"+stmt.getUpdateCount()+"条");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        var es = new ExecuteSQL();
        es.initParam("mysql.ini");
        System.out.println("删除的DDL语句");
        es.executeSql("drop table if exists my_test");
        System.out.println("执行建表DDL语句");
        es.executeSql("create table my_test" +
                "(test_id int auto_increment primary key," +
                "test_name varchar(255))");
        System.out.println("执行插入数据的DML语句");
        es.executeSql("insert into my_test(test_name)" +
                "select student_name from student_table");
        System.out.println("执行查询语句");
        es.executeSql("select * from my_test");
    }
}
