package tk.mightyelemental.sof2.week8;

public class LinkedListSet<E> implements ISet<E> {

	private Node<E> head, tail;
	private int count;

	@Override
	public boolean add(E obj) {
		if (head == null) {
			head = new Node<E>(obj);
			tail = head;
			count++;
			return true;
		}
		if (this.contains(obj))
			return false;
		Node<E> n = new Node<E>(obj);
		n.parent = tail;
		tail.child = n;
		tail = n;
		count++;
		return true;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		count = 0;
	}

	@Override
	public boolean contains(E obj) {
		return nodeOfObj(obj) != null;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean remove(E obj) {
		Node<E> n = nodeOfObj(obj);
		if (n == null)
			return false;
		// If the element is the head element, replace the head.
		if (n.parent == null)
			head = n.child;
		else
			n.parent.child = n.child;
		n.destroy();
		count--;
		return true;
	}

	/**
	 * Get the index of an object in the list.<br>
	 * Performs a linear search for the object so has efficiency of O(n).
	 * 
	 * @param obj the object to find
	 * @return The index of the object, or -1 if the object is missing
	 * 
	 */
	private Node<E> nodeOfObj(E obj) {
		Node<E> curr = head;
		while (curr.value != null && !curr.value.equals(obj)) {
			if (curr.child == null)
				return null;
			curr = curr.child;
		}
		return curr;
	}

	@Override
	public int size() {
		return count;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		if (head != null) {
			sb.append(head.toString());
			sb.setLength(sb.length() - 4);
		}
		sb.append("]");
		return sb.toString();
	}

}

class Node<E> {

	Node<E> child;
	Node<E> parent;
	E value;

	public Node(E obj) {
		value = obj;
	}

	public void destroy() {
		child = null;
		parent = null;
		value = null;
	}

	public String toString() {
		return value + " -> " + (child == null ? "" : child.toString());
	}

}
