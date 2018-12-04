import java.util.Random;
import java.util.Scanner;


public class MathTest {

	public void Math(){
	//
	//Basic Math Test, 10 Questions
	//

	Scanner scan = new Scanner(System.in);
	Random turn = new Random();

	int fnum, snum, answer, input;
	String Op[] = {"+", "-", "*"}; //Without /
	String Op1;
	int right = 0;

	for(int t = 0; t < 10; t++){
		fnum = turn.nextInt(101);
		snum = turn.nextInt(101);
		Op1 = Op[turn.nextInt(3)];
		switch(Op1){
		case "+":
			answer = fnum + snum;
			break;
		case "-":
			answer = fnum - snum;
			break;
		case "*":
			answer = fnum * snum;
			break;
		default:
			answer = 0;
			break;
		}
		System.out.println(fnum + Op1 + snum + " = ?");
		input = scan.nextInt();
		if(input == answer){
			System.out.println("That's right!");
			right++;
		}else{
			System.out.println("Not the right answer.");
		}

	}
	System.out.println("You have total of " + right + " right answers and " + (10-right)+ " wrong ones.");
	if(right == 10){
		System.out.println("That's 10/10. You're amazing!");
	}else if(right >= 8){
		System.out.println("You're great.");
	}else if(right >= 6){
		System.out.println("You're good.");
	}else if(right >= 4){
		System.out.println("Maybe you'll do better, next time.");
	}else if(right > 0){
		System.out.println("You can try to do it better than that.");
	}else if(right == 0){
		System.out.println("0 out of 10? Maybe you should give more attention to your math class.");
	}

	}
}
