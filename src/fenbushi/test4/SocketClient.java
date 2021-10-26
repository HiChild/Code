package fenbushi.test4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketClient {

    public SocketClient() {
        try {

            Socket socket = new Socket("localhost", 2121);
            long time = System.currentTimeMillis();
            Date newtime = new Date(time);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String str = sdf.format(newtime);
            System.out.println("当前用户于:  " + str + "日 建立了一个连接");
            BufferedReader sysin = new BufferedReader(new InputStreamReader(
                    System.in));

            PrintWriter out = new PrintWriter(socket.getOutputStream());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));

            String line;

            line = sysin.readLine();

            while (!line.equals("拜拜")) {

                out.println(line);

                out.flush();

                System.out.println("[Client]: " + line);

                System.out.println("[Server]: " + in.readLine());

                line = sysin.readLine();

            }

            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("错误. " + e);
        }
    }

    public static void main(String[] args) {
        new SocketClient();
    }

}