package tcp.cases;

/*
* 客户端：发送数据，接受服务器端的反馈
* 服务端：接受数据，给出反馈
* */

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers {
    public static void main(String[] args) throws Exception{
        //创建服务器端的Socket对象
        ServerSocket ss = new ServerSocket(10000);

        //监听客户端连接
        Socket s = ss.accept();

        //获取输入流对象，读取数据，并打印在控制台
        InputStream is = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));

        //发送反馈到客户端
        OutputStream os = s.getOutputStream();
        os.write("已经接受到客户端发来的数据".getBytes());

        //释放资源
//        s.close();
        ss.close();
    }
}
