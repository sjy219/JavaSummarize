package properties;

import java.util.Properties;
import java.util.Set;

public class introduce {
    public static void main(String[] args) {
        //创建一个Properties对象
        Properties prop = new Properties();

        //添加元素
        prop.put("001", "张三");
        prop.put("002", "李四");

        //遍历prop打印到控制台
        Set<Object> keySet = prop.keySet();
        for (Object key : keySet) {
            //利用键key获得对应的值value
            Object value = prop.get(key);
            System.out.println(key + ","+value);
        }
    }
}
