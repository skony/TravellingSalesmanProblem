package pl.example;

public class TestRunner {
	
	private int lastRunBestValue;
	private int lastRunWorstValue;
	private int lastRunAvarageValue;
	private int[] lastRunBestPath;
	
	public void runTest(Algorithm algorithm, Graph graph){
		int[] bestPath = new int[51];
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
		}
		lastRunBestValue = bestResult;
		lastRunWorstValue = worstResult;
		lastRunBestPath = bestPath;
		Double d = ((((double) sum) / ((double) 100)) + 0.5);
		lastRunAvarageValue = d.intValue();
	}

	public int getLastRunBestValue() {
		return lastRunBestValue;
	}

	public int getLastRunWorstValue() {
		return lastRunWorstValue;
	}

	public int getLastRunAvarageValue() {
		return lastRunAvarageValue;
	}

	public int[] getLastRunBestPath() {
		return lastRunBestPath;
	}
}
