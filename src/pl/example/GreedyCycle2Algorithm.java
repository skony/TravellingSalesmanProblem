package pl.example;

import static pl.example.Constance.PATH_DISTANCE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GreedyCycle2Algorithm extends TSPAlgorithm{

	@Override
	public void run(Graph graph, Vertex startVertex) {
		super.run(graph, startVertex);
		Edge edge  = AlgorithmsCommon.findEdgeToNearestUnvisitedNeighbour(startVertex);
		Vertex secondVertex = edge.getDestinationVertex();
		path.add(secondVertex);
		secondVertex.visit();
		List<Vertex> notVisitedVertex = graph.getUnvisitedVertexes();
		while(path.size() < PATH_DISTANCE) {
			addBestEdge(path, notVisitedVertex);
		}
		for(int i=0; i<path.size(); i++) {
			if(i+1 < path.size()) {
				result += AlgorithmsCommon.getDistance(path.get(i), path.get(i+1));
			} else {
				result += AlgorithmsCommon.getDistance(path.get(i), path.get(0));
			}
		}
	}
	
	@Override
	public String getName() {
		return "GREEDY CYCLE ALGORITHM";
	}
	
	private void addBestEdge(List<Vertex> cycle, List<Vertex> notVisitedVertex) {
		int bestDistance = Integer.MAX_VALUE;
		int positionToPut = 1;
		Vertex vertexToPut = null;
		for(Vertex vertex : notVisitedVertex) {
			for(int i=0; i<cycle.size() - 1; i++) {
				Vertex v1 = cycle.get(i);
				Vertex v2 = cycle.get(i+1);
				int distanceV1V2 = AlgorithmsCommon.getDistance(v1, v2);
				int distanceToV1 = AlgorithmsCommon.getDistance(vertex, v1);
				int distanceToV2 = AlgorithmsCommon.getDistance(vertex, v2);
				if(distanceToV1 + distanceToV2 - distanceV1V2 < bestDistance) {
					bestDistance = distanceToV1 + distanceToV2 - distanceV1V2;
					positionToPut = i + 1;
					vertexToPut = vertex;
				}
			}
		}
		cycle.add(positionToPut, vertexToPut);
		notVisitedVertex.remove(vertexToPut);
		vertexToPut.visit();
	}
}
