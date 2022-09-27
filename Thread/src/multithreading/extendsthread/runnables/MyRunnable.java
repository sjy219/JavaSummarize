package multithreading.extendsthread.runnables;

/*
* 2.实现Runnable接口
    ---定义一个类MyRunnable实现Runnable接口
    ---在MyRunnable类中重写run()方法
    ---创建MyRunnable类的对象
    ---使用Thread类的对象，把MyRunnable对象作为参数传递
    ---启动线程
* */

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
