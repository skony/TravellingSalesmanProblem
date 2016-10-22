package pl.example;

import java.util.List;

public class TestRunner {
	
	private int lastAlgorithmBestValue;
	private int lastAlgorithmWorstValue;
	private int lastAlgorithmAvarageValue;
	private List<Vertex> lastAlgorithmBestPath;
	
	public void runTest(Algorithm algorithm, Graph graph){
		List<Vertex> bestPath = null;
		int bestResult = Integer.MAX_VALUE;
		int worstResult = 0;
		int sum = 0;
		for(int i = 0; i < 100; i++) {
			algorithm.run(graph, graph.getVertex(i));
			int result = algorithm.getResult();
			sum += result;
			if(result < bestResult) {
				bestResult = result;
				bestPath = algorithm.getPath();
			}
			if(result > worstResult) {
				worstResult = result;
			}
			List<Vertex> path = algorithm.getPath();
		}
		lastAlgorithmBestValue = bestResult;
		lastAlgorithmWorstValue = worstResult;
		lastAlgorithmBestPath = bestPath;
		Double d = ((((double) sum) / ((double) 100)) + 0.5);
		lastAlgorithmAvarageValue = d.intValue();
	}

	public int getLastRunBestValue() {
		return lastAlgorithmBestValue;
	}

	public int getLastRunWorstValue() {
		return lastAlgorithmWorstValue;
	}

	public int getLastRunAvarageValue() {
		return lastAlgorithmAvarageValue;
	}

	public List<Vertex> getLastRunBestPath() {
		return lastAlgorithmBestPath;
	}
}
