package pl.example;

import java.util.List;

public class LocalSearchAlgorithm implements Algorithm{
	
	private int result;
	private int[] path = new int[51];

	@Override
	public void run(Graph graph, Vertex startVertex) {	}
	
	public void run(Graph graph, int[] cycle) {
		while(true) {
			for(int i=0; i<cycle.length-1; i++) {
				for(Vertex v : graph.getUnvisitedVertexes()) {
					//int currentDistance = 
				}
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

}
