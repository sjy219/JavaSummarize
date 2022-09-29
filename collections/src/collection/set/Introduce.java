package collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Introduce {

    //-------------创建set集合并遍历-----------\\
    @Test
    public void setS() {
        //创建set集合对象，并添加元素
        Set<String> set = new HashSet<String>();
        set.add("hello");
        set.add("world");
        set.add("java");
        set.add("world");

        //-------遍历set集合1------\\
            //---增强for---\\
//        for (String ss : set) {
//            System.out.println(ss);
//        }

        //-------遍历set集合2------\\
            //---迭代器---\\
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String sNext = iterator.next();
            System.out.println(sNext);
        }

    }
}
