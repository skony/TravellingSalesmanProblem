package pl.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		FileToGraphReader fileToGraphReader = new FileToGraphReader();
		Graph graph = fileToGraphReader.read();
		List<Algorithm> algorithms = new ArrayList<Algorithm>();
		algorithms.add(new NearestNeighbourAlgorithm());
		algorithms.add(new GreedyCycle2Algorithm());
		algorithms.add(new GRASPNNAlgorithm());
		algorithms.add(new GRASPGCAlgorithm());
		TestRunner testRunner = new TestRunner();
		for(Algorithm algorithm : algorithms) {
			testRunner.runTest(algorithm, graph);
			System.out.println("MIN: " + testRunner.getLastRunBestValue());
			System.out.println("MAX: " + testRunner.getLastRunWorstValue());
			System.out.println("AVG: " + testRunner.getLastRunAvarageValue());
			System.out.print("[");
			for(int i : testRunner.getLastRunBestPath()) {
				System.out.print(i + ", ");
			}
			System.out.println("]");
		}
	}
}
