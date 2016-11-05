package pl.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocalSearchAlgorithm implements Algorithm{
	
	private int result;
	private List<Vertex> path;

	@Override
	public void run(Graph graph, Vertex startVertex) {	}
	
	public void run(Graph graph, List<Vertex> pathArg){
		path = pathArg;
		int k=0;
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
			int e1V1BestPosition = -1;
			int e2V1BestPosition = -1;
			for(int i=0; i<path.size()-1; i++) {
				Vertex e1V1 = path.get(i);
				Vertex e1V2 = path.get(i+1);
				for(int j=i+2; j<path.size(); j++) {
					if(i!=0 && j!=49) {
						Vertex e2V1 = path.get(j);
						Vertex e2V2 = getVertexAfter(j, path);
						
						int currentDistance = AlgorithmsCommon.getDistance(e1V1, e1V2) 
								+ AlgorithmsCommon.getDistance(e2V1, e2V2);
						int distanceAfterReplace = AlgorithmsCommon.getDistance(e1V1, e2V1) 
								+ AlgorithmsCommon.getDistance(e1V2, e2V2);
						if(distanceAfterReplace < currentDistance) {
							int delta = distanceAfterReplace - currentDistance;
							if(delta < bestDelta) {
								bestDelta = delta;
								e1V1BestPosition = i;
								e2V1BestPosition = j;
							}
						}
					}
				}
			}
			//System.out.println("Best delta " + bestDelta + " ... " + k);
			k++;
			if(e1V1BestPosition != -1 && e2V1BestPosition != -1) {
				path = replaceEdges(e1V1BestPosition, e2V1BestPosition, path);		
				
			} else if(vertexToReplace != null) {
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
	
	private List<Vertex> replaceEdges(int pos1, int pos2, List<Vertex> path) {
		List<Vertex> fragment1 = path.subList(0, pos1+1);
		List<Vertex> fragment2 = revertListFragment(pos1+1, pos2, path);
		List<Vertex> fragment3 = new ArrayList<Vertex>();
		if(pos2<49) {
			fragment3 = path.subList(pos2+1, 50);
		}
		List<Vertex> newPath = new ArrayList<Vertex>();
		newPath.addAll(fragment1);
		newPath.addAll(fragment2);
		newPath.addAll(fragment3);
		return newPath;
	}
	
	private List<Vertex> revertListFragment(int pos1, int pos2, List<Vertex> path) {
		List<Vertex> revertedFragment = new ArrayList<Vertex>();
		for(int i=pos2; i>=pos1; i--) {
			revertedFragment.add(path.get(i));
		}
		return revertedFragment;
	}
}
