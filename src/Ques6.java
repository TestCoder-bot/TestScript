import java.util.Scanner;

public class Ques6 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter any number = ");
		int number = scanner.nextInt(); // 1 2 3 4 5 6 7 8 9
		int value; 
		
		while(number != 0 )
		{
			value = number%10;
			System.out.println(value);
			number = number/10;
		}
		

		

	}

}

