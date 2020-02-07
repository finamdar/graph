package graphs.adjacencymatrix;

/**
 * Important point to note in this implementation is that addEdge and
 * removeEdge, isEdge method checks for i >= 0 but only j > 0, this is because
 * if i=0 and j = 0 then it points to the same vertex
 * 
 * @author finamdar
 *
 */
public class GraphAdjacencyMatrixImpl {
	private boolean adjMatrix[][];
	private int vertexCount;
	
	public GraphAdjacencyMatrixImpl(int vertexCount) {
		this.vertexCount = vertexCount;
		this.adjMatrix = new boolean[vertexCount][vertexCount];
	}
	
	public void addEdge(int i, int j) {
		if(i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
			this.adjMatrix[i][j] = true;
			//this.adjMatrix[j][i] = true;
		}
	}
	
	public void removeEdge(int i, int j) {
		if(i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
			this.adjMatrix[i][j] = false;
			//this.adjMatrix[j][i] = false;
		}
	}
	
	public boolean isEdge(int i, int j) {
		if(i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
			return adjMatrix[i][j];
		}else return false;
	}
	
	public void dfs(int start) {
		boolean[] visited = new boolean[this.vertexCount];
		dfsHelper(start, visited);
	}

	private void dfsHelper(int start, boolean[] visited) {
		visited[start] = true;
		System.out.println("Visiting node: "+start);
		for(int j = 0; j < this.vertexCount; j++) {
			if(this.adjMatrix[start][j] && !visited[j]) {
				dfsHelper(j, visited);
			}
		}
	}
	
	
	public static void main(String args[]) {
		GraphAdjacencyMatrixImpl graph = new GraphAdjacencyMatrixImpl(5);
		graph.addEdge(0, 1); 
		graph.addEdge(0, 4); 
		graph.addEdge(1, 3); 
		graph.addEdge(1, 2); 
		graph.addEdge(1, 4); 
		graph.addEdge(2, 3); 
		graph.addEdge(3, 4); 
		
		//graph.printGraph();
		graph.dfs(0);
	}
	
	
	
	
}
