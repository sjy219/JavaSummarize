package produce_customer;

public class Produces implements Runnable{
    private Box bo;

    public Produces() {
    }

    public Produces(Box bo) {
        this.bo = bo;
    }

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            bo.put(i);
        }
    }
}
