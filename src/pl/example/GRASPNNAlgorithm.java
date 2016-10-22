package pl.example;

import static pl.example.Constance.PATH_DISTANCE;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GRASPNNAlgorithm extends TSPAlgorithm{
	
	@Override
	public void run(Graph graph, Vertex startVertex) {
		super.run(graph, startVertex);
		Vertex currentVertex = startVertex;
		int currentPathDistance = 1;
		while(currentPathDistance < PATH_DISTANCE) {
			Edge edgeToNextVertex = candidateEdgeToNextVertex(currentVertex);
			currentVertex =  edgeToNextVertex.getDestinationVertex();
			currentVertex.visit();
			result += edgeToNextVertex.getCost();
			path.add(currentVertex);
			currentPathDistance++;
		}
		result += AlgorithmsCommon.getDistance(path.get(49), path.get(0));
	}
	
	@Override
	public String getName() {
		return "GRASPNN ALGORITHM";
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
