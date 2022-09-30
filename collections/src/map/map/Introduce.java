package map.map;

import java.util.HashMap;
import java.util.Map;

public class Introduce {
    public static void main(String[] args) {
        //创建Map集合
        Map<String, String> mps = new HashMap<>();

        //存储数据
        mps.put("zhangsan", "wife");
        mps.put("lisi", "girl");
        String wang = mps.put("wangwu", "hansband");
        mps.put("lisi", "hansband");

        //打印Map集合
        System.out.println(mps);
    }
}
