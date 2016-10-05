package pl.example;

public class TestRunner {
	
	private double lastRunBestValue;
	private double lastRunWorstValue;
	private double lastRunAvarageValue;
	private int[] lastRunBestPath;
	
	public void runTest(Algorithm algorithm, Graph graph){
		int[] bestPath = new int[50];
		double bestResult = Double.MAX_VALUE;
		double worstResult = Double.MIN_NORMAL;
		double sum = 0.0;
		for(int i = 0; i < 100; i++) {
			algorithm.run(graph, i);
			double result = algorithm.getResult();
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
		lastRunAvarageValue = sum / 100;
	}

	public double getLastRunBestValue() {
		return lastRunBestValue;
	}

	public double getLastRunWorstValue() {
		return lastRunWorstValue;
	}

	public double getLastRunAvarageValue() {
		return lastRunAvarageValue;
	}

	public int[] getLastRunBestPath() {
		return lastRunBestPath;
	}
}
