package graphs.problems;

import java.util.Iterator;

import graphs.adjacencylist.GraphAdjacencyListImpl;
import graphs.creator.GraphCreator;

/**
 * For finding number of paths between nodes, you explore the adjacent nodes of
 * source and traverse the entire graph for each adjacent node. While doing
 * this, you need to maintain a visited array because you dont want to go in
 * circles from the adjacent node. Call function recursively by changing the
 * source to the explored adjacent node and while back tracking reset the
 * visited array for the adjacent node. this is different from transitive
 * closure where you change the destination and keep the source as constant.
 * 
 * @author finamdar
 *
 */
public class NumberOfPathsBetweenNodes {

	private static int numberOfPaths = 0;
	static GraphAdjacencyListImpl graph = GraphCreator.createGraph();

	public static void main(String[] args) {
		numberOfPathsBetweenNodes(0, 4);
		System.out.println(numberOfPaths);
	}

	public static void numberOfPathsBetweenNodes(int source, int destination) {
		boolean[] visited = new boolean[graph.vertexCount];
		numberOfPathsBetweenNodesUtil(source, destination, visited);
	}

	private static void numberOfPathsBetweenNodesUtil(int source, int destination, boolean[] visited) {
		visited[source] = true;
		if (source == destination) {
			numberOfPaths++;
		} else {
			Iterator<Integer> itr = graph.edges[source].listIterator();
			while (itr.hasNext()) {
				Integer current = itr.next();
				if (!visited[current]) {
					numberOfPathsBetweenNodesUtil(current, destination, visited);
				}
			}
		}
		visited[source] = false;
	}

}
