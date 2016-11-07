package pl.example;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomAlgorithm extends TSPAlgorithm{

	@Override
	public void run(Graph graph, Vertex startVertex) {
		super.run(graph, startVertex);
		Random random = new Random();
		Set<Integer> generated = new LinkedHashSet<Integer>();
		generated.add(startVertex.getNumber());
		while (generated.size() < 50)
		{
		    Integer next = random.nextInt(100);
		    generated.add(next);
		}
		Iterator<Integer> iterator = generated.iterator();
		path.clear();
		int i=0;
		while(iterator.hasNext()) {
			Vertex v = graph.getVertex(iterator.next());
			path.add(i, v);
			v.visit();
			i++;
		}
		for(int j=0; j<path.size(); j++) {
			if(j+1 < path.size()) {
				result += AlgorithmsCommon.getDistance(path.get(j), path.get(j+1));
			} else {
				result += AlgorithmsCommon.getDistance(path.get(j), path.get(0));
			}
		}
		if(AlgorithmsCommon.checkDuplicates(path)) {
			int x;
			x =1;
			AlgorithmsCommon.printPath(path);
		}
	}
	
	@Override
	public String getName() {
		return "RANDOM ALGORITHM";
	}
}
