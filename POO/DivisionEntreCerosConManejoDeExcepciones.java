import java.util.Scanner;
import java.util.InputMismatchException;

public class DivisionEntreCerosConManejoDeExcepciones
{
    // demuestra el lanzamiento de una excepcion cuando ocurre una division entre cero
    public static int cociente(int numerador,int denominador)
    {
        return numerador/denominador;
    }
    
    public static void main(String[] args)
    {
        Scanner explorador = new Scanner(System.in);
        
        boolean continuarCiclo=true;
        do{
            try
            {
                System.out.print("Introduzca un numerador entero: ");
                int numerador=explorador.nextInt();
                System.out.print("Introduzca un denominador entero: ");
                int denominador=explorador.nextInt();
                
                int resultado =cociente(numerador,denominador);
                System.out.printf("\nResultado: %d / %d = %d \n",numerador,denominador,resultado);
                continuarCiclo=false;
            }
            catch(InputMismatchException inputMismatchException)
            {
                System.err.printf("\nExcepcion: %s",inputMismatchException);
                explorador.nextLine();
                System.out.println("\nDebe introducir enteros. Intente de nuevo. \n");
            }
            catch(ArithmeticException arithmeticException)
            {
                System.err.printf("\nExcepcion: %s",arithmeticException);
                System.out.println("\nCero es un denominador invalido. Intente de nuevo. \n");
            }
        }while(continuarCiclo);
    }
}