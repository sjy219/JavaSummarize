package map.cases;

//--------------ArraList集合存储HashMap元素并遍历---------------\\
//需求：创建一个ArrayList集合，存储三个元素，每一个元素都是HashMap,
//每一个HashMap的键和值都是String,并遍历

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArListHashMap {
    public static void main(String[] args) {
        //创建ArrayList集合
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

        //创建HashMap集合，并添加三个元素
        HashMap<String, String> hashMap1 = new HashMap<>();
        HashMap<String, String> hashMap2 = new HashMap<>();
        HashMap<String, String> hashMap3 = new HashMap<>();
        HashMap<String, String> hashMap4 = new HashMap<>();
        hashMap1.put("hello", "world");
        hashMap2.put("docker", "java");
        hashMap3.put("javaee", "javase");
        hashMap4.put("javaee", "javase");

        //把HashMap集合添加到ArrayList集合中
        arrayList.add(hashMap1);
        arrayList.add(hashMap2);
        arrayList.add(hashMap3);
        arrayList.add(hashMap4);

        //遍历ArrayList集合
        for (HashMap<String, String> hs : arrayList) {
            Set<Map.Entry<String, String>> entrySet = hs.entrySet();
            for (Map.Entry<String, String> ms : entrySet) {
                String key = ms.getKey();
                String value = ms.getValue();
                System.out.println(key + "," + value);
            }
        }

    }

}
