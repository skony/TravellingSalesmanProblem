package pl.example;

import static pl.example.Constance.VERTEXES_NUM;

import java.util.ArrayList;
import java.util.List;

import static pl.example.Constance.PATH_DISTANCE;

public class NearestNeighbourAlgorithm extends TSPAlgorithm{
	
	@Override
	public void run(Graph graph, Vertex startVertex) {
		super.run(graph, startVertex);
		Vertex currentVertex = startVertex;
		currentVertex.visit();
		while(path.size() < PATH_DISTANCE) {
			Edge edgeToNextVertex = AlgorithmsCommon.findEdgeToNearestUnvisitedNeighbour(currentVertex);
			currentVertex =  edgeToNextVertex.getDestinationVertex();
			currentVertex.visit();
			result += edgeToNextVertex.getCost();
			path.add(currentVertex);
		}
		result += AlgorithmsCommon.getDistance(currentVertex, startVertex);
	}
	
	@Override
	public String getName() {
		return "NEAREST NEIGHBOUR ALGORITHM";
	}
}
