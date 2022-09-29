package collection.set;

public class TreeSetStudents implements Comparable<TreeSetStudents>{
    private String name;
    private int age;

    @Override
    public int compareTo(TreeSetStudents t) {
        int num = this.age - t.age;
        int num2 = num==0?this.name.compareTo(t.name):num;
        return num2;
    }

    public TreeSetStudents() {
    }

    public TreeSetStudents(String name, int age) {
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

}
