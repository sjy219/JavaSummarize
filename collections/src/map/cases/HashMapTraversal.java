package map.cases;

//--------创建一个HashMap集合，键是学号（String),值是学生对象------\\
//使用Stundets01学生类，存储三个键值对元素，并遍历

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTraversal {
    public static void main(String[] args) {
        //创建学生类

        //创建HashMap集合
        HashMap<String, Students01> hashMap = new HashMap<>();

        //创建学生对象
        Students01 zhangsan = new Students01("zhangsan", 20);
        Students01 lisi = new Students01("lisi", 21);
        Students01 wangwu = new Students01("wangwu", 21);

        //添加学生对象到集合
        hashMap.put("0001", zhangsan);
        hashMap.put("0002", lisi);
        hashMap.put("0003", wangwu);

        //遍历集合（2种方式）
        //-------方式1(keySet())----------\\
//        Set<String> keySet = hashMap.keySet();
//        for (String key : keySet) {
//            Students01 value = hashMap.get(key);
//            String name = value.getName();
//            int age = value.getAge();
//            System.out.println(name+ "," + age);
//        }

        //---------方式2entrySet()---------\\
        Set<Map.Entry<String, Students01>> entrySet = hashMap.entrySet();
        for (Map.Entry<String, Students01> ms : entrySet) {
            String key = ms.getKey();
            Students01 value = ms.getValue();
            String name = value.getName();
            int age = value.getAge();
            System.out.println(name + "," + age);
        }

    }
}
