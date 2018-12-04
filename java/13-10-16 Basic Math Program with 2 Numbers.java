import java.util.Scanner;

public class Sanner {
	public void doMath(){
		Scanner input = new Scanner(System.in);

		double fnum, snum, answer;
		String mid;

		System.out.println("First number:");
		fnum = input.nextDouble();

		System.out.println("Math Operator (+, -, /, *):");
		mid = input.next();

		System.out.println("Second number:");
		snum = input.nextDouble();

		switch (mid){
		case "+":
			answer = fnum + snum;
			System.out.println(fnum + " plus " + snum + " equals " + answer);
			break;
		case "-":
			answer = fnum - snum;
			System.out.println(fnum + " minus " + snum + " equals " + answer);
			break;
		case "/":
			answer = fnum / snum;
			System.out.println(fnum + " divided by " + snum + " equals " + answer);
			break;
		case "*":
			answer = fnum * snum;
			System.out.println(fnum + " times " + snum + " equals " + answer);
		//Additional cases
		case "plus":
			answer = fnum + snum;
			System.out.println(fnum + " plus " + snum + " equals " + answer);
			break;
		case "minus":
			answer = fnum - snum;
			answer = Math.abs(answer);
			System.out.println(fnum + " minus " + snum + " equals " + answer);
			break;
		case "divide":
			answer = fnum / snum;
			System.out.println(fnum + " divided by " + snum + " equals " + answer);
			break;
		case "times":
			answer = fnum * snum;
			System.out.println(fnum + " times " + snum + " equals " + answer);
			break;
		default:
			System.out.println("Please enter one of the following as operator to get an answer: +, -, / or *");
			break;
		}
	}
}
