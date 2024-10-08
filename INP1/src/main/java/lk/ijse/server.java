package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) {

        try {
            //server socket
        ServerSocket serversocket = new ServerSocket(3000);


        while (true) {

            //local socket
            Socket socket = serversocket.accept();
            System.out.println("client accepted");

            //data reading
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            //sout
            String message = dataInputStream.readUTF();
            System.out.println("message received: " + message);


            //connection close
            System.out.println("Im  server. input a message");
            Scanner scanner = new Scanner(System.in);
            String serverMessage = scanner.next();
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(serverMessage);
            dataOutputStream.flush();
            socket.close();

        }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }



    }


