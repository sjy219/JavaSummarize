package collection.set;


import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetIntroduce {

    //--------------------存储整数并遍历-----------------\\
    //----------TreeSet自然排序------------\\
    @Test
    public void intSort() {
        //创建TreeSet集合，并添加元素
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(20);
        integerTreeSet.add(10);
        integerTreeSet.add(14);
        integerTreeSet.add(30);

        //遍历集合
        for (Integer ins : integerTreeSet) {
            System.out.println(ins);
        }
    }

    //----------TreeSet Comparable自然排序------------\\
    //-------使用TreeSetStudents类--------\\
    @Test
    public void treeSetComp() {
        //创建TreeSet集合，无参构造函数
        TreeSet<TreeSetStudents> treeSet = new TreeSet<>();

        //创建学生对象
        TreeSetStudents zhangsan = new TreeSetStudents("zhangsan", 20);
        TreeSetStudents lisi = new TreeSetStudents("lisi", 21);
        TreeSetStudents wangwu = new TreeSetStudents("wangwu", 19);

        //把学生对象添加到集合
        treeSet.add(zhangsan);
        treeSet.add(lisi);
        treeSet.add(wangwu);

        //遍历集合
        for (TreeSetStudents ts : treeSet) {
            int age = ts.getAge();
            String name = ts.getName();
            System.out.println(name + "," + age);
        }
    }

    //----------TreeSet Comparator构造器------------\\
    //-------使用StudentsComparator类--------\\
    @Test
    public void treeComparator() {
        //以Comparator比较器匿名内部类的形式创建TreeSet集合
        TreeSet<StudentsComparator> treeSet = new TreeSet<>(new Comparator<StudentsComparator>() {
            @Override
            public int compare(StudentsComparator t1, StudentsComparator t2) {
                int num = t1.getAge() - t2.getAge();
                int num2 = num == 0 ? t1.getName().compareTo(t2.getName()) : num;
                return num2;
            }
        });
        //创建学生对象，并初始化
        StudentsComparator zhangsan = new StudentsComparator("zhangsan", 20);
        StudentsComparator lisi = new StudentsComparator("lisi", 22);
        StudentsComparator wangwau = new StudentsComparator("wangwu", 19);
        StudentsComparator maliu = new StudentsComparator("maliu", 19);

        //把学生对象添加进集合
        treeSet.add(zhangsan);
        treeSet.add(lisi);
        treeSet.add(wangwau);
        treeSet.add(maliu);

        //遍历集合
        for (StudentsComparator ts : treeSet) {
            String name = ts.getName();
            int age = ts.getAge();
            System.out.println(name + "," + age);
        }


    }



}
