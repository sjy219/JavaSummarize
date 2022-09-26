package udp.introduce;

/*
 * 接受数据的步骤
 *   1.创建接受端的Socket对象(DatagramSocket)
 *      DatagramSocket(int port)
 *   2.创建一个数据包,用于接受数据
 *      DatagramPacket(byte[] buf, int length)
 *   3.调用DatagramSocket对象的方法接受数据
 *      void receive(DatagramPacket p)
 *   4.解析数据包，并把数据打印到控制台
 *      byte[] getData()
 *      int getLength()
 *   5.关闭接受数据流
 *      void close();
 * */


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Recevies {
    public static void main(String[] args) throws Exception {
        //创建接受端Socekt对象
        DatagramSocket socket = new DatagramSocket(10000);

        //创建一个数据包，用于接受数据
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        //调用DatagramSocket对象的方法接受数据
        socket.receive(dp);
        //解析数据包，并打印控制台
        //byte[] getData()返回数据缓冲区
        byte[] data = dp.getData();

        //获取实际接受的数据包的长度getLength()
        int len = dp.getLength();

        //打印控制台
        System.out.println("数据是: " + new String(data, 0, len));

        //关闭接受数据流
        socket.close();
    }
}
