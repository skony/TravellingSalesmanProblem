package pl.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlgorithmsCommon {

	public static Edge findEdgeToNearestUnvisitedNeighbour(Vertex vertex) {
		int shortestDistance = Integer.MAX_VALUE;
		Edge edgeToNearestVertex = null;
		for(Edge edge : vertex.getEdges()) {
			if(edge.getDestinationVertex().isNotVisited() && edge.getCost() < shortestDistance) {
				shortestDistance = edge.getCost();
				edgeToNearestVertex = edge;
			}
		}
		
		return edgeToNearestVertex;
	}
	
	public static int getDistance(Vertex v1, Vertex v2) {
		for(Edge e : v1.getEdges()) {
			if(e.getDestinationVertex().equals(v2)) {
				return e.getCost();
			}
		}
		return Integer.MAX_VALUE;
	}
	
	public static List<Vertex> replaceEdges(int pos1, int pos2, List<Vertex> path) {
		if(AlgorithmsCommon.checkDuplicates(path)) {
			int x;
			x =1;
			AlgorithmsCommon.printPath(path);
		}
		List<Vertex> fragment1 = path.subList(0, pos1+1);
		List<Vertex> fragment2 = revertListFragment(pos1+1, pos2, path);
		List<Vertex> fragment3 = new ArrayList<Vertex>();
		if(pos2<49) {
			fragment3 = path.subList(pos2+1, 50);
		}
		List<Vertex> newPath = new ArrayList<Vertex>();
		newPath.addAll(fragment1);
		newPath.addAll(fragment2);
		newPath.addAll(fragment3);
		if(AlgorithmsCommon.checkDuplicates(newPath)) {
			int x;
			x =1;
			AlgorithmsCommon.printPath(newPath);
		}
		return newPath;
	}
	
	private static List<Vertex> revertListFragment(int pos1, int pos2, List<Vertex> path) {
		List<Vertex> revertedFragment = new ArrayList<Vertex>();
		for(int i=pos2; i>=pos1; i--) {
			revertedFragment.add(path.get(i));
		}
		return revertedFragment;
	}
	
	public static void printPath(List<Vertex> path) {
		System.out.print("[");
		for(Vertex v : path) {
			System.out.print(v.getNumber() + ", ");
		}
		System.out.print(path.get(0).getNumber() + ", ");
		System.out.println("]");
	}
	
	public static boolean checkDuplicates(List<Vertex> list) {
		Set<Vertex> set = new HashSet<Vertex>(list);
		if(set.size() < list.size()) {
			return true;
		}
		return false;
	}
}
