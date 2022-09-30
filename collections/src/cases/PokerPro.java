package cases;

//------------------模拟斗地主升级版--------------------\\
//需求：通过程序实现斗地主过程中的洗牌，发牌和看牌，
//要求： 对看牌的结果进行排序

import java.util.*;

public class PokerPro {
    public static void main(String[] args) {
        //创建HashMap当作牌盒
        HashMap<Integer, String> hashMap = new HashMap<>();

        //创建2个字符串数组，分别用来存储点数和花色
        String[] colors = {"a", "b", "c", "d"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "k", "A", "2"};

        //创建ArrayList集合用来存入HashMap的key
        ArrayList<Integer> arrayList = new ArrayList<>();

        //对点数和花色进行组合,并加入大王和小王
        Integer key = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                String poker = colors[j] + numbers[i];
                //将组合结果当作HashMap的值，HashMap的键，使用自然序号123...，并把键存入ArrayList集合
                key++;
                hashMap.put(key, poker);
                arrayList.add(key);
            }
        }
        //insert sKing and lKing
        key++;
        hashMap.put(key, "sKing");
        arrayList.add(key);
        key++;
        hashMap.put(key, "lKing");
        arrayList.add(key);

        //创建ArrayList集合，将HashMap的key存入ArrayList集合中
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        Set<Integer> keySet = hashMap.keySet();
//        for (Integer it : keySet) {
//            arrayList.add(it);
//        }
        //洗牌,使用Collections的shuffle()方法对ArrayList进行处理
        Collections.shuffle(arrayList);

        //创建4个TreeSet集合，分别用来存储3位玩家和底牌
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();
        TreeSet<Integer> underPoker = new TreeSet<>();
//        TreeSet<Integer> player1 = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer I1, Integer I2) {
//                return I1 - I2;
//            }
//        });
//        TreeSet<Integer> player2 = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer I1, Integer I2) {
//                return I2 - I1;
//            }
//        });
//        TreeSet<Integer> player3 = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer I1, Integer I2) {
//                return I2 - I1;
//            }
//        });
//        TreeSet<Integer> underPoker = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer I1, Integer I2) {
//                return I2 - I1;
//            }
//        });


        //发牌
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (size - i <= 3) {
                underPoker.add(arrayList.get(i));
            } else if (i % 3 == 0) {
                player1.add(arrayList.get(i));
            } else if (i % 3 == 1) {
                player2.add(arrayList.get(i));
            } else if (i % 3 == 2) {
                player3.add(arrayList.get(i));
            }
        }

//---------------把看牌写成一个方法-----------------\\
        //看牌，遍历TreeSet集合，把遍历的结果当作键到HashMap中寻找对应的值
        look("player1: ", player1, hashMap);
        look("player2: ", player2, hashMap);
        look("player3: ", player3, hashMap);
        look("underPoker: ", underPoker, hashMap);
//        System.out.print("player1: ");
//        for (Integer it : player1) {
//            String pokers = hashMap.get(it);
//            System.out.print(pokers + " ");
//        }
//        System.out.println(player1.size());
//
//        System.out.print("player2: ");
//        for (Integer it : player2) {
//            String pokers = hashMap.get(it);
//            System.out.print(pokers + " ");
//        }
//        System.out.println(player2.size());
//
//        System.out.print("player3: ");
//        for (Integer it : player3) {
//            String pokers = hashMap.get(it);
//            System.out.print(pokers + " ");
//        }
//        System.out.println(player3.size());
//
//        System.out.print("underPoker: ");
//        for (Integer it : underPoker) {
//            String pokers = hashMap.get(it);
//            System.out.print(pokers + " ");
//        }

    }
    public static void look(String name, TreeSet<Integer> t, HashMap<Integer, String> hp) {
        System.out.print(name + ": ");
        for (Integer it : t) {
            String pokers = hp.get(it);
            System.out.print(pokers + " ");
        }
        System.out.println(t.size());
    }
}
