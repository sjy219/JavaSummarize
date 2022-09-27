package bytechars;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile01 {

    /*
    * --------一次读写一个字节的方式，复制文件----------
    * 要求：把bytechars模块下的cp01.txt,复制到cp01-1.txt
    * 分析：
    *   1.复制文本文件，其实就是把文本文件的内容从一个文件中读取出来（数据源），然后写入到另一个文件中（目的地）
    *   2.数据源：
    *       bytechars/cp01.txt->读数据->InputStream->FileInputStream
    *   3.目的地：
    *       bytechars/cp01-1.txt->写数据->OutputStream->FileOutputStream
    * */
    @Test
    public void copy() throws Exception{
        //获取文件输入流对象
        FileInputStream fi = new FileInputStream("src/bytechars/cp01.txt");

        //获取文件输出流对象
        FileOutputStream fo = new FileOutputStream("src/bytechars/cp01-1.txt");

        //写入数据
        int b;
        while ((b=fi.read()) != -1){
            fo.write(b);
        }

        //释放资源
        fi.close();
        fo.close();
    }




}
