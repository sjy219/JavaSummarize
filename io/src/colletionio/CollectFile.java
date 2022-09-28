package colletionio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CollectFile {

    //------------集合到文件------------\\
    @Test
    public void coltofile() throws Exception {
        //创建Arraylist集合对象，并添加集合数据
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hello");
        arrayList.add("world");
        arrayList.add("java");

        //创建文件输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/colletionio/newfile.txt"));

        //遍历集合，把集合中的数据写入文件
        for (String ss : arrayList) {
            bw.write(ss);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        bw.close();
    }

    //------------文件到集合------------\\
    @Test
    public void filetocoll() throws Exception {
        //创建ArrayList集合对象
        ArrayList<String> arrayList = new ArrayList<>();

        //创建文件输入流
        BufferedReader br = new BufferedReader(new FileReader("src/colletionio/newfile.txt"));

        //把文件中的数据写入集合
        String line;
        while ((line = br.readLine()) != null) {
            arrayList.add(line);
        }
        //遍历集合，将集合数据打印到控制台
        for (String ss : arrayList) {
            System.out.println(ss);
        }

        //释放资源
        br.close();

    }

    //----------------集合到文件改进版-----------------\\
    @Test
    public void colToFilePro() throws Exception {
        //创建ArrayList集合
        ArrayList<Students> arrayList = new ArrayList<>();

        //创建学生对象，并赋值
        Students st1 = new Students(10, "zhangsan", 20, "hebeishen");
        Students st2 = new Students(11, "lisi", 20, "hebeishen");
        Students st3 = new Students(12, "wangwu", 20, "hebeishen");

        //把学生对象放入集合中去
        arrayList.add(st1);
        arrayList.add(st2);
        arrayList.add(st3);

        //创建文件输入流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/colletionio/newfile.txt"));

        //把集合中的数据写入文件中
        for (Students ss : arrayList) {
            StringBuilder sb = new StringBuilder();
            sb.append(ss.getId()).append(",")
                    .append(ss.getName()).append(",")
                    .append(ss.getAge()).append(",")
                    .append(ss.getAddress());
            String sbs = sb.toString();
            bw.write(sbs);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        bw.close();
    }

    //--------------文件到集合改进版------------------
        //把文本文件中的数据读取到集合中，并遍历集合，
        //要求文件中没一行数据是学生对象的成员变量值
    @Test
    public void fileToColl() throws Exception {
        //创建ArrayList集合
        ArrayList<Students> arrayList = new ArrayList<>();

        //创建文件输入流对象
        BufferedReader br = new BufferedReader(new FileReader("src/colletionio/newfile.txt"));

        //读写数据，把文件流中的数据写入集合中
        String line;
        while ((line=br.readLine()) != null) {
            String[] split = line.split(",");
            Students st = new Students(Integer.parseInt(split[0]), split[1], Integer.parseInt(split[2]), split[3]);
            arrayList.add(st);
        }
        //释放资源
        br.close();
    }


}
