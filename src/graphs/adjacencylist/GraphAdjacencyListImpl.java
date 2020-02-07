package graphs.adjacencylist;

import java.util.LinkedList;

/**
 * @author finamdar
 *
 */
public class GraphAdjacencyListImpl {
	public LinkedList<Integer>[] edges;
	public int vertexCount;
	

	public GraphAdjacencyListImpl(int vertexCount) {
		this.vertexCount = vertexCount;
		this.edges = new LinkedList[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			this.edges[i] = new LinkedList<Integer>();
		}

	}

	public void addEdge(int source, int destination) {
		this.edges[source].add(destination);

		// this.edges[destination].add(source);
	}

	public void printGraph() {
		for (int i = 0; i < vertexCount; i++) {
			System.out.println("\nAdjacency list of vertex: " + i);
			for (Integer val : this.edges[i]) {
				System.out.print(" -> " + val);
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		GraphAdjacencyListImpl graph = new GraphAdjacencyListImpl(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		graph.printGraph();
	}

}
