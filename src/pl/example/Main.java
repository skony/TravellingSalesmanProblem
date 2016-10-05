package pl.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		FileToGraphReader fileToGraphReader = new FileToGraphReader();
		Graph graph = fileToGraphReader.read();
		List<Algorithm> algorithms = new ArrayList<Algorithm>();
		TestRunner testRunner = new TestRunner();
		for(Algorithm algorithm : algorithms) {
			testRunner.runTest(algorithm, graph);
		}
	}
}
