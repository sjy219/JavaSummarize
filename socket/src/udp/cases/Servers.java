package udp.cases;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servers {
    public static void main(String[] args) throws Exception {
        //创建接受端Socket对象（DatagramSocket(int port))
        DatagramSocket socket = new DatagramSocket(10000);
        while (true) {
            //创建用于接受数据的数据包
            byte[] bytes = new byte[1024];
            int len = bytes.length;
            DatagramPacket packet = new DatagramPacket(bytes, len);
            //接受数据
            socket.receive(packet);
            //循环解析数据
            byte[] data = packet.getData();
            int length = packet.getLength();
            System.out.println("接受到的数据是： " + new String(data, 0, length));
        }
        //关闭接受流（因为上面是死循环，所以这里直接注释掉）
//        socket.close();
    }
}
