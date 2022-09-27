package tcp.cases;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers06Thread implements Runnable {

    private Socket s = null;

    public Servers06Thread() {
    }

    public Servers06Thread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            //监听客户端连接
//            Socket s = ss.accept();

            //文件名的处理
            int i = 1;
            File file = new File("socket/src/tcp/cases/s" + i + ".txt");
            while (file.exists()) {
                i++;
                file = new File("socket/src/tcp/cases/s" + i + ".txt");
            }

            //获取文件写入流对象
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            //获取Socket输入流对象
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

            //写入数据到文本文件
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }


            //给出服务器端的反馈
            BufferedWriter bwSer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bwSer.write("receive Clients file");
            bwSer.newLine();
            bwSer.flush();
            //释放资源
//            bw.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
