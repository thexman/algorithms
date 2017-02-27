package com.a9ski.algo.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.a9ski.algo.arithmetic.IntegerAritmetic;
import com.a9ski.algo.tuples.Pair;

public class GraphTest {

	/*
	 * https://upload.wikimedia.org/wikipedia/commons/5/57/Dijkstra_Animation.gif
	 * Edge between 2 and 4 is modified to be 16
	 * 
	 *            +---------16----------+
	 *            |                     |
	 * (1)---7---(2)---10---(3)---11---(4)---6---(5)---9---(6)  
	 *  |                    |                              |
	 *  +---------9----------+                              |
	 *  |                    |                              |
	 *  |                    +--------------2---------------+
	 *  |                                                   |
	 *  +------------------------14-------------------------+
	 * 
	 * from to weight
	 * 1 2 7
	 * 1 3 9
	 * 1 6 14
	 * 2 3 10
	 * 2 4 16
	 * 3 4 11
	 * 3 6 2
	 * 4 5 6
	 * 5 6 9
	 */
	private Graph<Integer> createGraph1() {
		final GraphBuilder<Integer> b = new UndirectedGraphBuilder<>(new IntegerAritmetic());
		b.addEdge(1, 2, 7);
		b.addEdge(1, 3, 9);
		b.addEdge(1, 6, 14);
		b.addEdge(2, 3, 10);
		b.addEdge(2, 4, 16);
		b.addEdge(3, 4, 11);
		b.addEdge(3, 6, 2);
		b.addEdge(4, 5, 6);
		b.addEdge(5, 6, 9);
		
		final Graph<Integer> g = b.build();
		return g;
	}
	
	@Test
	public void testDijkstra() {
		final Graph<Integer> g = createGraph1();
		final Pair<List<Integer>, List<Integer>> result = g.dijkstra(1);
		
		final List<Integer> expectedDist = new ArrayList<>();
		expectedDist.add(Integer.MAX_VALUE); //Vertex 0 is not connected to the graph
		expectedDist.add(0); //1
		expectedDist.add(7); //2
		expectedDist.add(9); //3
		expectedDist.add(20);//4
		expectedDist.add(20);//5
		expectedDist.add(11);//6
		
		assertEquals(expectedDist, result.get1());
		
		final List<Integer> expectedParent = new ArrayList<>();
		expectedParent.add(-1); //0 (vertex 0 doesn't have parent)
		expectedParent.add(-1); //1 (vertex 1 doesn't have parent)
		expectedParent.add(1); //2
		expectedParent.add(1); //3
		expectedParent.add(3); //4
		expectedParent.add(6); //5
		expectedParent.add(3); //6
		assertEquals(expectedParent, result.get2());
		

		assertEquals(Arrays.asList(), g.dijkstraPath(0, 1, result.get2()));
		assertEquals(Arrays.asList(), g.dijkstraPath(1, 1, result.get2()));
		assertEquals(Arrays.asList(1, 2), g.dijkstraPath(1, 2, result.get2()));
		assertEquals(Arrays.asList(1, 3), g.dijkstraPath(1, 3, result.get2()));
		assertEquals(Arrays.asList(1, 3, 4), g.dijkstraPath(1, 4, result.get2()));
		assertEquals(Arrays.asList(1, 3, 6, 5), g.dijkstraPath(1, 5, result.get2()));
		assertEquals(Arrays.asList(1, 3, 6), g.dijkstraPath(1, 6, result.get2()));
	}
	
	@Test
	public void testFloyd() throws Exception {
		final Graph<Integer> g = createGraph1();
		final Pair<Map<Pair<Integer, Integer>, Integer>, Map<Pair<Integer, Integer>, Integer>> floydResult = g.floyd();
		
		assertEquals(Integer.valueOf(20), floydResult.get1().get(Pair.of(1, 5)));
		
		final Map<Pair<Integer, Integer>, Integer> expectedDist = new HashMap<>();
		for(int i = 0; i < g.vertexCount(); i++) {
			System.out.println(i);
			final Pair<List<Integer>, List<Integer>> dijkstraResult = g.dijkstra(i);
			for(int j = 0; j < dijkstraResult.get1().size(); j++) {
				int w = dijkstraResult.get1().get(j);
				if (w < Integer.MAX_VALUE) {
					expectedDist.put(Pair.of(i, j), w);
					assertEquals("Path between " +i + " and " + j + " is incorrect", g.dijkstraPath(i, j, dijkstraResult.get2()), g.floydPath(i, j, floydResult.get2()));
				}
			}
		}
		
	}

	

}
