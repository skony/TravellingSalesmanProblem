package pl.example;

import java.util.List;

public interface Algorithm {
	
	public void run(Graph graph, int startVertex);
	public double getResult();
	public int[] getPath();
}
