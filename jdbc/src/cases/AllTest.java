package cases;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
/*
* 利用Druid来实现对students表中的数据实现增删改查操作
* 思路：
*   1.导入druid包
    2.定义配置文件
    3.加载配置文件
    4.建立数据库连接对象
    5.Test1查询表中所有的数据，并打印到控制台
*
* */

public class AllTest {

    @Test
    public void query() throws Exception {
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileReader("src/druid.properties"));

        //获取数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //建立数据库连接
        Connection conn = dataSource.getConnection();

        //编写sql查询语句
        String sql = "select * from students";

        //创建sql查询对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //只想查询,查询结果存储到ResultSet中
        ResultSet resultSet = pstmt.executeQuery();

        //处理查询结果，打印到控制台中
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            System.out.println(id + " " + age + " " + name);
        }
        //释放资源
        pstmt.close();
        conn.close();

    }

    //Test2向表中插入一行数据
    @Test
    public void inserts() throws Exception {
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileReader("src/druid.properties"));

        //获取数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //建立数据库连接
        Connection conn = dataSource.getConnection();

        //编写插入sql语句
        String sql = "insert into students values(?,?,?)";

        //创建sql查询对象
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        //填写sql语句的参数
        preparedStatement.setInt(1, 5);
        preparedStatement.setInt(2, 23);
        preparedStatement.setString(3, "王五");

        //执行sql查询
        int count = preparedStatement.executeUpdate();

        //处理查询结果
        if (count > 0) {
            System.out.println("插入数据成功");
        } else {
            System.out.println("插入数据失败");
        }

        //释放资源
        preparedStatement.close();
        conn.close();
    }

    //Test3修改表中的数据
    @Test
    public void updates() throws Exception {
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileReader("src/druid.properties"));

        //获取数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //建立数据库连接
        Connection conn = dataSource.getConnection();

        //编写修改型sql语句
        String sql = "update students set age=?,name=? where id = 2";

        //创建sql语句对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //为sql语句中的参数赋值
        pstmt.setInt(1, 12);
        pstmt.setString(2, "马六");

        //执行sql查询语句
        int count = pstmt.executeUpdate();

        //处理查询结果
        if (count > 0) {
            System.out.println("更新数据成功");
        } else {
            System.out.println("更新数据失败");
        }
        //释放资源
        pstmt.close();
        conn.close();
    }

    //Test4根据id删除表中的数据
    @Test
    public void deletes() throws Exception {
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileReader("src/druid.properties"));

        //获取数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //建立数据库连接
        Connection conn = dataSource.getConnection();

        //编写sql删除语句
        String sql = "delete from students where id = ?";

        //创建sql对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //为sql参数赋值
                /*-------这里为啥出问题了呢----------*/
//        pstmt.setInt(1, 2);
        pstmt.setInt(1,4);

        //执行sql语句
        int count = pstmt.executeUpdate();

        //处理查询结果
        if (count > 0) {
            System.out.println("删除数据成功");
        } else {
            System.out.println("删除数据失败");
        }
        //释放资源
        pstmt.close();
        conn.close();
    }
}
