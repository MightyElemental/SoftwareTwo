package tk.mightyelemental.sof2.week9.graphs;

import java.util.HashSet;
import java.util.Set;

public class NodeUnweighted<T> extends Node<T> {

	Set<NodeUnweighted<T>> adjacentNodes = new HashSet<NodeUnweighted<T>>();

	/**
	 * Create a new Node
	 * 
	 * @param g the graph the node is being added to
	 */
	NodeUnweighted(IGraph<T> g) {
		super(g);
	}

	/**
	 * Create a new Node
	 * 
	 * @param g     the graph the node is being added to
	 * @param value the value contained within the Node
	 */
	public NodeUnweighted(IGraph<T> g, T value) {
		super(g);
		g.addNode(this);
		this.value = value;
	}

	@Override
	public void addEdge(Node<T> n) {
		if (!(n instanceof NodeUnweighted))
			throw new IllegalArgumentException("Node type must be unweighted");
		graphObj.addEdge(this, n);
	}

	@SuppressWarnings("unchecked")
	@Override
	public NodeUnweighted<T>[] getAdjacentNodes() {
		return adjacentNodes.toArray(NodeUnweighted[]::new);
	}

	@Override
	public boolean removeEdgesTo(Node<T> n) {
		return adjacentNodes.removeIf(n::equals);
	}

	@Deprecated
	static <T> NodeUnweighted<T> create(IGraph<T> g) {
		return new NodeUnweighted<T>(g);
	}

	/**
	 * Invoked by the {@link Node#graphObj} object to store a new edge in the
	 * node.<br>
	 * Stores a newly-created edge.
	 * 
	 * @param n the node the edge points to
	 */
	@Override
	void storeEdge(Node<T> n) {
		adjacentNodes.add((NodeUnweighted<T>) n);
	}

}
