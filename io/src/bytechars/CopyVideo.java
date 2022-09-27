package bytechars;

/*
 * 需求：把指定路径下的视频文件，复制到目的路径下
 *       分别采取一次读写一个字节和一次读取一个字节数组的方式
 * 思路：
 *   1.根据数据源创建字节输入流
 *   2.根据目的地创建字节输出流
 *   3.读写数据
 *   4.释放资源
 * */

import org.junit.Test;

import java.io.*;

public class CopyVideo {

    //一次读写一个字节的方式,不使用Buffered
        /*------耗时3443ms--------*/
    @Test
    public void read() throws Exception {
        long startTime = System.currentTimeMillis();
        //创建字节输入流对象
        FileInputStream fi = new FileInputStream("D:/java/Projects/JavaSummarize/3.mp4");

        //创建字节输出流对象
        FileOutputStream fo = new FileOutputStream("src/bytechars/3.mp4");

        //读写数据
        int b;
        while ((b = fi.read()) != -1) {
            fo.write(b);
        }

        //释放资源
        fi.close();
        fo.close();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime));
    }

    //一次读写一个字节数组，不使用Buffered
        /*------耗时11ms--------*/
    @Test
    public void read2() throws Exception {
        long startTime = System.currentTimeMillis();
        //创建字节输入流
        FileInputStream fi = new FileInputStream("D:/java/Projects/JavaSummarize/3.mp4");

        //创建字节输出流对象
        FileOutputStream fo = new FileOutputStream("src/bytechars/3.mp4");

        //读写数据
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fi.read(bytes)) != -1) {
            fo.write(bytes, 0, len);
        }

        //释放资源
        fi.close();
        fo.close();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime));
    }

    //一次读写一个字节，使用Buffered
        /*------耗时69ms--------*/
    @Test
    public void read3() throws Exception {
        long startTime = System.currentTimeMillis();
        //创建字节输入流对象
        BufferedInputStream br = new BufferedInputStream(new FileInputStream("D:/java/Projects/JavaSummarize/3.mp4"));

        //创建字节输出流对象
        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("src/bytechars/3.mp4"));

        //读写数据
        int b;
        while ((b = br.read()) != -1) {
            bw.write(b);
        }

        //释放资源
        br.close();
        bw.close();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime));
    }

    //一次读写一个字节数组，使用Buffered
            /*------耗时8ms--------*/
    @Test
    public void read4() throws Exception {
        long startTime = System.currentTimeMillis();
        //创建字节输入流对象
        BufferedInputStream br = new BufferedInputStream(new FileInputStream("D:/java/Projects/JavaSummarize/3.mp4"));

        //创建字节输出流对象
        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("src/bytechars/3.mp4"));

        //读写数据
        byte[] bytes = new byte[1024];
        int len;
        while ((len=br.read(bytes)) != -1) {
            bw.write(bytes, 0, len);
        }

        //释放资源
        br.close();
        bw.close();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime));
    }
}
