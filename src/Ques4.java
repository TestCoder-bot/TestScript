import java.util.Scanner;
public class Ques4 {
public static void main (String[]args)
{
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the name of emmployee");
	String name= scanner.nextLine();
	System.out.println("Enter the gender of emmployee");
	char gender= scanner.next().charAt(0);
	System.out.println("Enter emmployee salary");
	float salary= scanner.nextFloat();
	if (gender == 'f' || gender == 'F') 
	{
	float increment = salary + ((salary*6)/100);
		System.out.println(increment+"\n"+gender+"\n"+name);
	}
	else
{
	System.out.println(name+ " \n"+ "Gender is not female"+"\n "+salary);			
}
scanner.close();
}
}


