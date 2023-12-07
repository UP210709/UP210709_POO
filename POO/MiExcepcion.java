public class MiExcepcion extends Exception
{
    private int errorCode;
    
    public MiExcepcion(int errorCode)
    {
        this.errorCode=errorCode;
    }
    
    
    public String getMessage()
    {
        return "MiExcepcion: Código de error " + errorCode; 
    }

	public static void main(String[] args) 
	{
		int num;
		
		try 
		{
		    num=15;
		    
		    if(num>=0 && num<=10)
		    {
		        throw new MiExcepcion(111);
		    }
		    else if(num>10 && num<=20)
		    {
		        throw new MiExcepcion(222);
		    }
		    else if(num>20 && num<=30)
		    {
		        throw new MiExcepcion(333);
		    }
		} 
		catch (MiExcepcion ex)
		{
		    System.out.println(ex.getMessage());
		}
	}
}