package multithreading.extendsthread.runnables;

/*
* 2.实现Runnable接口
    ---定义一个类MyRunnable实现Runnable接口
    ---在MyRunnable类中重写run()方法
    ---创建MyRunnable类的对象
    ---使用Thread类的对象，把MyRunnable对象作为参数传递
    ---启动线程
* */

public class TestDemo {
    public static void main(String[] args) {
        //创建MyRunnable对象
        MyRunnable my = new MyRunnable();

        //把my对象作为参数传递给Thread构造函数
//        Thread thread1 = new Thread(my);
//        Thread thread2 = new Thread(my);
        //启动线程
//        thread1.start();
//        thread2.start();

        //使用带参数名的构造方法
        Thread skyThread = new Thread(my, "sky");
        Thread oceanThread = new Thread(my, "ocean");

        //启动线程
        skyThread.start();
        oceanThread.start();


    }
}
