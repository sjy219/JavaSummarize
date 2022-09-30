package collectionss;

public class Students01 implements Comparable<Students01>{
    private String name;
    private int age;

    public Students01(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Students01 s) {
        int num = this.age - s.age;//s代表s1; this代表s2
        int num2 = num==0?this.name.compareTo(s.name):num;
        return num2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
