package pl.example;

import static pl.example.Constance.VERTEXES_NUM;
import static pl.example.Constance.PATH_DISTANCE;

public class NearestNeighbourAlgorithm implements Algorithm{

	private int result;
	private int[] path = new int[51];
	
	@Override
	public void run(Graph graph, Vertex startVertex) {
		result = 0;
		path = new int[51];
		path[0] = startVertex.getNumber();
		graph.clearGraph();
		Vertex currentVertex = startVertex;
		currentVertex.visit();
		int currentPathDistance = 1;
		while(currentPathDistance < PATH_DISTANCE) {
			Edge edgeToNextVertex = AlgorithmsCommon.findEdgeToNearestUnvisitedNeighbour(currentVertex);
			currentVertex =  edgeToNextVertex.getDestinationVertex();
			currentVertex.visit();
			result += edgeToNextVertex.getCost();
			path[currentPathDistance] = currentVertex.getNumber();
			currentPathDistance++;
		}
		path[50] = startVertex.getNumber();
		result += AlgorithmsCommon.getDistance(currentVertex, startVertex);
	}

	@Override
	public int getResult() {
		return result;
	}

	@Override
	public int[] getPath() {
		return path;
	}
}
