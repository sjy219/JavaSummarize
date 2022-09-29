package properties;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
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
            System.out.println(key + "," + value);
        }
    }

    //---------Object setProperty(String key, String value)----------\\
    //根据指定的key，设置对应的value
    @Test
    public void setP() {
        //创建一个Properties集合，并添加元素
        Properties prop = new Properties();
        prop.put("001", "张三");
        prop.put("002", "李四");
        prop.put("003", "王五");
        System.out.println(prop);
        //遍历properties集合
        Set<Object> keySet = prop.keySet();
        for (Object key : keySet) {
            Object value = prop.get(key);
            System.out.println(key + "," + value);
        }
        System.out.println("---------------------");
        //重新设置其中的键值
        prop.setProperty("002", "马六");

        //遍历properties集合
        Set<Object> keySets = prop.keySet();
        for (Object key : keySets) {
            Object value = prop.get(key);
            System.out.println(key + "," + value);
        }
    }

    //-----------String getProperty(String key)-------------\\
    //获取指定的key对应的value
    @Test
    public void getP() {
        //创建一个Properties集合，并添加元素
        Properties prop = new Properties();
        prop.put("001", "张三");
        prop.put("002", "李四");
        prop.put("003", "王五");
        //遍历properties集合
        Set<Object> keySet = prop.keySet();
        for (Object key : keySet) {
            Object value = prop.get(key);
            System.out.println(key + "," + value);
        }
        System.out.println("---------------------");
        //获取指定的key对应的value
        String prop2 = prop.getProperty("002");
        System.out.println("key002-> value : " + prop2);
    }

    //------------Set<String> stringPropertyNames()--------------\\
    //返回集合中所有的key组成的set集合，key的类型为String
    @Test
    public void strPropNames() {
        //创建一个Properties集合，并添加元素
        Properties prop = new Properties();
        prop.put("001", "张三");
        prop.put("002", "李四");
        prop.put("003", "王五");
        //遍历properties集合
//        Set<Object> keySet = prop.keySet();
//        for (Object key : keySet) {
//            Object value = prop.get(key);
//            System.out.println(key + "," + value);
//        }
//        System.out.println("---------------------");
        //------遍历集合，采用键集的方式------\\
        Set<String> keySset = prop.stringPropertyNames();
        for (String key : keySset) {
            String value = prop.getProperty(key);
            System.out.println(key + "," + value);
        }
    }

    //----void load(Reader reader) + void store(Writer writer,String comments----\\
    @Test
    public void loads() throws Exception{
        //创建Reader对象
        FileReader reader = new FileReader("src/properties/proper.txt");

        //创建prop对象,并load reader对象
        Properties prop = new Properties();
        prop.load(reader);

        //打印prop到控制台
        System.out.println(prop);

        //修改其中的键值对
        prop.setProperty("002", "李逵");

        //创建Write字符写入流
        FileWriter writer = new FileWriter("src/properties/proper.txt");

        //使用store将prop写回proper.txt中
        prop.store(writer, null);

        writer.close();
        reader.close();
    }
}
