package tk.mightyelemental.sof2.week9;

import tk.mightyelemental.sof2.week9.graphs.GraphUnweightedUndirected;
import tk.mightyelemental.sof2.week9.graphs.NodeUnweighted;

public class MainWeek9 {

	public static void main(String[] args) {

		GraphUnweightedUndirected<Integer> guwud = new GraphUnweightedUndirected<Integer>();

		NodeUnweighted<Integer> nu = guwud.newNode(10);
		NodeUnweighted<Integer> nu2 = new NodeUnweighted<Integer>(guwud, 6);

	}

}
