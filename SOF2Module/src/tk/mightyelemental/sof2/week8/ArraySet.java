package tk.mightyelemental.sof2.week8;

import java.util.Arrays;

public class ArraySet<E> implements ISet<E> {

	private E[] data;
	private int top = 0;

	@SuppressWarnings("unchecked")
	public ArraySet(int size) {
		data = (E[]) new Object[size];
	}

	@Override
	public boolean add(E obj) {
		if (top < data.length) {
			if (this.contains(obj))
				return false;
			data[top++] = obj;
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		while (top > 0)
			data[--top] = null;
	}

	@Override
	public boolean contains(E obj) {
		for (int i = 0; i < top; i++)
			if (data[i].equals(obj))
				return true;
		return false;
	}

	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	@Override
	public boolean remove(E obj) {
		int index = indexOfObj(obj);
		if (index == -1)
			return false;
		data[index] = data[--top];
		data[top] = null;
		return true;
	}

	/**
	 * Get the index of an object in the array.<br>
	 * Performs a linear search for the object so has efficiency of O(n).
	 * 
	 * @param obj the object to find
	 * @return The index of the object, or -1 if the object is missing
	 * 
	 */
	private int indexOfObj(E obj) {
		for (int i = 0; i < top; i++)
			if (data[i].equals(obj))
				return i;
		return -1;
	}

	@Override
	public int size() {
		return top;
	}

	public String toString() {
		return Arrays.toString(data);
	}

}
