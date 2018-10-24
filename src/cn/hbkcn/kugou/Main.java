package cn.hbkcn.kugou;

// Create at 2018-7-20 15:56 by 3243430237@qq.com
// TODO: 2018-7-20 main class

/**
 * 酷狗控制器，需要设置好相应的快捷键
 */
public class Main {
    public static final String ip = "127.0.0.1";
    public static final int port = 10201;

    public static void main(String[] args) {
        receive();
    }

    public static void receive() {
        new Thread(new KCP.Receiver(port, code -> {
            KeyEvent event = new KeyEvent();
            System.out.println("Received: " + code);
            if (!"exit".equals(code)) {
                event.alt(Integer.valueOf(code));
            } else {
                System.out.println("Exit.");
                System.exit(0);
            }
        })).start();
    }

    public static void send(int keyCode) {
        KCP.Sender sender = new KCP.Sender(ip, port);
        sender.send(String.valueOf(keyCode));
    }
}
