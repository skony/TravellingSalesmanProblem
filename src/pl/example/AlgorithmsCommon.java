package pl.example;

public class AlgorithmsCommon {

	public static Edge findEdgeToNearestUnvisitedNeighbour(Vertex vertex) {
		int shortestDistance = Integer.MAX_VALUE;
		Edge edgeToNearestVertex = null;
		for(Edge edge : vertex.getEdges()) {
			if(edge.getDestinationVertex().isNotVisited() && edge.getCost() < shortestDistance) {
				shortestDistance = edge.getCost();
				edgeToNearestVertex = edge;
			}
		}
		
		return edgeToNearestVertex;
	}
	
	public static int getDistance(Vertex v1, Vertex v2) {
		for(Edge e : v1.getEdges()) {
			if(e.getDestinationVertex().equals(v2)) {
				return e.getCost();
			}
		}
		return Integer.MAX_VALUE;
	}
	
	//public static int getDistanceToNeighbours()
}
