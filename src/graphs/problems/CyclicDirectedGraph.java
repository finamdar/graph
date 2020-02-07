package graphs.problems;

import java.util.List;

import graphs.adjacencylist.GraphAdjacencyListImpl;
import graphs.creator.GraphCreator;

public class CyclicDirectedGraph {

	static GraphAdjacencyListImpl graph = GraphCreator.createGraphForCyclicDirectedCase();

	public static void main(String[] args) {
		if(isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't "
                                    + "contain cycle"); 
	}

	// This function is a variation of DFSUtil() in
	// https://www.geeksforgeeks.org/archives/18212
	private static boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

		// Mark the current node as visited and
		// part of recursion stack
		if (recStack[i])
			return true;

		if (visited[i])
			return false;

		visited[i] = true;

		recStack[i] = true;
		List<Integer> children = graph.edges[i];

		for (Integer c : children)
			if (isCyclicUtil(c, visited, recStack))
				return true;

		recStack[i] = false;//this is very important!!

		return false;
	}

	// Returns true if the graph contains a
	// cycle, else false.
	// This function is a variation of DFS() in
	// https://www.geeksforgeeks.org/archives/18212
	private static boolean isCyclic() {

		// Mark all the vertices as not visited and
		// not part of recursion stack
		boolean[] visited = new boolean[graph.vertexCount];
		boolean[] recStack = new boolean[graph.vertexCount];

		// Call the recursive helper function to
		// detect cycle in different DFS trees
		for (int i = 0; i < graph.vertexCount; i++)
			if (isCyclicUtil(i, visited, recStack))
				return true;

		return false;
	}

}
