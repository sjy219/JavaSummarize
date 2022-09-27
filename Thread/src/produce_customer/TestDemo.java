package produce_customer;

public class TestDemo {
    public static void main(String[] args) {
        //创建Box对象
        Box box = new Box();

        //实现生产者和消费真对象
        Produces pro = new Produces(box);
        Customer cust = new Customer(box);

        //创建线程对象
        Thread prod = new Thread(pro, "生产者");
        Thread cut = new Thread(cust, "消费者");

        prod.start();
        cut.start();

    }
}
