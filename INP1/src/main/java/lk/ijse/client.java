package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class client {
    public static void main(String[] args) {

        while (true){

            try {
                System.out.println("Im  client. input a message:");
                Scanner scanner = new Scanner(System.in);
                String clientMessage = scanner.next();


                //remote socket
                Socket socket = new  Socket("localhost", 3000);
                //request to the server
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                //send the data
                dataOutputStream.writeUTF(clientMessage);
                dataOutputStream.flush();

                //sout



                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String message1 = dataInputStream.readUTF();
                System.out.println("message received: " + message1);


                //close



            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }
}