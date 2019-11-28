package test.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginTest {
    public static ServerSocket serverSocket;
    public static Socket socket;

    static {
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        while(true){
            try {
                socket=serverSocket.accept();
                if(socket!=null){
                    new Thread(new LoginServer(socket)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
