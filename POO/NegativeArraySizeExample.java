public class NegativeArraySizeExample
{
	public static void main(String[] args) {
		try{
		    int negativeSize=-5;
		    int[] array =new int[negativeSize];
		}
		catch(NegativeArraySizeException negativeArraySizeException)
		{
		    System.out.println("Se produjo una excepción NegativeArraySizeException: ");
		    System.out.println(negativeArraySizeException.getMessage());
		    negativeArraySizeException.printStackTrace();
		    //e.printStackTrace();
		}
	}
}