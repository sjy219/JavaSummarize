package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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

    //--------------并发修改异常--------------\\
        //需求：遍历集合，得到每一个元素，看有没有world这个元素，如果有，就添加一个javaee元素
    @Test
    public void listException() {
        //创建list集合，并添加元素
        List<String> list = new ArrayList<String>();
        list.add("hallo");
        list.add("world");
        list.add("java");
        //遍历集合
        for (String ss : list) {
            if ("world".equals(ss)) {
                list.add("javaee");
            }
        }
        System.out.println(list);
    }

}
