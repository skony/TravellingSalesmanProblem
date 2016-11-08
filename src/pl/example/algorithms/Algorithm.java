package pl.example.algorithms;

import java.util.List;

import pl.example.datastructures.Graph;
import pl.example.datastructures.Vertex;

public interface Algorithm {
	
	public void run(Graph graph, Vertex startVertex);
	public int getResult();
	public List<Vertex> getPath();
	public String getName();
}
