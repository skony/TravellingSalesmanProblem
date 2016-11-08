package pl.example.datastructures;

public class Edge implements Comparable<Edge> {

	private final Vertex destinationVertex;
	private final int cost;
	
	public Edge(Vertex destinationVertex, int cost) {
		this.destinationVertex = destinationVertex;
		this.cost = cost;
	}

	public Vertex getDestinationVertex() {
		return destinationVertex;
	}

	public int getCost() {
		return cost;
	}

	@Override
	public int compareTo(Edge o) {
		return cost - o.getCost();
	}
}
