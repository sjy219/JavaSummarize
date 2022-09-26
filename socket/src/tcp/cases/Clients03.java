package tcp.cases;

/*
* 客户端：数据来自于键盘录入，直到输入的数据为886，发送数据结束
* 服务端：接受到的数据写入文本文件
*
* */

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Clients03 {
    public static void main(String[] args) throws Exception{
        //创建客户端Socket对象
        Socket s = new Socket("192.168.42.233", 10000);
        //封装键盘录入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //获取输出流对象，写入数据，并判断写入的数据是否是886
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line=br.readLine()) != null) {
            if ("886".equals(line)) {
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        br.close();
        s.close();
    }
}
