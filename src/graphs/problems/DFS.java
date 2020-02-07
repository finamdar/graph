package graphs.problems;

import java.util.Iterator;
import java.util.Stack;

import graphs.adjacencylist.GraphAdjacencyListImpl;
import graphs.creator.GraphCreator;

public class DFS {

	static GraphAdjacencyListImpl graph = GraphCreator.createGraph();
	
	public static void main(String[] args) {
		dfs(0);
		dfsIterative(0);
	}
	
	public static void dfs(int start) {
		System.out.println("*********DFS START*************");
		boolean[] visited = new boolean[graph.vertexCount];

		dfsHelper(start, visited);
		
		/*If graph is disjointed, that is there are nodes which are not connected, run DFS recursively.*/
/*		for(int i = 0; i < graph.vertexCount; i++) {
			dfsHelper(start, visited);
		}*/
		
		System.out.println("*********DFS END*************");
	}

	private static void dfsHelper(int start, boolean[] visited) {
		visited[start] = true;

		System.out.println("Visiting node: " + start);

		Iterator<Integer> itr = graph.edges[start].listIterator();
		while (itr.hasNext()) {
			Integer next = itr.next();
			if (!visited[next]) {
				dfsHelper(next, visited);
			}
		}
	}
	
	public static void dfsIterative(int start) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[graph.vertexCount];
		
		stack.push(start);
		visited[start] = true;
		System.out.println("Visiting Node: "+start);
		while(!stack.isEmpty()) {
			Integer current = stack.peek();
			Integer next = getUnvisitedNeighbour(current, visited);
			
			if(next != -1) {
				stack.push(next);
			}else {
				stack.pop();
			}
		}
	}
	
	private static Integer getUnvisitedNeighbour(int start, boolean[] visited) {
		Iterator<Integer> itr = graph.edges[start].listIterator();
		while(itr.hasNext()) {
			Integer next = itr.next();
			if(!visited[next]) {
				visited[next] = true;
				System.out.println("Visiting Node: "+next);
				return next;
			}
		}
		return -1;
	}

}
