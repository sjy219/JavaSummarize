
/*
 * 1.注册驱动
 * 2.获取连接对象，建立连接
 * 3.定义SQL语句
 * 4.获取执行SQL对象
 * 5.执行sql
 * 6.返回sql
 * 7.处理结果
 * 8.释放资源
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class heads {

    public static void main(String[] args) throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接对象，建立连接
        String url = "jdbc:mysql://localhost:3306/example?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pass = "root";
        Connection conn = DriverManager.getConnection(url, user, pass);
        //定义sql语句
        String sql = "update students set age=40, name='Lucy' where id = 1";
        //获取执行sql对象
        Statement stmt = conn.createStatement();
        //执行sql返回sql结果
        int count = stmt.executeUpdate(sql);
        //处理sql结果
        System.out.println(count);
        //释放资源
        stmt.close();
        conn.close();
    }
}
