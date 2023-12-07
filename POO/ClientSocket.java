import java.net.Socket;
import java.io.IOException;

public class ClientSocket {
    
    public static void main(String[] args){

        try{
            Socket socket= new Socket("localhost",12345);
            System.err.println("Conectando al servidor.");

            socket.close();
        } catch(IOException e){
            e.printStackTrace();
        }

    }
    
}
