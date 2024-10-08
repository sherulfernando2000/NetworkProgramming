package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server2 {
    public static void main(String[] args) {
        try {
            //create server socket
            ServerSocket serverSocket = new ServerSocket(9999);

            //see request came, accept
            Socket socket = serverSocket.accept();
            System.out.println("client connected");

            //input stream
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //read
            String message = dataInputStream.readUTF();
            System.out.println("message: " + message);



            //---------------------------
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("I'm server");
            dataOutputStream.flush();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
