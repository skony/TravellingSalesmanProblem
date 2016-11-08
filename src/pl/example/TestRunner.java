package pl.example;

import java.util.ArrayList;
import java.util.List;

import pl.example.algorithms.Algorithm;
import pl.example.algorithms.ls.LocalSearchAlgorithm;
import pl.example.datastructures.Graph;
import pl.example.datastructures.Vertex;

public class TestRunner {
	
	private int lastAlgorithmBestValue;
	private int lastAlgorithmWorstValue;
	private int lastAlgorithmAvarageValue;
	private List<Vertex> lastAlgorithmBestPath;
	
	private int localSearchBestValue;
	private int localSearchhWorstValue;
	private int localSearchAvarageValue;
	private List<Vertex> localSearchBestPath;
	
	private long localSearchBestTime;
	private long localSearchWorstTime;
	private long localSearchAvarageTime;
	
	public void runTest(Algorithm algorithm, Graph graph){
		List<Vertex> bestPath = null;
		int bestResult = Integer.MAX_VALUE;
		int worstResult = 0;
		int sum = 0;
		
		List<Vertex> bestPath2 = null;
		int bestResult2 = Integer.MAX_VALUE;
		int worstResult2 = 0;
		int sum2 = 0;
		
		long bestTime = Long.MAX_VALUE;
		long worstTime = 0L;
		long sumOfTimes = 0L;
		
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
			List<Vertex> path = cloneList(algorithm.getPath());
			
			LocalSearchAlgorithm localSearch = new LocalSearchAlgorithm();
			long startTime = System.currentTimeMillis();
			localSearch.run(graph, path);
			long endTime = System.currentTimeMillis();
			result = localSearch.getResult();
			sum2 += result;
			if(result < bestResult2) {
				bestResult2 = result;
				bestPath2 = localSearch.getPath();
			}
			if(result > worstResult2) {
				worstResult2 = result;
			}
			long timeOfExecution = endTime - startTime;
			if(timeOfExecution<bestTime) {
				bestTime = timeOfExecution;
			}
			if(timeOfExecution>worstTime) {
				worstTime = timeOfExecution;
			}
			sumOfTimes += timeOfExecution;
		}
		lastAlgorithmBestValue = bestResult;
		lastAlgorithmWorstValue = worstResult;
		lastAlgorithmBestPath = bestPath;
		Double d = ((((double) sum) / ((double) 100)) + 0.5);
		lastAlgorithmAvarageValue = d.intValue();
		
		localSearchBestValue = bestResult2;
		localSearchhWorstValue = worstResult2;
		localSearchBestPath = bestPath2;
		d = ((((double) sum2) / ((double) 100)) + 0.5);
		localSearchAvarageValue = d.intValue();
		
		localSearchBestTime = bestTime;
		localSearchWorstTime = worstTime;
		d = ((((double) sumOfTimes) / ((double) 100)) + 0.5);
		localSearchAvarageTime = d.intValue();
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

	public int getLocalSearchBestValue() {
		return localSearchBestValue;
	}

	public int getLocalSearchhWorstValue() {
		return localSearchhWorstValue;
	}

	public int getLocalSearchAvarageValue() {
		return localSearchAvarageValue;
	}

	public List<Vertex> getLocalSearchBestPath() {
		return localSearchBestPath;
	}

	public long getLocalSearchBestTime() {
		return localSearchBestTime;
	}

	public long getLocalSearchWorstTime() {
		return localSearchWorstTime;
	}

	public long getLocalSearchAvarageTime() {
		return localSearchAvarageTime;
	}
	
	private List<Vertex> cloneList(List<Vertex> list) {
 	    List<Vertex> clone = new ArrayList<Vertex>(list.size());
 	    for (Vertex item : list) 
 	    	clone.add(item);
 	    return clone;
	}
}
