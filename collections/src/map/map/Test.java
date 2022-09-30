package map.map;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("hello", "world");

        PrintStream ps = new PrintStream("collections/src/map/test.txt");

        byte[] bytes = new byte[1024];
        int lent;
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        for (Map.Entry<String, String> mp : entrySet) {
            ps.println(mp);
        }
        ps.close();
    }
}
