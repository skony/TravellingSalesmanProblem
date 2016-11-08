package pl.example.algorithms.tsp;

import static pl.example.Constance.VERTEXES_NUM;

import java.util.LinkedList;
import java.util.List;

import pl.example.AlgorithmsCommon;
import pl.example.algorithms.Algorithm;
import pl.example.datastructures.Edge;
import pl.example.datastructures.Graph;
import pl.example.datastructures.Vertex;

import static pl.example.Constance.PATH_DISTANCE;

public class GreedyCycleAlgorithm implements Algorithm {

	private int result;
	private int[] path = new int[51];
	
	@Override
	public void run(Graph graph, Vertex startVertex) {
		result = 0;
		path = new int[51];
		List<Vertex> cycle = new LinkedList<Vertex>();
		graph.clearGraph();
		startVertex.visit();
		Edge edge  = AlgorithmsCommon.findEdgeToNearestUnvisitedNeighbour(startVertex);
		cycle.add(startVertex);
		cycle.add(edge.getDestinationVertex());
		cycle.add(startVertex);
		edge.getDestinationVertex().visit();
		//result += edge.getCost();
		int currentPathDistance = 2;
		while(currentPathDistance < PATH_DISTANCE) {
			for(Vertex vertex : graph.getVertexes()) {
				if(vertex.isNotVisited() && currentPathDistance < PATH_DISTANCE) {
					addToCyle(cycle, vertex);
					vertex.visit();
					currentPathDistance++;
				}
//				} else if(vertex.isNotVisited()) {
//					
//				}
			}
		}
		for(int i=0; i<cycle.size(); i++) {
			path[i] = cycle.get(i).getNumber();
			if(i+1 < cycle.size()) {
				result += AlgorithmsCommon.getDistance(cycle.get(i), cycle.get(i+1));
			}
		}
		
	}

	@Override
	public int getResult() {
		return result;
	}

	@Override
	public List<Vertex> getPath() {
		return null;
	}
	
	private void addToCyle(List<Vertex> cycle, Vertex vertex) {
		int bestDistance = Integer.MAX_VALUE;
		int positionToPut = 1;
		for(int i=0; i<cycle.size() - 1; i++) {
			Vertex v1 = cycle.get(i);
			Vertex v2 = cycle.get(i+1);
			int distanceV1V2 = AlgorithmsCommon.getDistance(v1, v2);
			int distanceToV1 = AlgorithmsCommon.getDistance(vertex, v1);
			int distanceToV2 = AlgorithmsCommon.getDistance(vertex, v2);
			if(distanceToV1 + distanceToV2 - distanceV1V2 < bestDistance) {
				bestDistance = distanceToV1 + distanceToV2 - distanceV1V2;
				positionToPut = i + 1;
			}
		}
		cycle.add(positionToPut, vertex);
	}
	
	private void putIntoCycle(List<Vertex> cycle, Vertex vertex) {
		int bestDistance = Integer.MAX_VALUE;
		int positionToPut = 1;
		for(int i=1; i<cycle.size() - 1; i++) {
			Vertex v1 = cycle.get(i-1);
			Vertex v2 = cycle.get(i+1);
			int distanceV1V2 = AlgorithmsCommon.getDistance(v1, v2);
			int distanceToV1 = AlgorithmsCommon.getDistance(vertex, v1);
			int distanceToV2 = AlgorithmsCommon.getDistance(vertex, v2);
			if(distanceToV1 + distanceToV2 - distanceV1V2 < bestDistance) {
				bestDistance = distanceToV1 + distanceToV2 - distanceV1V2;
				positionToPut = i + 1;
			}
		}
		cycle.add(positionToPut, vertex);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
