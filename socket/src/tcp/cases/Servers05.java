package tcp.cases;

/*
* 客户端：数据来自于文本文件，接受服务端反馈
* 服务端：接受到的数据写入文本文件，给出反馈
* */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers05 {
    public static void main(String[] args) throws Exception{
        //创建服务端Socket对象
        ServerSocket ss = new ServerSocket(10000);

        //监听客户端连接
        Socket s = ss.accept();

        //获取Socket对象输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //获取写入文件输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("socket/src/tcp/cases/s.txt"));

        //把数据写入文本文件
        String line;
        while ((line=br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //给出反馈
        BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw2.write("receive Client's file");
        bw2.newLine();
        bw2.flush();

        //释放资源
        bw.close();
        ss.close();
    }
}
