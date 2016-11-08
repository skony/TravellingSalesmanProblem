package pl.example.algorithms.ls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import pl.example.AlgorithmsCommon;
import pl.example.DuplicateException;
import pl.example.algorithms.Algorithm;
import pl.example.datastructures.Graph;
import pl.example.datastructures.Vertex;

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
		int baseResult = algorithm.getResult();
		boolean firstPerturbation = true;
		int i = 0;
		while(true) {
			System.out.println(i++);
			List<Vertex> parturbatedPath;
			if(firstPerturbation) {
				parturbatedPath = perturbVertexes(graph, basePath);
				firstPerturbation = false;
			} else {
				parturbatedPath = perturbEdges(basePath);
				firstPerturbation = true;
			}
//			AlgorithmsCommon.printPath(parturbatedPath);			
			localSearch.run(graph, parturbatedPath);
			int newResult = localSearch.getResult();
			if(newResult<baseResult) {
				baseResult = newResult;
				basePath = localSearch.getPath();
			} else {
				basePath = returnToLastPath(basePath, graph);
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
		clonedList.addAll(list);
		return clonedList;
	}
	
	private List<Vertex> returnToLastPath(List<Vertex> last, Graph graph) {
		graph.clearGraph();
		for(Vertex v : last) {
			v.visit();
		}
		return last;
	}
}
