import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/*
 * Druid的使用
 *   1.导入jar包Druid-1.1.12.jar
 *   2.定义配置文件
 *   3.加载配置文件
 *   4.获取数据库连接池
 *   5.获取连接
 *
 * */

public class Druid {

    public static void main(String[] args) throws Exception{
        //导入jar包Druid-1.1.12.jar

        //定义配置文件

        //加载配置文件
        Properties proper = new Properties();
        proper.load(new FileReader("jdbc/src/druid.properties"));

        //获取数据库连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(proper);

        //获取连接
        Connection conn = dataSource.getConnection();

        //创建sql查询语句
        String sql = "select * from students";
        //创建sql查询对象
        Statement stmt = conn.createStatement();
        //执行sql查询,返回sql查询结果ResultSet
        ResultSet resultSet = stmt.executeQuery(sql);
        //处理查询结果
        while (resultSet.next())
        {
            System.out.println(resultSet.getInt("id")
                    + " " + resultSet.getInt("age")
                    + " " + resultSet.getString("name"));
        }
    }
    @Test
    public void pDir() {
        System.out.println(System.getProperty("user.dir"));
    }
}
