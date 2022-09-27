package multithreading.extendsthread.priority;

public class TestDemo {
    public static void main(String[] args) {
        MyThread my1 = new MyThread();
        MyThread my2 = new MyThread();

//        my1.start();
//        my2.start();
        System.out.println(my1.getPriority());
        System.out.println(my2.getPriority());
    }
}
