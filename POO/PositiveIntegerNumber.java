import java.util.*;

public class PositiveIntegerNumber
{
	public static void main(String[] args) {
	    int[] vector={20,45,76,81,34,567,423,6,3,5};
	    int index;
		boolean continueCycle=false;
		do{
		    Scanner keyboard= new Scanner(System.in);
    		try{
    		    System.out.print("Ingrese un valor entre 0 y 9:");
    		    index=keyboard.nextInt();
    		    System.out.print("En el vector se almacena en la posicion " + index + " el valor "+vector[index]);
    		    continueCycle=false;
    		}
    		catch(InputMismatchException inputMismatchException)
    		{
    		    System.out.println("Debe de ingresar obligatoriamente un numero entero");
    		    System.out.println("\nEl error fue el siguiente: "+ inputMismatchException);
    		    System.out.println("Reintente de nuevo");
    		    continueCycle=true;
    		}
    		catch(IndexOutOfBoundsException indexOutOfBoundsException)
    		{
    		    System.out.println("El valor debe de estar entre 0 y 9");
    		    System.out.println("\nEl error fue el siguiente: "+ indexOutOfBoundsException);
    		    System.out.println("Reintente de nuevo");
    		    continueCycle=true;
    		}
		}while(continueCycle);
	}
}