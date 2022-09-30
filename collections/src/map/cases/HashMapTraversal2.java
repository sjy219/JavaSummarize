package map.cases;

//需求：创建一个HashMap集合，键是学生对象(Students01),值是居住地(String),存储多个键值对元素，并遍历
//要求保证键的唯一性(重写学生类中的2个方法)，如果学生对象成员变量值相同，我们就认为是同一个对象
//使用学生类Students01

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTraversal2 {
    public static void main(String[] args) {
        //创建学生类

        //创建HashMap集合
        HashMap<Students01, String> hashMap = new HashMap<>();

        //创建学生对象
        Students01 zhangsan = new Students01("zhangsan", 20);
        Students01 lisi = new Students01("lisi", 22);
        Students01 wangwu = new Students01("wangwu", 20);
        Students01 wangwu2 = new Students01("wangwu", 20);

        //添加学生对象进集合
        hashMap.put(zhangsan, "beijing");
        hashMap.put(lisi, "wuhan");
        hashMap.put(wangwu, "luoyang");
        hashMap.put(wangwu2, "taizhou");

        //遍历集合（2种方式）
        //----------方式1keySet()----------\\
//        Set<Students01> keySet = hashMap.keySet();
//        for (Students01 st : keySet) {
//            String name = st.getName();
//            int age = st.getAge();
//            String value = hashMap.get(st);
//            System.out.println(name + "," + age + "," + value);
//        }

        //----------方式2entrySet()--------\\
        Set<Map.Entry<Students01, String>> entrySet = hashMap.entrySet();
        for (Map.Entry<Students01, String> ms : entrySet) {
            Students01 key = ms.getKey();
            String name = key.getName();
            int age = key.getAge();
            String value = ms.getValue();
            System.out.println(name + "," + age + "," + value);
        }
    }
}
