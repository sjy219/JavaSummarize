package map.cases;

//-----------HashMap集合存储ArrayLIst集合------------\\
    //需求：创建一个HashMap集合，存储三个键值对元素，每一个键值对元素的键是String,值是ArrayList
    //每一个ArrayList的元素是String,并遍历

import org.junit.Test;

import java.util.*;

public class HashMapArList {
    public static void main(String[] args) {
        //创建HashSet集合
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        //创建ArrayList集合，并添加元素
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("javaee");
        arrayList2.add("world");
        arrayList2.add("html");
        arrayList3.add("java");
        arrayList3.add("python");

        //把ArrayList添加到HashMap集合
        hashMap.put("001", arrayList);
        hashMap.put("002", arrayList2);
        hashMap.put("003", arrayList3);

        //遍历HashMap集合
        Set<Map.Entry<String, ArrayList<String>>> entrySet = hashMap.entrySet();
        for (Map.Entry<String, ArrayList<String>> ms : entrySet) {
            String key = ms.getKey();
            ArrayList<String> value = ms.getValue();
            for (String ss : value) {
                System.out.println(key + "," + ss);
            }
        }

    }

    //-------------LinkedHashSet------------\\
        //不需要重写equals和hashCode()方法
    @Test
    public void linkSets() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("hello");
        linkedHashSet.add("world");
        linkedHashSet.add("world");

        System.out.println(linkedHashSet);

    }

    //------------treeSet--------------\\
        //不需要重写equals和hashCode方法
    @Test
    public void treeset() {
        TreeSet<Integer> it = new TreeSet<>();

        it.add(10);
        it.add(20);
        it.add(30);
        it.add(10);
        System.out.println(it);
    }
}
