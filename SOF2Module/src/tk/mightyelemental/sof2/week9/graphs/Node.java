package tk.mightyelemental.sof2.week9.graphs;

public abstract class Node<T> {

	/**
	 * Create a new Node
	 * 
	 * @param g the graph the node is being added to
	 */
	Node(IGraph<T> g) {
		this.graphObj = g;
	}

	/**
	 * Create a new Node
	 * 
	 * @param g     the graph the node is being added to
	 * @param value the value contained within the Node
	 */
	public Node(IGraph<T> g, T value) {
		this(g);
		g.addNode(this);
		this.value = value;
	}

	/**
	 * The Graph object the node belongs to. This is used to prevent inconsistencies
	 * when constructing various Graph types.
	 */
	protected IGraph<T> graphObj;

	/** The value contained within the node */
	protected T value;

	/** @return The value contained within the node */
	public T getValue() {
		return value;
	}

	/***/
	public abstract Node<T>[] getAdjacentNodes();

	public IGraph<T> getGraph() {
		return graphObj;
	}

	/**
	 * Adds an edge by invoking {@link IGraph#addEdge(Node, Node)} as to avoid
	 * inconsistencies depending on Graph type.
	 */
	public void addEdge(Node<T> n) {
		graphObj.addEdge(this, n);
	}

	/**
	 * Invoked by an {@link IGraph} object to store a new edge in a node
	 * 
	 * @param n the edge to store
	 */
	abstract void storeEdge(Node<T> n);

	/**
	 * Removes any edges to the specified node.
	 * 
	 * @param n the node to remove
	 * @return True if node was present, False otherwise
	 */
	public abstract boolean removeEdgesTo(Node<T> n);

}
