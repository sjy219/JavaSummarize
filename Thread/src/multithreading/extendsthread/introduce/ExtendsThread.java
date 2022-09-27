package multithreading.extendsthread.introduce;

/*多线程的实现方式：
    1.继承Tread类
    --定义一个类MyThread继承Thread类
    --在MyThread类中重写run()方法
    --创建MyThread类的对象
    --启动线程
*/

public class ExtendsThread extends Thread{
    /*------------设置和获取线程名称----------*/
    /*
    private String name;
    public ExtendsThread() {
    }
    //给线程创建时赋值名字使用的
    public ExtendsThread(String name) {
        super(name);
    }

    //设置和获取线程名称

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
    */


    /*--------------第一次测试--------------*/
    /*
    @Override
    public void run() {
        for (int i = 0; i < 99; i++) {
            System.out.println(i);
        }
    }
    */


}
