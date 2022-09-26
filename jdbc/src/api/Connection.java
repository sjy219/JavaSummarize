package api;

/*
* Connection(数据库连接对象）作用
*   1.获取执行sql对象
*       1.普通执行sql对象
*           Statement createStatement()
*       2.预编译sql执行对象：防止sql注入
*           PrepareStatement prepareStatement(sql)
*       3.执行存储过程的对象
*           CallableStatement prepareCall(sql)
*
*   2.管理事物
*       ---MYSQL事务管理---
*       1.开启事务：BEGIN:/START TRANSACTION;
*       2.提交事务：COMMIT;
*       3.回滚事务：ROLLBACK;
*       ---JDBC事务管理：Connection接口中定义了3个对应的方法---
*       1.开启事务：setAutoCommit(boolean autoCommit):true为自动提交；false为手动提交事务，即为开启事务
*       2.提交事务：commit();
*       3.回滚事务：rollback();
*
* */

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
                /*----------对事务进行处理----------*/
public class Connection {

    public static void main(String[] args) throws Exception{
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接对象，建立连接
        String url = "jdbc:mysql://localhost:3306/example?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pass = "root";
        java.sql.Connection conn = DriverManager.getConnection(url, user, pass);
        //定义sql语句
        String sql1 = "update students set age=50 where id = 1";
        String sql2 = "update students set age=50 where id = 2";
        //获取执行sql对象
        Statement stmt = conn.createStatement();
        try {
            /*---------开启事务----------*/
            conn.setAutoCommit(false);


            //执行sql返回sql结果
            int count1 = stmt.executeUpdate(sql1);
            int count2 = stmt.executeUpdate(sql2);

            //刻意制造一个异常
            int i = 3 / 0;

            //处理sql结果
            System.out.println(count1);
            System.out.println(count2);

            /*---------提交事务----------*/
            conn.commit();

        } catch (SQLException e) {
            /*---------回滚事务---------*/
               /*---如果不做事务回滚---*/
            conn.rollback();

            throw new RuntimeException(e);
        }
        //释放资源
        stmt.close();
        conn.close();
    }
}
