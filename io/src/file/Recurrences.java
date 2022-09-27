package file;

/*
 * 需求：利用递归求5阶乘
 * */

public class Recurrences {
    public static void main(String[] args) {
        System.out.println(recu(5));
    }

    public static int recu(int x) {
        if (x == 1) {
            return 1;
        } else {
            return x * recu(x - 1);
        }
    }
}
