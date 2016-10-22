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
		algorithms.add(new RandomAlgorithm());
		TestRunner testRunner = new TestRunner();
		for(Algorithm algorithm : algorithms) {
			testRunner.runTest(algorithm, graph);
			List<Vertex> bestPath = testRunner.getLastRunBestPath();
			System.out.println("MIN: " + testRunner.getLastRunBestValue());
			System.out.println("MAX: " + testRunner.getLastRunWorstValue());
			System.out.println("AVG: " + testRunner.getLastRunAvarageValue());
			System.out.print("[");
			for(Vertex v : bestPath) {
				System.out.print(v.getNumber() + ", ");
			}
			System.out.print(bestPath.get(0).getNumber() + ", ");
			System.out.println("]");
		}
	}
}
