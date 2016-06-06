package adapter.math.v2;

import java.util.Random;

import adapter.math.v2.calc.Adapter;
//addadapter
public class Launcher {

	public static void main(String[] args) {
		Adapter calc = new Adapter();
		
		Operations o = new Operations();
		o.setCalc(calc);

		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.println(o.createSummaryReport(r.nextInt(100)));
		}
	}
}
