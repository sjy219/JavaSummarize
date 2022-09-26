package tcp.introduce;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 接受数据的步骤
 *   1.创建服务器端的Socket对象（ServerSocket）
 *   2.获取输入流，读数据，并把数据显示在控制台
 *   3.释放资源
 * */
public class Servers {
    public static void main(String[] args) throws Exception {
        //创建服务器端的Socket对象
        ServerSocket ss = new ServerSocket(10000);

        //监听客户端连接
        Socket s = ss.accept();

        //获取输入流对象，读取数据，并打印在控制台
        InputStream is = s.getInputStream();
        byte[] bytes = new byte[1024];

        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));

        //释放资源
        s.close();
        ss.close();
    }
}
