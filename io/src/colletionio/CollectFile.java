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
    public void filetocoll() throws Exception{
        //创建ArrayList集合对象
        ArrayList<String> arrayList = new ArrayList<>();

        //创建文件输入流
        BufferedReader br = new BufferedReader(new FileReader("src/colletionio/newfile.txt"));

        //把文件中的数据写入集合
        String line;
        while ((line=br.readLine()) != null) {
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
    public void colToFilePro() throws Exception{
        //创建ArrayList集合
        ArrayList<Students> arrayList = new ArrayList<>();

        //创建学生对象，并赋值
        Students st1 = new Students();
        st1.setId(10);
        st1.setName("张三");
        st1.setAge(20);
        st1.setAddress("Big Street");
        Students st2 = new Students();
        st2.setId(11);
        st2.setName("张三si");
        st2.setAge(20);
        st2.setAddress("Big Street");
        Students st3 = new Students();
        st3.setId(12);
        st3.setName("张si");
        st3.setAge(22);
        st3.setAddress("Big Street");

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

}
