package tk.mightyelemental.sof2.week7;

public class BetterTallyCounter extends BasicTallyCounter implements IAdvancedCounter {

	@Override
	public void decrement() throws InvalidOperationException {
		if (counter <= 0) {
			throw new InvalidOperationException("You cannot increment out of range!");
		} else {
			counter--;
		}
	}

}
