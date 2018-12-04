import java.util.Random;
import java.util.Scanner;


public class slots {

	public void game(){
	Scanner in = new Scanner(System.in);
	//To increase the odds of winning, element numbers could be decreased
	String slots[] = {"+", "$", "7", "&", "#", "£"};
	Random turn = new Random();
	String a, b, c;
	String replay;

	//Setting the values of slots randomly
	a = slots[turn.nextInt(slots.length)];
	b = slots[turn.nextInt(slots.length)];
	c = slots[turn.nextInt(slots.length)];

	//Slots Panel, below
	System.out.println("]--SLOTS--[");
	System.out.println("- " + a + "  " + b + "  " + c + " -");

	//Checks whether the slots are the same
	//Also checks whether user wants to replay or not
	if(a == b && b == c){
		System.out.println("--You Win--");
		System.out.println("Replay? (y/n)");
		replay = in.next();
		switch(replay){
		case "y":
			game();
			break;
		default:
			break;
		}
	}else{
		System.out.println("--       --");
		System.out.println("Replay? (y/n)");
		replay = in.next();
		switch(replay){
		case "y":
			game();
			break;
		default:
			break;
			}
		}
	}
}
