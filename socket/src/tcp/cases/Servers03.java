package tcp.cases;

/*
 * 客户端：数据来自于键盘录入，直到输入的数据为886，发送数据结束
 * 服务端：接受到的数据写入文本文件
 *
 * */

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers03 {
    public static void main(String[] args) throws Exception{
        //创建服务端Socket对象
        ServerSocket ss = new ServerSocket(10000);

        //监听客户端连接
        Socket s = ss.accept();

        //获取文件写入流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("socket/src/tcp/cases/a.txt"));

        //获取输入流对象
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //接受数据，并写入到文件
        String line;
        while((line=br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        bw.close();
        ss.close();
    }

    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));
    }
}
