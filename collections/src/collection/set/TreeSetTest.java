package collection.set;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        //创建TreeSet集合，无参构造函数
        TreeSet<TreeSetStudents> treeSet = new TreeSet<>();

        //创建学生对象
        TreeSetStudents zhangsan = new TreeSetStudents("zhangsan", 20);
        TreeSetStudents maliu = new TreeSetStudents("maliu", 20);
        TreeSetStudents zhangsan1 = new TreeSetStudents("zhangsan", 22);
        TreeSetStudents lisi = new TreeSetStudents("lisi", 21);
        TreeSetStudents wangwu = new TreeSetStudents("wangwu", 19);

        //把学生对象添加到集合
        treeSet.add(zhangsan);
        treeSet.add(lisi);
        treeSet.add(wangwu);
        treeSet.add(zhangsan1);
        treeSet.add(maliu);


        //遍历集合
        for (TreeSetStudents ts : treeSet) {
            int age = ts.getAge();
            String name = ts.getName();
            System.out.println(name + "," + age);
        }
    }
}
