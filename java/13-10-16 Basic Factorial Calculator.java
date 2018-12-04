import java.util.Scanner;

public class factorial {
	public void getFact(){

		Scanner en = new Scanner(System.in);
		int num;
		int ans = 1;

		System.out.println("Enter a number to get its factorial:");
		num = en.nextInt();
		int fact[] = new int[1 + num];

		for(int x = 1; x < fact.length; x++){
			ans *= x;
		}
		System.out.println("The factorial of " + num + " is " + ans);
		System.out.println("( " + num + "! = " + ans + " )");
	}
}
