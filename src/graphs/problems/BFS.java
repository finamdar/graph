package graphs.problems;

import java.util.LinkedList;
import java.util.Queue;

import graphs.adjacencylist.GraphAdjacencyListImpl;
import graphs.creator.GraphCreator;

public class BFS {

	static GraphAdjacencyListImpl graph = GraphCreator.createGraph();
	
	public static void main(String[] args) {
		bfs(0);
	}
	
	public static void bfs(int start) {
		System.out.println("*********BFS Start*************");
		boolean visited[] = new boolean[graph.vertexCount];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			visited[start] = true;
			System.out.println("Visiting node: " + current);
			for (Integer val : graph.edges[current]) {
				if (!visited[val]) {
					queue.offer(val);
					visited[val] = true;
				}
			}
		}
		System.out.println("*********DFS END*************");
	}

}
