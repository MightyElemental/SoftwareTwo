package tk.mightyelemental.sof2.week8;

public interface ISet<E> {

	/** Adds an object of type E to the collection. */
	public boolean add(E obj);

	/** Removes all objects from the collection. */
	public void clear();

	/** Returns true if a specified object is an element within the collection. */
	public boolean contains(E obj);

	/** Returns true if the collection has no elements. */
	public boolean isEmpty();

	/** Removes a specified object from the collection. */
	public boolean remove(E obj);

	/** Returns the number of elements in the collection */
	public int size();
}
