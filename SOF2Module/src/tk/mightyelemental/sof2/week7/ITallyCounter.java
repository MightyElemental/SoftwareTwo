package tk.mightyelemental.sof2.week7;

public interface ITallyCounter {

	/** @throws InvalidOperationException when counter is at the maximum value */
	public void increment() throws InvalidOperationException;

	public void reset();

	public int getValue();

}
