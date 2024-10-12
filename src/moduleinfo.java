

import java.util.Scanner;

public class moduleinfo {

	public static void main(String[] args) {
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter The number = ");
			int number = scanner.nextInt();

			for(int i=1 ; i<=number ; i++)
			{
				System.out.print("i: "+i+" ");
			}
		}
		 
	}
	
}