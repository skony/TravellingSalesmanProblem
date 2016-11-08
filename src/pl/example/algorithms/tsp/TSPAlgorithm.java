package pl.example.algorithms.tsp;

import java.util.ArrayList;
import java.util.List;

import pl.example.algorithms.Algorithm;
import pl.example.datastructures.Graph;
import pl.example.datastructures.Vertex;

public class TSPAlgorithm implements Algorithm{
	
	protected int result;
	protected List<Vertex> path;

	@Override
	public void run(Graph graph, Vertex startVertex) {
		result = 0;
		path = new ArrayList<Vertex>();
		graph.clearGraph();
		path.add(startVertex);
		startVertex.visit();
	}

	@Override
	public int getResult() {
		return result;
	}

	@Override
	public List<Vertex> getPath() {
		return path;
	}

	@Override
	public String getName() {
		return "TSP";
	}

}
