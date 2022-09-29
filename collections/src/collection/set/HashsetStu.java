package collection.set;

/*
 * 需求：创建一个存储学生对象的集合，存储多个学生对象，使用程序在控制台遍历集合
 *   要求：学生对象的成员变量值相同，我们就认为是同一个
 * 思路：
 *   1.创建学生类
 *   2.创建HashSet集合
 *   3.创建学生对象
 *   4.把学生对象添加到集合
 *   5.遍历集合
 * */

import java.util.HashSet;
        //-------------------重写学生类中的HashCode和equals方法-----------------\\
public class HashsetStu {
    public static void main(String[] args) {
        //创建学生类

        //创建HashSet集合
        HashSet<HashStudents> hashSet = new HashSet<>();

        //创建并初始化学生对象
        HashStudents zhangsan = new HashStudents("zhangsan", 20);
        HashStudents lisi = new HashStudents("lisi", 21);
        HashStudents wangwu = new HashStudents("wangwu", 21);
        HashStudents zhangsan1 = new HashStudents("zhangsan", 20);

        //把学生对象存储到HashSet集合
        hashSet.add(zhangsan);
        hashSet.add(lisi);
        hashSet.add(wangwu);
        hashSet.add(zhangsan1);

        //遍历HashSet集合，打印数据到控制台
        for (HashStudents st : hashSet) {
            String name = st.getName();
            int age = st.getAge();
            System.out.println(name + "," + age);
        }

    }
}
