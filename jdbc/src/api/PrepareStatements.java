package api;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
* PrepareStatement作用
*   1.预编译SQL语句并执行，防止SQL注入问题
*   1）获取PrepareStatement对象
*       //sql语句中的参数值，使用?占位符替代
*       String sql = "select * from students where name=? and age=?"
*       //桶多Connection对象获取，并传入对象的sql语句
*       PrepareStatement pstmt = conn.prepareStatement(sql);
*   2)设置参数
*       PrepareStatement对象： setXxx(参数1，参数2)给?赋值
*       ->Xxx:数据类型； 如：setInt(参数1，参数2)
*       ->参数：
*           参数1: ？的编号，从1开始
*           参数2: ？的值
*           pstmt.setString(1,"Lili");
*           pstmt.setInt(2,20);
*   3)执行sql语句
*       pstmt.executeUpdate();pstmt.executeQuery();不需要再传入sql语句
*
*
* */

public class PrepareStatements {
    @Test
    public void query() throws Exception{
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接对象，建立连接
        String url = "jdbc:mysql://localhost:3306/example?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pass = "root";
        Connection conn = DriverManager.getConnection(url, user, pass);

        //创建sql语句
        String sql = "select * from students where name=? and age =?";

        //创建PrepareStatement对象
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        //设置参数的值
        preparedStatement.setString(1,"Lucy");
        preparedStatement.setInt(2,50);

        //执行prepareStatement查询对象
        ResultSet resultSet = preparedStatement.executeQuery();
        //处理sql查询结果
        if (resultSet.next()) {
            System.out.println("帐号密码正确");
        } else {
            System.out.println("帐号密码错误");
        }

    }
}
