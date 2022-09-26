package udp.introduce;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 发送数据的步骤
 *   1.创建发送端的Socket对象（DatagramSocket）
 *   2.创建数据，并把数据打包
 *   3.调用DatagramSocket对象的方法发送数据
 *   4.关闭发送端
 *
 * */


public class Sends {
    public static void main(String[] args) throws Exception{
        //创建发送端的Socket对象(DatagramSocket)
        DatagramSocket socket = new DatagramSocket();
        //创建数据，并把数据打包，
        // DatagramPacket(byte[] buf, int length, InetAddress address, int port)
        byte[] bytes = "helloworld".getBytes();
        int len = bytes.length;
        InetAddress address = InetAddress.getByName("192.168.42.233");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes, len, address, port);

        //发送数据
        //void send(DatagramPacket p)从此套接字发送数据包
        socket.send(dp);
        //关闭发送数据流
        socket.close();
    }
}
