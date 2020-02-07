package graphs.creator;

import graphs.adjacencylist.GraphAdjacencyListImpl;

public class GraphCreator {
	
	public static GraphAdjacencyListImpl createGraph() {
		GraphAdjacencyListImpl graph = new GraphAdjacencyListImpl(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		
		return graph;
	}
	
	public static GraphAdjacencyListImpl createGraphForCyclicDirectedCase() {
		GraphAdjacencyListImpl graph = new GraphAdjacencyListImpl(7);
		graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        //graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        //graph.addEdge(3, 3); 
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
        graph.addEdge(5, 4);
		
		return graph;
	}
	
	
	

}
