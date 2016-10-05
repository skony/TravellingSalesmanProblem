package pl.example;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private List<Vertex> vertexes;
	
	public Graph(List<Vertex> vertexes) {
		this.vertexes = vertexes;
	}
	
	public Graph() {
		vertexes = new ArrayList<Vertex>();
	}
	
	public void addVertex(Vertex vertex) {
		vertexes.add(vertex);
	}
}
