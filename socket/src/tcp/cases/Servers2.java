package tcp.cases;

/*
 * 客户端：数据来自于键盘输入，直到输入的数据是886，发送数据结束
 * 服务端：接受到的数据在控制台输出
 * */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers2 {
    public static void main(String[] args) throws Exception {
        //创建服务端Sockert对象
        ServerSocket ss = new ServerSocket(10000);

        //监听客户端连接
        Socket s = ss.accept();

        //获取输入流，读取数据，并打印到控制台
//        InputStream is = s.getInputStream();
//        byte[] bytes = new byte[1024];
//        int len;
//        while ((len = is.read(bytes)) != -1) {
//            //把读入的数据打印到控制台
//            System.out.println(new String(bytes, 0, len));
//        }

        //获取输入流，读数据，并打印到控制台，用BufferedReader来实现
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while ((line=br.readLine()) != null) {
            System.out.println(line);
        }

        //释放资源
        ss.close();
    }
}
