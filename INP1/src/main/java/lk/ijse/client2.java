package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class client2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",9999);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("I'm client");
            dataOutputStream.flush();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //read
            String message = dataInputStream.readUTF();
            System.out.println("message: " + message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
