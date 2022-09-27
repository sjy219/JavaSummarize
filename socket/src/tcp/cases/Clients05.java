package tcp.cases;

/*
 * 客户端：数据来自于文本文件，接受服务端反馈
 * 服务端：接受到的数据写入文本文件，给出反馈
 * */

import java.io.*;
import java.net.Socket;

public class Clients05 {
    public static void main(String[] args) throws Exception{
        //创建客户端Socket对象
        Socket s = new Socket("192.168.42.233", 10000);

        //获取Socket输出流对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        //获取文件输入流对象
        BufferedReader br = new BufferedReader(new FileReader("socket/src/tcp/cases/a.txt"));

        //向Socket输入流对象写入数据
        String line;
        while ((line=br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //给服务端发送文件传输完成信号
        s.shutdownOutput();

        //接受服务端的反馈
        BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println(br2.readLine());

        //释放资源
        br.close();
        s.close();
    }
}
