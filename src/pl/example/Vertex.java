package pl.example;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private final int number;
	private List<Edge> edges;
	
	public Vertex(int number, List<Edge> edges) {
		this.number = number;
		this.edges = edges;
	}
	
	public Vertex(int number) {
		this.number = number;
		edges = new ArrayList<Edge>();
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
}
