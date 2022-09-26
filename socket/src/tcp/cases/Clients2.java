package tcp.cases;

/*
 * 客户端：数据来自于键盘输入，直到输入的数据是886，发送数据结束
 * 服务端：接受到的数据在控制台输出
 * */

import java.io.*;
import java.net.Socket;

public class Clients2 {
    public static void main(String[] args) throws Exception{
        //创建客户端Socket对象
        Socket s = new Socket("192.168.42.233", 10000);

        //封装键盘录入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //获取输出流，写数据，写入的数据是886，输入结束
//        OutputStream os = s.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line=br.readLine()) != null) {
            //写数据，并判断数据是否是886
            if ("886".equals(line)) {
                break;
            }
//            os.write(line.getBytes());
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        s.close();
        br.close();
        bw.close();
    }
}
