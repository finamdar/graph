package graphs.problems;

import java.util.Iterator;

import graphs.adjacencylist.GraphAdjacencyListImpl;
import graphs.creator.GraphCreator;

public class TransitiveClosure {

	static GraphAdjacencyListImpl graph = GraphCreator.createGraph();
	static int[][] transitiveClosure;
	
	static {
		transitiveClosure = new int[graph.vertexCount][graph.vertexCount];
		for (int i = 0; i < graph.vertexCount; i++) {
			transitiveClosure[i] = new int[graph.vertexCount];
		}
	}
	
	public static void main(String[] args) {
		transitiveClosure();

	}
	
	/**
	 * Given a directed graph, find out if a vertex j is reachable from another
	 * vertex i for all vertex pairs (i, j) in the given graph. Here reachable mean
	 * that there is a path from vertex i to j. The reach-ability matrix is called
	 * transitive closure of a graph. For eg. in below graph, node 2 is accessible
	 * from node 0 via node 1 - so in transitive closure matrix for node 0, node 2
	 * would be marked as 1
	 */
	public static void transitiveClosure() {

		for (int i = 0; i < graph.vertexCount; i++) {
			transitiveHelper(i, i);
		}

		for (int row = 0; row < graph.vertexCount; row++) {
			for (int col = 0; col < graph.vertexCount; col++) {
				System.out.print(transitiveClosure[row][col]);
			}
			System.out.println("\n");
		}

	}

	private static void transitiveHelper(int source, int destination) {
		transitiveClosure[source][destination] = 1;

		Iterator<Integer> itr = graph.edges[source].listIterator();
		while (itr.hasNext()) {
			Integer next = itr.next();
			if (transitiveClosure[source][next] == 0) {
				transitiveHelper(source, next);
			}
		}
	}

}
