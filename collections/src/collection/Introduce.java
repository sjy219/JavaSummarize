package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Introduce {

    //-----------使用迭代器遍历元素--------------\\
    @Test
    public void iters() {
        //闯将Collection集合，并添加元素
        Collection<String> c = new ArrayList<String>();
        c.add("hello");
        c.add("world");
        c.add("java");

        //创建迭代器
        Iterator<String> iterator = c.iterator();

        //使用迭代器遍历元素
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //-----------迭代器案例--------------\\
    //需求：创建一个存储学生对象的集合，存储3个学生对象，使用程序是现在控制台遍历集合
    @Test
    public void iterCase() {
        //创建学生类

        //创建Collection集合
        Collection<StudIntroduce> c = new ArrayList<StudIntroduce>();

        //创建学生对象,并初始化
        StudIntroduce zhangsan = new StudIntroduce("zhangsan", 20);
        StudIntroduce lisi = new StudIntroduce("lisi", 19);
        StudIntroduce wangwu = new StudIntroduce("wangwu", 23);

        //把学生对象添加进集合
        c.add(zhangsan);
        c.add(lisi);
        c.add(wangwu);

        //创建迭代器
        Iterator<StudIntroduce> iter = c.iterator();

        //遍历集合
        while (iter.hasNext()) {
            StudIntroduce stNext = iter.next();
            String name = stNext.getName();
            int age = stNext.getAge();
            System.out.println(name + "," + age);
        }

    }

}
