package pl.example.algorithms.tsp;

import static pl.example.Constance.VERTEXES_NUM;

import java.util.ArrayList;
import java.util.List;

import pl.example.AlgorithmsCommon;
import pl.example.datastructures.Edge;
import pl.example.datastructures.Graph;
import pl.example.datastructures.Vertex;

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
