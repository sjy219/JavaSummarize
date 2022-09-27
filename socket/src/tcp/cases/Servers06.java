package tcp.cases;

/*
 * 客户端：数据来自于文本文件，接受服务端反馈
 * 服务端：将数据写入文本文件，给出反馈，代码用线程进行封装，为每一个客户端开启一个线程
 * */

import java.net.ServerSocket;
import java.net.Socket;

public class Servers06 {
    public static void main(String[] args) throws Exception {
        //创建服务端Socket对象
        ServerSocket ss = new ServerSocket(10000);



        while (true) {
            //监听客户端连接
            Socket s = ss.accept();

            //为客户端连接准备线程
            Servers06Thread servers06Thread = new Servers06Thread(s);

            //新建线程
            Thread thread = new Thread(servers06Thread);

            //开启线程
            thread.start();
        }


//        while (true) {
//
//        }
    }
}
