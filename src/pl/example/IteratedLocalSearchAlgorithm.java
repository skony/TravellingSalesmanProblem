package pl.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class IteratedLocalSearchAlgorithm implements Algorithm{
	
	private int result;

	@Override
	public void run(Graph graph, Vertex startVertex) {}
	
	public void run(Graph graph, Algorithm algorithm, long executionTime) {
		long startTime = System.currentTimeMillis();
		LocalSearchAlgorithm localSearch = new LocalSearchAlgorithm();
		Random random = new Random();
		int bestResult = Integer.MAX_VALUE;
		int num = random.nextInt(100);
		algorithm.run(graph, graph.getVertex(num));
		List<Vertex> basePath = algorithm.getPath();
		if(AlgorithmsCommon.checkDuplicates(basePath)) {
			int x;
			x =1;
			AlgorithmsCommon.printPath(basePath);
		}
		int baseResult = algorithm.getResult();
		boolean firstPerturbation = true;
		while(true) {
			List<Vertex> parturbatedPath;
			System.out.println("PATHS");
			AlgorithmsCommon.printPath(basePath);
			if(firstPerturbation) {
				if(AlgorithmsCommon.checkDuplicates(basePath)) {
					int x;
					x =1;
					AlgorithmsCommon.printPath(basePath);
				}
				parturbatedPath = perturbVertexes(graph, basePath);
				firstPerturbation = true;
			} else {
				parturbatedPath = perturbEdges(basePath);
				firstPerturbation = true;
			}
			if(AlgorithmsCommon.checkDuplicates(parturbatedPath)) {
				int x;
			}
			AlgorithmsCommon.printPath(parturbatedPath);
			localSearch.run(graph, parturbatedPath);
			int newResult = localSearch.getResult();
			if(newResult<baseResult) {
				baseResult = newResult;
				basePath = localSearch.getPath();
				if(AlgorithmsCommon.checkDuplicates(basePath)) {
					int x=1;
				}
			}
			long currentTime = System.currentTimeMillis();
			long elapsedTime = currentTime - startTime;
			if(elapsedTime > executionTime) {
				break;
			}
		}
		result = baseResult;
	}

	@Override
	public int getResult() {
		return result;
	}

	@Override
	public List<Vertex> getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Vertex> perturbVertexes(Graph graph, List<Vertex> path) {
		if(AlgorithmsCommon.checkDuplicates(path)) {
			int x;
			x =1;
			AlgorithmsCommon.printPath(path);
		}
		Random random = new Random();
		List<Vertex> perturbatedPath = cloneList(path);
		for(int i=0; i<3; i++) {
			List<Vertex> unvisitedVertexes = graph.getUnvisitedVertexes();
			int num1 = random.nextInt(50);
			int num2 = random.nextInt(50);
			Vertex vertexToReplace = perturbatedPath.get(num1);
			Vertex replacementVertex = unvisitedVertexes.get(num2);
			Collections.replaceAll(perturbatedPath, vertexToReplace, replacementVertex);
			vertexToReplace.unvisit();
			replacementVertex.visit();
			if(AlgorithmsCommon.checkDuplicates(perturbatedPath)) {
				int x;
				x =1;
				AlgorithmsCommon.printPath(perturbatedPath);
			}
		}
		if(AlgorithmsCommon.checkDuplicates(perturbatedPath)) {
			int x;
			x =1;
			AlgorithmsCommon.printPath(perturbatedPath);
		}
		return perturbatedPath;
	}
	
	private List<Vertex> perturbEdges(List<Vertex> path) {
		Random random = new Random();
		for(int i=0; i<3; i++) {
			int pos1,pos2;
			do {
				pos1 = random.nextInt(48);
				pos2 = random.nextInt(50-pos1-2) + pos1 + 2;
			} while(pos1==0 && pos2==49);
			path = AlgorithmsCommon.replaceEdges(pos1, pos2, path);
		}
		return path;
	}
	
	private List<Vertex> cloneList(List<Vertex> list) {
		List<Vertex> clonedList = new ArrayList<Vertex>();
		for(Vertex v : list) {
			clonedList.add(v);
		}
		return clonedList;
	}
}
