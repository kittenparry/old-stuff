import java.util.Scanner;


public class tempCalc {

	public void Calculator(){
		
		//Celsius to Fahrenheit
		//////or
		//Fahrenheit to Celsius
		Scanner in = new Scanner(System.in);
		double fah, cel;
		String choosing;
		System.out.println("Options");
		System.out.println("1. Celsius to Fahrenheit");
		System.out.println("2. Fahrenheit to Celsius");
		System.out.println("Please choose one.(1 or 2)");
		choosing = in.next();
		switch(choosing){
		case "1":
			System.out.println("Please enter Celsius degree:");
			cel = in.nextDouble();
			toFah(cel);
			break;
		case "2":
			System.out.println("Please enter Fahrenheit degree:");
			fah = in.nextDouble();
			toCel(fah);
			break;
		default:
			System.out.println("Please only write 1 or 2 as your choosing.");
			break;
		}
	}
	
	public void toFah (double x){
		double f;
		f = (x*1.8) + 32;
		//The formula is ºF = ºC * 1.8 + 32
		System.out.println(x +" ºC is " + f + " ºF.");
	}
	public void toCel (double y){
		double c;
		//The formula is (the reversed one of the upper one
		//Which is ºC = (ºF - 32) / 1.8
		c = (y-32)/1.8;
		System.out.println(y +" ºF is " + c + " ºC.");
	}
}