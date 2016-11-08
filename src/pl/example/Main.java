package pl.example;

import java.util.ArrayList;
import java.util.List;

import pl.example.algorithms.Algorithm;
import pl.example.algorithms.tsp.GRASPGCAlgorithm;
import pl.example.algorithms.tsp.GRASPNNAlgorithm;
import pl.example.algorithms.tsp.GreedyCycle2Algorithm;
import pl.example.algorithms.tsp.NearestNeighbourAlgorithm;
import pl.example.algorithms.tsp.RandomAlgorithm;
import pl.example.datastructures.Graph;

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
		SimilaritiesTestRunner similaritiesTestRunner = new SimilaritiesTestRunner();
		similaritiesTestRunner.runTest(graph, new RandomAlgorithm());
//		ExtendedTestRunner extendedTestRunner = new ExtendedTestRunner();
//		extendedTestRunner.runTest(graph, new RandomAlgorithm());
//		System.out.println("MULTIPLE START LOCAL SEARCH");
//		System.out.println("MIN: " + extendedTestRunner.getMSLSBestValue());
//		System.out.println("MAX: " + extendedTestRunner.getMSLSWorstValue());
//		System.out.println("AVG: " + extendedTestRunner.getMSLSAvarageValue());
//		System.out.println("MULTIPLE START LOCAL SEARCH TIME OF EXECUTION");
//		System.out.println("MIN: " + extendedTestRunner.getMSLSBestTime() + " ms");
//		System.out.println("MAX: " + extendedTestRunner.getMSLSWorstTime() + " ms");
//		System.out.println("AVG: " + extendedTestRunner.getMSLSAvarageTime() + " ms");
//		System.out.println("ITERABLE LOCAL SEARCH");
//		System.out.println("MIN: " + extendedTestRunner.getILSBestValue());
//		System.out.println("MAX: " + extendedTestRunner.getILSWorstValue());
//		System.out.println("AVG: " + extendedTestRunner.getILSAvarageValue());
//		TestRunner testRunner = new TestRunner();
//		for(Algorithm algorithm : algorithms) {
//			System.out.println(algorithm.getName());
//			testRunner.runTest(algorithm, graph);
//			List<Vertex> bestPath = testRunner.getLastRunBestPath();
//			System.out.println("MIN: " + testRunner.getLastRunBestValue());
//			System.out.println("MAX: " + testRunner.getLastRunWorstValue());
//			System.out.println("AVG: " + testRunner.getLastRunAvarageValue());
//			System.out.print("[");
//			for(Vertex v : bestPath) {
//				System.out.print(v.getNumber() + ", ");
//			}
//			System.out.print(bestPath.get(0).getNumber() + ", ");
//			System.out.println("]");
//			System.out.println(algorithm.getName() + " AFTER LOCAL SEARCH");
//			List<Vertex> bestPath2 = testRunner.getLocalSearchBestPath();
//			System.out.println("MIN: " + testRunner.getLocalSearchBestValue());
//			System.out.println("MAX: " + testRunner.getLocalSearchhWorstValue());
//			System.out.println("AVG: " + testRunner.getLocalSearchAvarageValue());
//			System.out.print("[");
//			for(Vertex v : bestPath2) {
//				System.out.print(v.getNumber() + ", ");
//			}
//			System.out.print(bestPath2.get(0).getNumber() + ", ");
//			System.out.println("]");
//			System.out.println(algorithm.getName() + " TIMES OF EXECUTION");
//			System.out.println("MIN: " + testRunner.getLocalSearchBestTime() + " ms");
//			System.out.println("MAX: " + testRunner.getLocalSearchWorstTime() + " ms");
//			System.out.println("AVG: " + testRunner.getLocalSearchAvarageTime() + " ms");
//		}
	}
}
