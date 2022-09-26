package api;

/*
* Statement作用：
*   1.执行sql语句
*   --- int executeUpdate(sql):执行DML,DDL语句
*   --- 返回值：（1）DML语句影响的行数  （2）DDL语句执行后，执行成功也可能返回0
*
*   --- ResultSet executeQuery(sql): 执行DQL语句
*   --- 返回值： ResultSet 结果集对象
* */

import org.junit.Test;

public class StateMent {

    @Test
    public void speak() {
        System.out.println("hello");
    }

    @Test
    public void nice() {
        System.out.println("good");
    }

}
