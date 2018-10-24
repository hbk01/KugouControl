package cn.hbkcn.kugou;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Create at 2018-8-7 12:01 by 3243430237@qq.com
// TODO: 与手机通讯
public class KCP {
    /**
     * 接收消息监听器
     */
    public interface ReceiveListener{
        void read(String code);
    }

    // 服务端
    public static class Receiver implements Runnable {
        public int port;
        public ReceiveListener listener;

        public Receiver(int port, ReceiveListener listener) {
            this.port = port;
            this.listener = listener;
        }

        @Override
        public void run() {
            try {
                ServerSocket server = new ServerSocket(port);
                while (true) {
                    // waiting socket requests
                    System.out.println("Waiting...");
                    Socket socket = server.accept();

                    // receive data
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    String code = in.readUTF();
                    listener.read(code);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 客户端
    public static class Sender {
        private String ip;
        private int port;

        public Sender(String ip, int port) {
            this.ip = ip;
            this.port = port;
        }

        public void send(String code) {
            try {
                Socket socket = new Socket(ip, port);
                System.out.printf("Send %d to %s\n", code, ip + ":" + port);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(code);
                out.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
