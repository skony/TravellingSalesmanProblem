package pl.example;

public class Edge {

	private final int destinationVertex;
	private final double cost;
	
	public Edge(int destinationVertex, double cost) {
		this.destinationVertex = destinationVertex;
		this.cost = cost;
	}
}
