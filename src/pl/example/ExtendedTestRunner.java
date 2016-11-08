package pl.example;

import pl.example.algorithms.Algorithm;
import pl.example.algorithms.ls.IteratedLocalSearchAlgorithm;
import pl.example.algorithms.ls.MultipleStartLocalSearchAlgorithm;
import pl.example.datastructures.Graph;

public class ExtendedTestRunner {
	
	private int MSLSBestValue;
	private int MSLSWorstValue;
	private int MSLSAvarageValue;
	private long MSLSBestTime;
	private long MSLSWorstTime;
	private long MSLSAvarageTime;
	private int ILSBestValue;
	private int ILSWorstValue;
	private int ILSAvarageValue;

	public void runTest(Graph graph, Algorithm tspAlgorithm) {
		MultipleStartLocalSearchAlgorithm multipleStartLocalSearch 
			= new MultipleStartLocalSearchAlgorithm();
		int bestResult = Integer.MAX_VALUE;
		int worstResult = 0;
		int sum = 0;
		long bestTime = Long.MAX_VALUE;
		long worstTime = 0L;
		long sumOfTimes = 0L;
		for(int i=0; i<10; i++) {
			long startTime = System.currentTimeMillis();
			multipleStartLocalSearch.run(graph, tspAlgorithm);
			long elapsedTime = System.currentTimeMillis() - startTime;
			int currentResult = multipleStartLocalSearch.getResult();
			if(currentResult < bestResult) {
				bestResult = currentResult;
			}
			if(currentResult > worstResult) {
				worstResult = currentResult;
			}
			sum += currentResult;
			if(elapsedTime < bestTime) {
				bestTime = elapsedTime;
			}
			if(elapsedTime > worstTime) {
				worstTime = elapsedTime;
			}
			sumOfTimes += elapsedTime;
		}
		MSLSBestValue = bestResult;
		MSLSWorstValue = worstResult;
		Double d = ((((double) sum) / ((double) 10)) + 0.5);
		MSLSAvarageValue = d.intValue();
		MSLSBestTime = bestTime;
		MSLSWorstTime = worstTime;
		d = ((((double) sumOfTimes) / ((double) 10)) + 0.5);
		MSLSAvarageTime = d.longValue();
		IteratedLocalSearchAlgorithm iterableLocalSearch = new IteratedLocalSearchAlgorithm();
		bestResult = Integer.MAX_VALUE;
		worstResult = 0;
		sum = 0;
		for(int i=0; i<10; i++) {
			iterableLocalSearch.run(graph, tspAlgorithm, MSLSAvarageTime);
			int currentResult = iterableLocalSearch.getResult();
			if(currentResult < bestResult) {
				bestResult = currentResult;
			}
			if(currentResult > worstResult) {
				worstResult = currentResult;
			}
			sum += currentResult;
		}
		ILSBestValue = bestResult;
		ILSWorstValue = worstResult;
		d = ((((double) sum) / ((double) 10)) + 0.5);
		ILSAvarageValue = d.intValue();
	}

	public int getMSLSBestValue() {
		return MSLSBestValue;
	}

	public int getMSLSWorstValue() {
		return MSLSWorstValue;
	}

	public int getMSLSAvarageValue() {
		return MSLSAvarageValue;
	}

	public long getMSLSBestTime() {
		return MSLSBestTime;
	}

	public long getMSLSWorstTime() {
		return MSLSWorstTime;
	}

	public long getMSLSAvarageTime() {
		return MSLSAvarageTime;
	}

	public int getILSBestValue() {
		return ILSBestValue;
	}

	public int getILSWorstValue() {
		return ILSWorstValue;
	}

	public int getILSAvarageValue() {
		return ILSAvarageValue;
	}
}
