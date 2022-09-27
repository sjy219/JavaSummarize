package tcp.cases;

/*
 * 客户端：数据来自于文本文件
 * 服务端：接受到的数据写入文本文件
 * */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Clients04 {
    public static void main(String[] args) throws Exception{
        //创建客户端Socket对象
        Socket s = new Socket("192.168.42.233", 10000);

        //获取Socket写入流对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        //获取文件读入流对象
        BufferedReader br = new BufferedReader(new FileReader("socket/src/tcp/cases/a.txt"));

        //把数据写入Socket流
        String line;
        while ((line=br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        br.close();
        s.close();
    }
}
