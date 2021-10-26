package fenbushi.test4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {

    private static int number = 0;
    Socket socket = null;

    public ServerThread(Socket socket, int clientnum) {
        this.socket = socket;
        number = clientnum;
        System.out.println("用户当前人数为: " + number);
    }

    public void run() {
        try {

            // 由Socket对象得到输入流,并构造相应的BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream());

            BufferedReader sysin = new BufferedReader(new InputStreamReader(
                    System.in));

            System.out.println("[Client " + number + "]: " + in.readLine());

            String line;


            line = sysin.readLine();

            while (!line.equals("再见")) {

                out.println(line);

                out.flush();

                System.out.println("[Server]: " + line);

                System.out.println("[Client " + number + "]: " + in.readLine());

                line = sysin.readLine();
            }

            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("错误. " + e);
        }
    }

}