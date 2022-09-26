package udp.cases;

/*
* 按照下面的要求实现程序
* UDP发送数据，数据来自于键盘录入，直到输入的数据是886，发送数据结束
* UDP接受数据，因为接受端不知道发送端什么时间停止发送数据，所以采用while死循环
* */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Clients {
    public static void main(String[] args) throws Exception{
        //创建发送端的Socket对象Datagram()
        DatagramSocket socket = new DatagramSocket();

        //封装键盘录入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line=br.readLine()) != null) {
            if ("886".equals(line)) {
                break;
            }
            //创建发送数据包
            byte[] bytes = line.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
                    InetAddress.getByName("192.168.42.233"), 10000);
            //发送数据
            socket.send(packet);
        }
        //关闭发送流
        socket.close();
    }

}
