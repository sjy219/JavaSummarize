package colletionio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

//----------------集合到文件（数据排序改进版）---------------\\
//需求：键盘录入5个学生信息（姓名，语文成绩，数学成绩，英语成绩）。要求按照成绩总分由高到低写入文本文件
//使用StudentsTotal类
//如果上面4个信息都相同，那就再增加一个字段“学号”，此字段是唯一的

public class CollToFileSorted {
    public static void main(String[] args) throws Exception {
        TreeSet<StudentsTotal> treeSet = new TreeSet<>(new Comparator<StudentsTotal>() {
            @Override
            public int compare(StudentsTotal s1, StudentsTotal s2) {
                int num = s2.sum() - s1.sum();
                int num2 = num == 0 ? s2.getEnglish() - s1.getEnglish() : num;
                int num3 = num2 == 0 ? s2.getMath() - s1.getMath() : num2;
                return num3 == 0 ? s2.getName().compareTo(s1.getName()) : num3;
            }
        });
        //录入数据赋值给学生对象，并存入集合

        //-------------原版录入学生信息------------\\
            /*
        for (int i = 0; i < 2; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请录入学生 " + (i + 1) + "的信息");
            System.out.println("学生" + (i + 1) + "的姓名： ");
            String name = sc.nextLine();
            System.out.println("学生" + name + "的语文成绩： ");
            int chinese = sc.nextInt();
            System.out.println("学生" + name + "的数学成绩： ");
            int math = sc.nextInt();
            System.out.println("学生" + name + "的英语成绩： ");
            int english = sc.nextInt();
            //创建学生对象
            StudentsTotal st = new StudentsTotal(name, chinese, math, english);
            treeSet.add(st);
            }
            */
        //-------------改进录入学生信息------------\\
        //封装键盘录入，一次读写数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int j = 0; j < 2; j++) {
            System.out.println("请输入第" + (j + 1) + "个学生的信息，格式为:(姓名/语文成绩/数学成绩/英语成绩)");
            String line;
            if ((line=br.readLine()) != null) {
                String [] split = line.split("/");
                StudentsTotal st = new StudentsTotal();
                st.setName(split[0]);
                st.setChinese(Integer.parseInt(split[1]));
                st.setMath(Integer.parseInt(split[2]));
                st.setEnglish(Integer.parseInt(split[3]));
                treeSet.add(st);
            }

        }

        //创建文件字符输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("io/src/colletionio/newfile2.txt"));

        //把集合中的数据写入文件
        for (StudentsTotal ss : treeSet) {
            StringBuilder sb = new StringBuilder();
            sb.append(ss.getName()).append(",")
                    .append(ss.getChinese()).append(",")
                    .append(ss.getMath()).append(",")
                    .append(ss.getEnglish()).append(",")
                    .append(ss.sum());
            String sbs = sb.toString();
            bw.write(sbs);
            bw.newLine();
            bw.flush();
        }
        //释放资源
        bw.close();

    }
}
