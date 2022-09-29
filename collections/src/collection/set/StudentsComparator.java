package collection.set;

public class StudentsComparator {
    private String name;
    private int age;

    public StudentsComparator() {
    }

    public StudentsComparator(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentsComparator{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
