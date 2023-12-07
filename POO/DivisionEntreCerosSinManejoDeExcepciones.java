import java.util.Scanner;
public class DivisionEntreCerosSinManejoDeExcepciones
{
    // demuestra el lanzamiento de una excepcion cuando ocurre una division entre cero
    public static int cociente(int numerador,int denominador)
    {
        return numerador/denominador;
    }
    
    public static void main(String[] args)
    {
        Scanner explorador = new Scanner(System.in);
        
        System.out.print("Introduzca un numerador entero:");
        int numerador=explorador.nextInt();
        System.out.print("Introduzca un denominador entero: ");
        int denominador=explorador.nextInt();
        
        int resultado =cociente(numerador,denominador);
        
        System.out.println("El resultado es: "+resultado);
    }
}