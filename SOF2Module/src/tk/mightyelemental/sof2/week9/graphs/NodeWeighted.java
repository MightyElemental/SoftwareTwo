package tk.mightyelemental.sof2.week9.graphs;

import java.util.HashMap;

public class NodeWeighted<T> extends Node<T> {

	/** The adjacent nodes with weightings */
	HashMap<Node<T>, Double> adjacentNodes = new HashMap<Node<T>, Double>();

	NodeWeighted(IGraph<T> g) {
		super(g);
	}

	/**
	 * Create a new Node
	 * 
	 * @param g     the graph the node is being added to
	 * @param value the value contained within the Node
	 */
	public NodeWeighted(IGraph<T> g, T value) {
		super(g);
		g.addNode(this);
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public NodeWeighted<T>[] getAdjacentNodes() {
		return adjacentNodes.keySet().toArray(NodeWeighted[]::new);
	}

	public Double[] getAdjecentNodeWeights() { // TODO: verify the values and keys are aligned
		return adjacentNodes.values().toArray(Double[]::new);
	}

	/**
	 * Adds an edge by invoking {@link IGraph#addEdge(Node, Node, double)}.
	 * 
	 * @param n      the node the edge points to
	 * @param weight the weight of the edge
	 */
	public void addEdge(NodeUnweighted<T> n, double weight) {
		graphObj.addEdge(this, n, weight);
	}

	/**
	 * {@link #addEdge(NodeUnweighted, double)} should be used instead.<br>
	 * Creates an edge with a default weight of 0.
	 * 
	 * @param n the node the edge points to
	 */
	@Override
	public void addEdge(Node<T> n) {
		if (!(n instanceof NodeWeighted))
			throw new IllegalArgumentException("Node type must be weighted");
		addEdge((NodeUnweighted<T>) n, 0.0);
	}

	@Override
	public boolean removeEdgesTo(Node<T> n) {
		return adjacentNodes.remove(n) != null;
	}

	/**
	 * Invoked by an {@link IGraph} object to store a new edge in a node.<br>
	 * Calls the {@link #storeEdgeWeight(Node, double)} method with default weight
	 * of 0. Since this is a weighted node, the aforementioned method is preferred
	 * to this one, however, said method can be called after this to correct the
	 * edge weight.
	 * 
	 * @param n the edge to store
	 */
	@Override
	void storeEdge(Node<T> n) {
		storeEdgeWeight(n, 0.0);
	}

	/**
	 * Invoked by an {@link IGraph} object to store a new edge in a node.<br>
	 * Stores a newly-created edge with a specified weight.
	 * 
	 * @param n the node the edge is pointing to.
	 * @param d the weight of the edge.
	 * @see #storeEdge(Node)
	 */
	void storeEdgeWeight(Node<T> n, double d) {
		adjacentNodes.put(n, d);
	}

}
