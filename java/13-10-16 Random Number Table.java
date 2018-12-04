import java.util.Random;

public class Ratab {

	public void RandomNumTab(){
		Random ace = new Random();
		System.out.println("Index\tValue");
		//Tab index being printed
		int cato[] = new int[5];
		for(int b = 0; b < cato.length; b++){
			cato[b] = 1 + ace.nextInt(10);
		}//cato array gets its random values on each element

		int taco[] = new int[cato.length];
		for(int c = 0; c < taco.length; c++){
			taco[c] = cato[c];
		}//taco array's elements gets equal to the values of cato array's elements

		for(int i = 0; i<taco.length; i++){
		System.out.println(i + "\t" + taco[i]);
		}//Rest of the table gets printed
	}
}
