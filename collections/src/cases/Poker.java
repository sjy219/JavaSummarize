package cases;

        //------------------------------模拟斗地主------------------------------\\
            //需求：通过程序实现斗地主过程中的洗牌，发牌和看牌

import java.util.ArrayList;
import java.util.Collections;

public class Poker {
    public static void main(String[] args) {
        //创建ArrayList集合
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> underPoker = new ArrayList<>();

        //创建3个数组，分别用来保存牌面的花色和点数，还有底牌
        String[] colors = {"a", "b", "c", "d"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "k", "A", "2"};

        //将花色和点数互相组合，结果存入ArrayList集合，单独增加大王小王
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                String poker = colors[i] + numbers[j];
                arrayList.add(poker);
            }
        }
        arrayList.add("sKing");
        arrayList.add("LKing");

        //调用Collections的shuffle（）方法洗牌
        Collections.shuffle(arrayList);

        //留存3张底牌，发牌
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (size - i <= 3) {
                underPoker.add(arrayList.get(i));
            } else {
                if (i % 3 == 0) {
                    player1.add(arrayList.get(i));
                } else if (i % 3 == 1) {
                    player2.add(arrayList.get(i));
                } else if (i % 3 == 2) {
                    player3.add(arrayList.get(i));
                }
            }
        }

        //遍历看牌
        System.out.print("player1: ");
        for (String ss : player1) {
            System.out.print(ss + " ");
        }

        System.out.println(player1.size());
        System.out.print("player2: ");
        for (String ss : player2) {
            System.out.print(ss + " ");
        }
        System.out.println(player2.size());
        System.out.print("player3: ");
        for (String ss : player3) {
            System.out.print(ss + " ");
        }
        System.out.println(player3.size());
        System.out.print("underPoker: ");
        for (String ss : underPoker) {
            System.out.print(ss + " ");
        }

    }
}
