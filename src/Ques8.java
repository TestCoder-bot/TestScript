import java.util.Scanner;

// In switch statement variable names will not allow
public class Ques8 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter any number = ");
		int n = scanner.nextInt();
		
		switch (n) {
			
		
		case 0:
			System.out.println("Zero");
			break;
		
		  case 1: 
			  System.out.println("One"); break;
		 
		case 2:
			System.out.println("two");
			break;
		
		case 3:
			System.out.println("Three");
			break;
		
		case 4:
			System.out.println("Four");
			break;
		
		/*
		 * case x: System.out.println("Five"); break;
		 */
		
		}
	}

}