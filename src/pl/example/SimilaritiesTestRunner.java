package pl.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pl.example.algorithms.Algorithm;
import pl.example.algorithms.ls.LocalSearchAlgorithm;
import pl.example.datastructures.Graph;
import pl.example.datastructures.Vertex;

public class SimilaritiesTestRunner {

	public void runTest(Graph graph, Algorithm tspAlgorithm) {
		List<List<Vertex>> generatedPaths = new ArrayList<List<Vertex>>();
		LocalSearchAlgorithm localSearch = new LocalSearchAlgorithm();
		Random random = new Random();
		for(int i=0; i<1000; i++) {
			int num = random.nextInt(100);
			tspAlgorithm.run(graph, graph.getVertex(num));
			List<Vertex> path = tspAlgorithm.getPath();
			generatedPaths.add(path);
		}
		SimilaritiesMeaserer similaritiesMeaserer = new SimilaritiesMeaserer(generatedPaths);
		List<Double> byVertexesToEach = similaritiesMeaserer.byVertexesToEach();
		for(double d : byVertexesToEach) {
			System.out.println(d);
		}
	}
}
