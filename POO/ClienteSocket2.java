import java.net.Socket;
import java.io.*;
import java.net.UnknownHostException;

public class ClienteSocket2 {
    
    public static void main(String[] args){

        OutputStream FlujoDeSalida;
        DataOutputStream Flujo;

        try{
            Socket SocketCliente=new Socket("localhost",8000);
            FlujoDeSalida=SocketCliente.getOutputStream();
            Flujo=new DataOutputStream(FlujoDeSalida);
            Flujo.writeBytes("Hola mundo");
            SocketCliente.close();
        }
        catch(UnknownHostException e){
            System.out.println("Referencia a host no resuelta");
        }
        catch(IOException e){
            System.out.println("Error de las comunicaciones");
        }
        catch(SecurityException e){
            System.out.println("Comunicacion no permitida por razones de seguridad");
        }
        
    }
}
