package tcp.cases;

/*
 * 客户端：数据来自于文本文件，接受服务端反馈
 * 服务端：将数据写入文本文件，给出反馈，代码用线程进行封装，为每一个客户端开启一个线程
 * */

import java.io.*;
import java.net.Socket;

public class Clients06 {
    public static void main(String[] args) throws Exception {
        //创建客户端Socket对象
        Socket s = new Socket("192.168.42.233", 10000);

        //获取文件输入流对象
        BufferedReader br = new BufferedReader(new FileReader("socket/src/tcp/cases/a.txt"));

        //获取Socket输出流对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        //向Socket对象写入数据
        String line;
        while ((line=br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //给出文件写入完毕信号
        s.shutdownOutput();

        //接受服务端的反馈
        BufferedReader brSer = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println(brSer.readLine());

        //释放资源
        br.close();
        s.close();
    }
}
