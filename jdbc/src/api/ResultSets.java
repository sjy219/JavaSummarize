package api;

/*
 * ---------ResultSet(结果集对象）作用-----------
 *   1.封装了DQL查询语句的结果集
 *-----ResultSet stmt executeQuery(sql):执行sql语句，返回ResultSet对象
 *   2.获取查询结果
 *-----boolean next(): (1）将光标从当前位置向前移动一行 （2）判断当前行是否为有效行
 *-----返回值：
 *--------true:有效行，当前行有数据
 *--------false:无效行，当前行没有数据
 *
 *       xxx getXxx(参数): 获取数据
 *       ->xxx:数据类型： 如：int getInt(参数）, String getString(参数)
 *       ->int: 列的编号，从1开始
 *       ->String: 列的名称
 * */

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*---------DQL查询语句---------*/
public class ResultSets {
    @Test//简单查询演示
    public void query() throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接对象，建立连接
        String url = "jdbc:mysql://localhost:3306/example?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pass = "root";
        Connection conn = DriverManager.getConnection(url, user, pass);
        //定义sql语句
        String sql = "select * from students";
        //获取执行sql对象
        Statement stmt = conn.createStatement();
        //执行sql返回sql结果
        ResultSet resultSet = stmt.executeQuery(sql);
        //处理sql结果
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " " + resultSet.getInt("age") + "   " + resultSet.getString("name"));
        }

        //释放资源
        resultSet.close();
        stmt.close();
        conn.close();
    }


    /*
     * 需求：查询students数据表，封装为Students对象，并且存储到ArrayList集合中
     * */
    @Test
    public void resultCase() throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //创建连接对象，建立连接
        String url = "jdbc:mysql://localhost:3306/example?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pass = "root";
        Connection conn = DriverManager.getConnection(url, user, pass);
        //编写sql查询语句
        String sql = "select * from students";
        //创建sql查询对象
        Statement stmt = conn.createStatement();
        //执行sql查询对象，结果存入到ResultSet集合中
        ResultSet resultSet = stmt.executeQuery(sql);
        //创建ArrrayList集合
        ArrayList<Students> arrayList = new ArrayList<>();
        //封装Students对象
        while (resultSet.next()) {
            Students students = new Students();
            students.setId(resultSet.getInt("id"));
            students.setAge(resultSet.getInt("age"));
            students.setName(resultSet.getString("name"));
            arrayList.add(students);
        }
        //释放资源
        resultSet.close();
        stmt.close();
        conn.close();

        //遍历ArrayList集合
        for (Students ss : arrayList) {
            System.out.println(ss);
            //System.out.println(ss.getId() + " " + ss.getAge() + " " + ss.getName());
        }
    }

}
