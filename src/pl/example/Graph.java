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
	
	public List<Vertex> getVertexes() {
		return vertexes;
	}
	
	public void addVertex(Vertex vertex) {
		vertexes.add(vertex);
	}
	
	public Vertex getVertex(int num) {
		return vertexes.get(num);
	}
	
	public void clearGraph() {
		for(Vertex vertex : vertexes) {
			vertex.unvisit();
		}
	}
}
