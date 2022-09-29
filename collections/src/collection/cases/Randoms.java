package collection.cases;

import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

//------需求：编写一个程序，获取10个1-20之间的随机数，要求随机数不重复，并在控制台输出-----\\\
public class Randoms {

    @Test
    public void randoms() {
        //创建HashSet集合
        HashSet<Integer> hashSet = new HashSet<>();

        //创建随机数对象
        Random rd = new Random();

        //判断HashSet集合的长度是否=10
        while (hashSet.size() < 10) {
            int rds = rd.nextInt(20) + 1;
            hashSet.add(rds);
        }
        System.out.println(hashSet);
    }
}
