import java.util.Scanner;

public class Ques7 {
	

		public static void main(String[] args) {

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter any number = ");
			int number = scanner.nextInt(); // 1 2 3 4 5 6 7 8 9
		    int value;
		    int sum =0;
		    while(number !=0)
		    {
		    	value = number%10;
		    	sum = sum+value;
		    	value= number/10;
		    }
		    System.out.println("Sum of digits = "+sum);
		    
		}
}