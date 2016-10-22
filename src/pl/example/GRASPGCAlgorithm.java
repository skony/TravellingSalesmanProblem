package pl.example;

import static pl.example.Constance.PATH_DISTANCE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GRASPGCAlgorithm extends TSPAlgorithm{

	@Override
	public void run(Graph graph, Vertex startVertex) {
		super.run(graph, startVertex);
		Edge edge  = AlgorithmsCommon.findEdgeToNearestUnvisitedNeighbour(startVertex);
		path.add(edge.getDestinationVertex());
		List<Vertex> notVisitedVertex = cloneList(graph.getVertexes());
		int currentPathDistance = 2;
		while(currentPathDistance < PATH_DISTANCE) {
			addCandidateEdge(path, notVisitedVertex);
			currentPathDistance++;
		}
		for(int i=0; i<path.size(); i++) {
			if(i+1 < path.size()) {
				result += AlgorithmsCommon.getDistance(path.get(i), path.get(i+1));
			} else {
				result += AlgorithmsCommon.getDistance(path.get(i), path.get(0));
			}
		}
	}

	private List<Vertex> cloneList(List<Vertex> list) {
	    List<Vertex> clone = new ArrayList<Vertex>(list.size());
	    for (Vertex item : list) 
	    	clone.add(item);
	    return clone;
	}
	
	private void addCandidateEdge(List<Vertex> cycle, List<Vertex> notVisitedVertex) {
		Candidate[] candidates = new Candidate[3];
		candidates[0] = new Candidate(Integer.MAX_VALUE, 1, null);
		candidates[1] = new Candidate(Integer.MAX_VALUE, 1, null);
		candidates[2] = new Candidate(Integer.MAX_VALUE, 1, null);
		for(Vertex vertex : notVisitedVertex) {
			for(int i=0; i<cycle.size() - 1; i++) {
				Vertex v1 = cycle.get(i);
				Vertex v2 = cycle.get(i+1);
				int distanceV1V2 = AlgorithmsCommon.getDistance(v1, v2);
				int distanceToV1 = AlgorithmsCommon.getDistance(vertex, v1);
				int distanceToV2 = AlgorithmsCommon.getDistance(vertex, v2);
				if(distanceToV1 + distanceToV2 - distanceV1V2 < candidates[2].distance) {
					addCandidateToCandidates(candidates, new Candidate(distanceToV1 + distanceToV2 - distanceV1V2, i + 1, vertex));
				}
			}
		}
		int random = ThreadLocalRandom.current().nextInt(0, 3);
		cycle.add(candidates[random].positionToPut, candidates[random].vertexToPut);
		notVisitedVertex.remove(candidates[random].vertexToPut);
	}
	
	class Candidate {
		int distance;
		int positionToPut;
		Vertex vertexToPut;
		public Candidate(int distance, int positionToPut, Vertex vertexToPut) {
			super();
			this.distance = distance;
			this.positionToPut = positionToPut;
			this.vertexToPut = vertexToPut;
		}
	}
	
	private void addCandidateToCandidates(Candidate[] candidates, Candidate candidate) {
		if(candidate.distance < candidates[0].distance) {
			candidates[2] = candidates[1];
			candidates[1] = candidates[0];
			candidates[0] = candidate;
			return;
		}
		if(candidate.distance < candidates[1].distance) {
			candidates[2] = candidates[1];
			candidates[1] = candidate;
			return;
		}
		candidates[2] = candidate;
	}
}
