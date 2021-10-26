package fenbushi.test4;

import java.net.ServerSocket;


public class SocketServer {

    public SocketServer() {
        try {

            int clientcount = 0;

            boolean listening = true;

            ServerSocket server = null;

            try {

                server = new ServerSocket(2121);

                System.out.println("开启服务");
            } catch (Exception e) {
                System.out.println("Can not listen to. " + e);
            }

            while (listening) {

                clientcount++;

                new ServerThread(server.accept(), clientcount).start();
            }
        } catch (Exception e) {
            System.out.println("Error. " + e);
        }
    }


    public static void main(String[] args) {
        new SocketServer();
    }
}