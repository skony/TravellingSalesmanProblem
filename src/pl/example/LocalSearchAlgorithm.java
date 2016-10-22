package pl.example;

import java.util.Collections;
import java.util.List;

public class LocalSearchAlgorithm implements Algorithm{
	
	private int result;
	private List<Vertex> path;

	@Override
	public void run(Graph graph, Vertex startVertex) {	}
	
	public void run(Graph graph, List<Vertex> pathArg){
		path = pathArg;
		int j=0;
		while(true) {
			int bestDelta = Integer.MAX_VALUE;
			Vertex vertexToReplace = null;
			Vertex replacemenetVertex = null;
			for(int i=0; i<path.size(); i++) {
				for(Vertex v : graph.getUnvisitedVertexes()) {
					Vertex v1 = getVertexBefore(i, path);
					Vertex v2 = getVertexAfter(i, path);
					int currentDistance  = AlgorithmsCommon.getDistance(path.get(i), v1) 
							+ AlgorithmsCommon.getDistance(path.get(i), v2);
					int distanceAfterReplace = AlgorithmsCommon.getDistance(v, v1) + AlgorithmsCommon.getDistance(v, v2);
					if(distanceAfterReplace < currentDistance) {
						int delta = distanceAfterReplace - currentDistance;
						if(delta < bestDelta) {
							bestDelta = delta;
							vertexToReplace = path.get(i);
							replacemenetVertex = v;
						}
					}
				}
			}
			if(vertexToReplace != null) {
				Collections.replaceAll(path, vertexToReplace, replacemenetVertex);
				vertexToReplace.unvisit();
				replacemenetVertex.visit();
			} else {
				break;
			}
		}
		result = 0;
		for(int i=0; i<path.size(); i++) {
			if(i+1 < path.size()) {
				result += AlgorithmsCommon.getDistance(path.get(i), path.get(i+1));
			} else {
				result += AlgorithmsCommon.getDistance(path.get(i), path.get(0));
			}
		}
	}

	@Override
	public int getResult() {
		return result;
	}

	@Override
	public List<Vertex> getPath() {
		return path;
	}
	
	@Override
	public String getName() {
		return "LOCAL SEARCH";
	}

	private Vertex getVertexBefore(int vPosition, List<Vertex> path) {
		if(vPosition == 0) {
			return path.get(49);
		} else {
			return path.get(vPosition-1);
		}
	}
	
	private Vertex getVertexAfter(int vPosition, List<Vertex> path) {
		if(vPosition == 49) {
			return path.get(0);
		} else {
			return path.get(vPosition+1);
		}
	}
}
