package collection.set;


import org.junit.Test;

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

    //----------TreeSet Comparator自然排序------------\\
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

    public static void main(String[] args) {
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
}
