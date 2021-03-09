package tk.mightyelemental.sof2.week9.graphs;

import java.util.HashMap;

public interface IGraph<T> {

	public double[][] getAdjacencyMatrix();

	public HashMap<String, HashMap<String, Double>> getAjacencyList();

	/** Adds edge from X to Y */
	public void addEdge(Node<T> x, Node<T> y);

	public void addEdge(Node<T> x, Node<T> y, double weight);

	/**
	 * Create a new node and add it to the graph
	 * 
	 * @param value the value contained within the node
	 * @return The newly created node
	 */
	public Node<T> newNode(T value);

	/**
	 * Add a node to the graph
	 * 
	 * @param n the node to add
	 */
	public void addNode(Node<T> n);

	/**
	 * Removes a specified node
	 * 
	 * @return True if node was present and has been removed, False otherwise.
	 */
	public boolean removeNode(Node<T> n);

}
