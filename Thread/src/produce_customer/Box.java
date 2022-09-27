package produce_customer;

public class Box {
    private static int milk = 0;
    private boolean status = false;

    public synchronized void get() {
        if (!status) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("这是消费者拿走的第： " + this.milk + "瓶奶");
        status = false;
        notifyAll();
    }

    public synchronized void put(int milk) {
        if (status) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.milk = milk;
        System.out.println("这是生产者放置的第 " + this.milk + "瓶奶");
        status = true;
        notifyAll();
    }
}
