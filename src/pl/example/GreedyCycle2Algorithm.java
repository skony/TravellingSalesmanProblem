package pl.example;

import static pl.example.Constance.PATH_DISTANCE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GreedyCycle2Algorithm implements Algorithm{
	
	private int result;
	private int[] path = new int[51];

	@Override
	public void run(Graph graph, Vertex startVertex) {
		result = 0;
		path = new int[51];
		List<Vertex> cycle = new LinkedList<Vertex>();
		Edge edge  = AlgorithmsCommon.findEdgeToNearestUnvisitedNeighbour(startVertex);
		cycle.add(startVertex);
		cycle.add(edge.getDestinationVertex());
		cycle.add(startVertex);
		List<Vertex> notVisitedVertex = cloneList(graph.getVertexes());
		notVisitedVertex.remove(startVertex);
		notVisitedVertex.remove(edge.getDestinationVertex());
		int currentPathDistance = 2;
		while(currentPathDistance < PATH_DISTANCE) {
			addBestEdge(cycle, notVisitedVertex);
			currentPathDistance++;
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
	public int[] getPath() {
		return path;
	}

	private List<Vertex> cloneList(List<Vertex> list) {
	    List<Vertex> clone = new ArrayList<Vertex>(list.size());
	    for (Vertex item : list) 
	    	clone.add(item);
	    return clone;
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
	}
}
