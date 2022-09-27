package multithreading.extendsthread.introduce;

/*多线程的实现方式：
    1.继承Tread类
    --定义一个类MyThread继承Thread类
    --在MyThread类中重写run()方法
    --创建MyThread类的对象
    --启动线程
*/

import org.junit.Test;

public class TestExtendsTreahd {

    public static void main(String[] args) {
            /*-------------设置和获取线程名称-------------*/
//        ExtendsThread thread1 = new ExtendsThread();
//        ExtendsThread thread2 = new ExtendsThread();
//
//        //设置线程名称
//        thread1.setName("sky:");
//        thread2.setName("ocean");

        //使用带参数的构造函数,要在ExtendsThread中创建带参数的构造方法
        //Thread(String name)
//        ExtendsThread oceanThread = new ExtendsThread("ocean");
//        ExtendsThread skyThread = new ExtendsThread("sky");
//
//        oceanThread.start();
//        skyThread.start();

        //static Thread currentThread() 返回当前正在执行的线程对象的引用(main)
        System.out.println(Thread.currentThread().getName());
    }
    //第一次测试
    @Test
    public void run1() {
        ExtendsThread thread1 = new ExtendsThread();
        ExtendsThread thread2 = new ExtendsThread();

        thread1.start();
        thread2.start();
    }





}
