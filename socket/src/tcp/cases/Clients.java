package tcp.cases;

/*
 * 客户端：发送数据，接受服务器端的反馈
 * 服务端：接受数据，给出反馈
 * */

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Clients {
    public static void main(String[] args) throws Exception {
        //创建客户端Socket对象
        Socket socket = new Socket("192.168.42.233", 10000);

        //获取输出流对象，写数据
        OutputStream os = socket.getOutputStream();
        os.write("我来自于客户端".getBytes());

        //获取输入流对象，接受服务端给出的反馈
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));

        //释放资源
        socket.close();
    }
}
