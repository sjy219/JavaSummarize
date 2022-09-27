package tcp.cases;

/*
* 客户端：数据来自于文本文件
* 服务端：接受到的数据写入文本文件
* */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers04 {
    public static void main(String[] args) throws Exception{
        //创建服务端Socket对象
        ServerSocket ss = new ServerSocket(10000);

        //监听客户端连接
        Socket s = ss.accept();

        //获取输入流对象
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //获取文件写入流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("socket/src/tcp/cases/s.txt"));

        //写入数据
        String line;
        while ((line=br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        bw.close();
        ss.close();
    }
}
