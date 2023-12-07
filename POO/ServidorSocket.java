import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ServidorSocket {

    public static void main(String[] args){
        try{
            ServerSocket serverSocket=new ServerSocket(12345);
            System.out.println("Esperando conexión...");

            Socket socket= serverSocket.accept();
            System.out.println("Cliente conectado.");

            socket.close();
            serverSocket.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
