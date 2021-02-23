package tk.mightyelemental.sof2.week7;

public class BasicTallyCounter implements ITallyCounter {

	private int digits = 3;
	protected int counter = 0;

	public BasicTallyCounter() {
		digits = 3;
	}

	public BasicTallyCounter(int digits) {
		this.digits = Math.max(3, digits);
	}

	private int maxValue() {
		return (int) Math.pow(10, digits) - 1;
	}

	@Override
	public void increment() throws InvalidOperationException {
		if (counter >= maxValue()) {
			throw new InvalidOperationException("You cannot increment out of range!");
		} else {
			counter++;
		}
	}

	@Override
	public void reset() {
		counter = 0;
	}

	@Override
	public int getValue() {
		return counter;
	}

	public String toString() {
		return String.format("%0" + digits + "d", counter);
	}

}
