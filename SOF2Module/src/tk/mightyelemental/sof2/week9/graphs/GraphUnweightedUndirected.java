package tk.mightyelemental.sof2.week9.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphUnweightedUndirected<T> implements IGraph<T> {

	private List<NodeUnweighted<T>> nodes = new ArrayList<NodeUnweighted<T>>();

	public GraphUnweightedUndirected() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double[][] getAdjacencyMatrix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, HashMap<String, Double>> getAjacencyList() {
		// TODO Auto-generated method stub
		return null;
	}

	/** Adds an edge connecting X to Y, and Y to X. */
	@Override
	public void addEdge(Node<T> x, Node<T> y) {
		x.storeEdge(y);
		y.storeEdge(x);
	}

	@Override
	public void addEdge(Node<T> x, Node<T> y, double weight) {
		addEdge(x, y);
	}

	@Override
	public NodeUnweighted<T> newNode(T value) {
		NodeUnweighted<T> nu = new NodeUnweighted<T>(this);
		addNode(nu);
		return nu;
	}

	/**
	 * Add a node to the graph
	 * 
	 * @param n the node to add
	 * @throws IllegalArgumentException If a type other than NodeUnweighted is
	 *                                  passed.
	 */
	@Override
	public void addNode(Node<T> n) {
		if (!(n instanceof NodeUnweighted))
			throw new IllegalArgumentException("Node type must be unweighted");
		nodes.add((NodeUnweighted<T>) n);
	}

	@Override
	public boolean removeNode(Node<T> n) {
		if (!nodes.contains(n))
			return false;
		nodes.remove(n);
		removeNodeFromAdjacentNodes((NodeUnweighted<T>) n);
		return true;
	}

	private void removeNodeFromAdjacentNodes(NodeUnweighted<T> n) {
		for (NodeUnweighted<T> node : n.getAdjacentNodes()) {
			node.removeEdgesTo(n);
		}
	}

}
