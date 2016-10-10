package pl.example;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Cloneable{

	private final int number;
	private List<Edge> edges;
	private boolean visited;
	
	public Vertex(int number, List<Edge> edges) {
		this.number = number;
		this.edges = edges;
		visited = false;
	}
	
	public Vertex(int number) {
		this.number = number;
		edges = new ArrayList<Edge>();
	}
	
	private Vertex(Vertex vertex) {
		this.number = vertex.getNumber();
		this.edges = vertex.getEdges();
		this.visited = vertex.isVisited();
	}
	
	
	public int getNumber() {
		return number;
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public boolean isNotVisited() {
		return !visited;
	}
	
	public void visit() {
		visited = true;
	}
	
	public void unvisit() {
		visited = false;
	}
	
	@Override
	public Vertex clone() {
		return new Vertex(this);
	}
	
	public boolean equals(Vertex vertex) {
		return this.number==vertex.getNumber();
	}
}
