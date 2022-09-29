package collection.set;

import java.util.LinkedHashSet;

//----------------* 利用哈希表存储字符串并遍历 *----------------\\
public class LinkedHashSets {
    public static void main(String[] args) {
        //创建LinkedHashSet集合,并添加数据
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("java");
        hashSet.add("hello");

        //遍历集合
        for (String ss : hashSet) {
            System.out.println(ss);
        }

    }
}
