import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class ServidorSocket2 {
    
    public static void main(String[] args){

        byte[] Mensaje=new byte[80];
        InputStream FlujoDeEntrada;
        DataInputStream Flujo;

        try{
            ServerSocket serverSocket=new ServerSocket(8000);
            Socket ComunicacionConCliente=serverSocket.accept();
            System.out.println("Comunicacion establecida.");
            FlujoDeEntrada=ComunicacionConCliente.getInputStream();
            Flujo=new DataInputStream(FlujoDeEntrada);
            int BytesLeidos=Flujo.read(Mensaje);
            System.out.println(new String(Mensaje));
            ComunicacionConCliente.close();
            serverSocket.close();
        }
        catch(IOException e){
            System.out.println("Error de las comunicaciones.");
            System.exit(0);
        }
        catch(SecurityException e){
            System.out.println("Comunicacion no permitida por razones de seguridad.");
            System.exit(0);
        }
    }
}
