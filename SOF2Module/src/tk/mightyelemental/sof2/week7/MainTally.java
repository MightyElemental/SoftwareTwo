package tk.mightyelemental.sof2.week7;

import java.util.ArrayList;
import java.util.List;

public class MainTally {

	public static void main(String[] args) {
		List<ITallyCounter> counters = new ArrayList<ITallyCounter>();
		BasicTallyCounter btc = new BasicTallyCounter();
		btc.counter = 10;
		counters.add(btc);
		BetterTallyCounter betc = new BetterTallyCounter();
		betc.counter = 10;
		counters.add(betc);
		int total = counters.stream().mapToInt(e -> e.getValue()).sum();
		System.out.println(total);
	}

}