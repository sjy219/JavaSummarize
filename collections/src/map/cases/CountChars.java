package map.cases;

//--------统计字符串中每个字符出现的次数----------\\
//需求：键盘录入一个字符串，要求统计字符串中每个字符出现的次数
//

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountChars {
    public static void main(String[] args) {
        //创建HashMap集合
        HashMap<Character, Integer> hashMap = new HashMap<>();

        //键盘录入中字符串
        Scanner scanner = new Scanner(System.in);
        System.out.println("please insert one strings: ");
        String sInput = scanner.nextLine();


        //遍历字符串
        for (int i = 0; i < sInput.length(); i++) {
            char ch = sInput.charAt(i);
            Integer value = hashMap.get(ch);
            if (value == null) {
                hashMap.put(ch, 1);
            } else {
                value++;
                hashMap.put(ch, value);
            }

        }
        //遍历HashSet集合，并打印数据到控制台
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Character, Integer> ms : entries) {
            Character key = ms.getKey();
            Integer value = ms.getValue();
            sb.append(key).append("(").append(value).append(")");
        }
        System.out.println(sb.toString());
    }
}
