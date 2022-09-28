package bytechars;

import org.junit.Test;

import java.io.*;

/*
 * 需求：使用字符流读写文件(一次读写一个字符+字符数组+整行)
 *  InputStreamReader+Writer
 *  FileReader+Writer
 *  BufferedReader+Writer
 * */

public class CopyFileChar {

    //一次读写一个字符
    @Test
    public void read1() throws Exception {
        //创建字符输入流对象
        InputStreamReader rd = new InputStreamReader(new FileInputStream("src/file/file.txt"));

        //创建字符输出流对象
        OutputStreamWriter wr = new OutputStreamWriter(new FileOutputStream("src/bytechars/newfile.txt"));

        //读写数据
        int c;
        while ((c = rd.read()) != -1) {
            wr.write(c);
        }

        //释放资源
        rd.close();
        wr.close();
    }

    //一次读写一个字符数组
    @Test
    public void read2() throws Exception {
        //创建字符输入流对象
        InputStreamReader rd = new InputStreamReader(new FileInputStream("src/file/file.txt"));

        //创建字符输出流对象
        OutputStreamWriter wr = new OutputStreamWriter(new FileOutputStream("src/bytechars/newfile.txt"));

        //读写数据
        char[] chars = new char[1024];
        int len;
        while ((len = rd.read(chars)) != -1) {
            wr.write(chars, 0, len);
        }

        //释放资源
        rd.close();
        wr.close();
    }

    //一次读写一个字符，FileReader版
    @Test
    public void read3() throws Exception {
        //创建字符输入流对象
        FileReader fi = new FileReader("src/file/file.txt");

        //创建字符输出流对象
        FileWriter fw = new FileWriter("src/bytechars/newfile.txt");

        //读写数据
        int c;
        while ((c = fi.read()) != -1) {
            fw.write(c);
        }

        //释放资源
        fi.close();
        fw.close();
    }

    //一次读写一个字符数组，使用FileReader版
    @Test
    public void read4() throws Exception {
        //创建字符输入流对象
        FileReader fi = new FileReader("src/file/file.txt");

        //创建字符输出流对象
        FileWriter fw = new FileWriter("src/bytechars/newfile.txt");

        //读写数据
        char[] chars = new char[1024];
        int len;
        while ((len = fi.read(chars)) != -1) {
            fw.write( chars,0, len);
        }

        //释放资源
        fi.close();
        fw.close();
    }

    //一次读写一行数据,BufferedReader+BufferedWriter
    @Test
    public void read5() throws Exception {
        //创建文件输入流对象
        BufferedReader br = new BufferedReader(new FileReader("src/file/file.txt"));

        //创建文件输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/bytechars/newfile.txt"));

        //读写数据
        String line;
        while ((line=br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        br.close();
        bw.close();


    }

}
