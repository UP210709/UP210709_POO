import java.util.*;
public class Age extends Exception
{   
    private int errorCode;
    
    public Age(int errorCode)
    {
        this.errorCode=errorCode;
    }
    
    public String getMessage()
    {
        return "DateException: Código de error " + errorCode; 
    }
    
	public static void main(String[] args) {
	    
		Calendar date = new GregorianCalendar();
		int year = date.get(Calendar.YEAR);
		//int year =2024;
		int month = date.get(Calendar.MONTH)+1;
		//int month = 3;
		int day = date.get(Calendar.DAY_OF_MONTH);
		//int day=10;
		int yearOfBirth=0;
		int monthOfBirth=0;
		int dayOfBirth=0;
		int passedYears=0;
		int passedMonths=0;
		int passedDays=0;
		boolean continueCicle=true;
		boolean thisYear=false;
		int daysOfMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
		
		do{
		    Scanner scanner=new Scanner(System.in);
    		try{
    		    System.out.println("Ingresa el año");
    		    yearOfBirth=scanner.nextInt();
    		    if(yearOfBirth>year || yearOfBirth<0)
    		    {
    		        throw new Age(1);
    		    }
    		    else
    		    {
    		        continueCicle=false;    
    		    }
    		}
    		catch (Age exception)
    		{
    		    System.out.println(exception.getMessage()+"\n");
    		    System.out.println("Intentalo de nuevo\n");
    		}
    		catch(InputMismatchException inputMismatchException)
    		{
    		    System.out.println("Excepcion: "+inputMismatchException+"\n");
    		    System.out.println("Intentalo de nuevo\n");
    		}
		}while(continueCicle);
		
		passedYears=year-yearOfBirth;
		continueCicle=true;
		
		if(year==yearOfBirth)
		{
		    thisYear=true;
		}
	    if(yearOfBirth%4==0 & yearOfBirth%100!=0 || yearOfBirth%400==0)
	    {
	        daysOfMonth[1]=daysOfMonth[1]+1;
	    }
		
		do{
		    Scanner scanner=new Scanner(System.in);
    		try{
    		    System.out.println("Ingresa el mes");
    		    monthOfBirth=scanner.nextInt();
    		    if(monthOfBirth>12 || monthOfBirth<=0)
    		    {
    		        throw new Age(1);
    		    }
    		    else if (thisYear && monthOfBirth>month)
    		    {
    		        throw new Age(2);
    		    }
    		    else
    		    {
    		        continueCicle=false;    
    		    }
    		}
    		catch (Age exception)
    		{
    		    System.out.println(exception.getMessage()+"\n");
    		    System.out.println("Intentalo de nuevo\n");
    		}
    		catch(InputMismatchException inputMismatchException)
    		{
    		    System.out.println("Excepcion: "+inputMismatchException+"\n");
    		    System.out.println("Intentalo de nuevo\n");
    		}
		}while(continueCicle);
		
		if(monthOfBirth>month)
		{
		    passedMonths=month + (12-monthOfBirth);
		    passedYears=passedYears-1;
		}
		else
		{
		    passedMonths=month - monthOfBirth;
		}
		continueCicle=true;
		
		do{
		    Scanner scanner=new Scanner(System.in);
    		try{
    		    System.out.println("Ingresa el dia");
    		    dayOfBirth=scanner.nextInt();
    		    if(dayOfBirth>daysOfMonth[monthOfBirth-1] || dayOfBirth<=0)
    		    {
    		        throw new Age(1);
    		    }
    		    else if (thisYear && monthOfBirth==month && dayOfBirth>day)
    		    {
    		        throw new Age(3);
    		    }
    		    else
    		    {
    		        continueCicle=false;    
    		    }
    		}
    		catch (Age exception)
    		{
    		    System.out.println(exception.getMessage()+"\n");
    		    System.out.println("Intentalo de nuevo\n");
    		}
    		catch(InputMismatchException inputMismatchException)
    		{
    		    System.out.println("Excepcion: "+inputMismatchException+"\n");
    		    System.out.println("Intentalo de nuevo\n");
    		}
		}while(continueCicle);
		
		if(dayOfBirth<=day)
		{
		    passedDays=day-dayOfBirth; 
		}
		else
		{   
		    if(daysOfMonth[monthOfBirth-2]-dayOfBirth<0 || daysOfMonth[monthOfBirth-1]==dayOfBirth){
		        passedDays=day;
		        if(dayOfBirth>day){
		            passedMonths=passedMonths-1;
		        }
		    }
		    else{
		        passedDays=daysOfMonth[monthOfBirth-2]-dayOfBirth+day;  
		    }
		}
		if(month==monthOfBirth && dayOfBirth>day){
		    passedMonths=11;
		    passedYears=passedYears-1;
		}
		
		System.out.println("\nHan pasado "+ passedYears + " años");
		System.out.println(passedMonths + " meses");
		System.out.println(passedDays + " dias");
	}
}