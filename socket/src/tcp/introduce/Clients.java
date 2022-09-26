package tcp.introduce;

import java.io.OutputStream;
import java.net.Socket;

/*
 * 发送数据的步骤：
 *   1.创建客户端的Socket对象（Socket)
 *       Socket(String host, int port)
 *   2.获取输出流，写数据
 *       OutputStream getOutputStream()
 *   3.释放资源
 *       void close()
 * */

public class Clients {
    public static void main(String[] args) throws Exception{
        //创建客户端Socket对象
        Socket socket = new Socket("192.168.42.233", 10000);

        //获取输出流，写数据
        OutputStream os = socket.getOutputStream();
        os.write("hello Server".getBytes());

        //释放资源
        os.close();
        socket.close();
    }
}
