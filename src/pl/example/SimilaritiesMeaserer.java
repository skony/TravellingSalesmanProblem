package pl.example;

import java.util.ArrayList;
import java.util.List;

import pl.example.datastructures.Vertex;

public class SimilaritiesMeaserer {
	
	private List<List<Vertex>> sampleResults;
	
	public SimilaritiesMeaserer(List<List<Vertex>> sampleResults) {
		this.sampleResults = sampleResults;
	}

	public List<Double> byVertexesToEach() {
		List<Double> similarities = new ArrayList<Double>();
		for(List<Vertex> path : sampleResults) {
			double oneSimilarity = compareVertexesToOthers(path);
			similarities.add(oneSimilarity);
		}
		return similarities;
	}
	
	public List<Double> byVertexesToBest() {
		
	}
	
	private double compareVertexesToOthers(List<Vertex> path) {
		int sumOfSameVertexes = 0;
		for(List<Vertex> otherPath : sampleResults) {
			if(!path.equals(otherPath)) {
				for(Vertex v : path) {
					if(otherPath.contains(v)) {
						sumOfSameVertexes++;
					}
				}
			}
		}
		return ((double)sumOfSameVertexes) / 999.0;
	}
	
	private List<Vertex> getBestSolution() {
		int bestResult = Integer.MAX_VALUE;
		
	}
	
	private int countPathCost(List<Vertex> path) {
		int cost = 0;
		for(int j=0; j<path.size(); j++) {
			if(j+1 < path.size()) {
				cost += AlgorithmsCommon.getDistance(path.get(j), path.get(j+1));
			} else {
				cost += AlgorithmsCommon.getDistance(path.get(j), path.get(0));
			}
		}
	}
}
