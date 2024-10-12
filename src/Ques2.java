import java.util.Scanner;

public class Ques2 {
public static void main (String[]args){
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the number");
			int number = scanner.nextInt();
			int i;
			for(i=number ; i<=12 ; i++)
			{
				System.out.println("Java : "+i);
			}
			
			
			System.out.println(i);
			
			for(i=13 ; i<=20 ; i++)
			{
				System.out.println("Python : "+i);			 
			}
		}
	}
	
}

