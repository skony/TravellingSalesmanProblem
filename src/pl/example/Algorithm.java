package pl.example;

import java.util.List;

public interface Algorithm {
	
	public void run(Graph graph, Vertex startVertex);
	public int getResult();
	public List<Vertex> getPath();
	public String getName();
}
