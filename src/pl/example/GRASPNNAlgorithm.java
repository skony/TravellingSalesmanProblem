package pl.example;

import static pl.example.Constance.PATH_DISTANCE;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GRASPNNAlgorithm implements Algorithm{
	
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
			Edge edgeToNextVertex = candidateEdgeToNextVertex(currentVertex);
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
	
	private Edge candidateEdgeToNextVertex(Vertex vertex) {
		Collections.sort(vertex.getEdges());
		Edge[] candidates = new Edge[3];
		int j = 0;
		for(Edge edge : vertex.getEdges()) {
			if(edge.getDestinationVertex().isNotVisited()) {
				candidates[j] = edge;
				if(++j == 3) {
					break;
				}
			}
		}
		int random = ThreadLocalRandom.current().nextInt(0, 3);
		return candidates[random];
	}
}
