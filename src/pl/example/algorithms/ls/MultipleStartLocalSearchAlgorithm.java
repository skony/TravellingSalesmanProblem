package pl.example.algorithms.ls;

import java.util.List;
import java.util.Random;

import pl.example.AlgorithmsCommon;
import pl.example.DuplicateException;
import pl.example.algorithms.Algorithm;
import pl.example.datastructures.Graph;
import pl.example.datastructures.Vertex;

public class MultipleStartLocalSearchAlgorithm implements Algorithm{
	
	private int result;

	@Override
	public void run(Graph graph, Vertex startVertex) {}
	
	public void run(Graph graph, Algorithm algorithm) {
		LocalSearchAlgorithm localSearch = new LocalSearchAlgorithm();
		Random random = new Random();
		int bestResult = Integer.MAX_VALUE;
		for(int i=0; i<1000; i++) {
			System.out.println(i);
			int num = random.nextInt(100);
			algorithm.run(graph, graph.getVertex(num));
			List<Vertex> basePath = algorithm.getPath();
			localSearch.run(graph, basePath);
			int oneRunResult = localSearch.getResult();
			if(oneRunResult<bestResult) {
				bestResult = oneRunResult;
			}
		}
		result = bestResult;
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
		return null;
	}

}
