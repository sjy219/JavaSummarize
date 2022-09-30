package collectionss;

//-----------ArrayList存储学生对象并排序-------------\\
    //需求：ArrayList存储学生对象，使用Collections对ArrayList进行排序
    //要求：按照年龄从小到大排序，年龄相同时，按照姓名的字母顺序排序

import java.util.ArrayList;
import java.util.Collections;

public class ArrLiStuSort {
    public static void main(String[] args) {
        //创建学生类

        //创建ArrayList集合
        ArrayList<Students01> arrayList = new ArrayList<>();

        //创建学生对象
        Students01 zhangsan = new Students01("zhangsan", 20);
        Students01 lisi = new Students01("lisi", 19);
        Students01 maliu = new Students01("maliu", 20);
        Students01 wangwu = new Students01("wangwu", 21);

        //添加学生对象进集合
        arrayList.add(zhangsan);
        arrayList.add(lisi);
        arrayList.add(wangwu);
        arrayList.add(maliu);

        //对集合进行排序
        Collections.sort(arrayList);

        //遍历集合，输出到控制台
        for (Students01 st : arrayList) {
            String name = st.getName();
            int age = st.getAge();
            System.out.println(name+ ","+ age);
        }

    }
}
