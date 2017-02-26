package com.a9ski.algo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.a9ski.algo.arithmetic.Arithmetic;
import com.a9ski.algo.tuples.Pair;


public class Graph<T extends Number> {
	private final List<Edge<T>> edges = new ArrayList<>();
	private final Comparator<T> comparator;
	private final Map<Integer, Pair<Integer, Integer>> vertexes = new HashMap<>();
	
	private final Arithmetic<T> arithmetic;
	
	public Graph(final Comparator<T> comparator, Arithmetic<T> arithmetic) {
		super();
		this.comparator = comparator;
		this.arithmetic = arithmetic;
	}
	
	public void addEdge(int from, int to, T weight) {		
		edges.add(new Edge<T>(from, to, weight));
	}
	
	public void addVertex(int v) {		
		vertexes.put(v, Pair.of(-1, -1));
	}
	
	public void constructGraph() {
		edges.sort(new Comparator<Edge<T>>() {
			@Override
			public int compare(Edge<T> o1, Edge<T> o2) {
				return Integer.compare(o1.from, o2.from);
			}
		});
		for(int i = 0; i < edges.size(); i++) {
			final Edge<T> e = edges.get(i);
			Pair<Integer, Integer> v = vertexes.get(e.from);
			if (v == null) {
				v = Pair.of(i, i);
				vertexes.put(e.from, v);				
			}
			if (v.get1() < 0) {
				v.set1(i);
			}
			v.set2(i);
		}
	}
	
	public Pair<Map<Integer, T>, Map<Integer, Integer>> dijkstra(int start) {
		final Map<Integer, T> dist = new HashMap<>();
		final Map<Integer, Integer> parent= new HashMap<>();
		final Heap<Integer> heap = new Heap<>(-1, new Comparator<Integer>() {
			@Override
			public int compare(Integer v1, Integer v2) {
				return comparator.compare(dist.get(v2), dist.get(v1));
			}
		});
		for(final Integer v : vertexes.keySet()) {
			dist.put(v, arithmetic.maxValue());
			parent.put(v, -1);			
		}
		
		dist.put(start, arithmetic.zero());
		heap.add(start);
		
		while(heap.isNotEmpty()) {
			final int v = heap.removeTop();
			final Pair<Integer, Integer> edgeIndexes = vertexes.get(v);
			if (edgeIndexes.get1() != -1) {
				for(int i = edgeIndexes.get1(); i <= edgeIndexes.get2(); i++) {
					final Edge<T> e = edges.get(i);
					final T sum = arithmetic.add(dist.get(e.from), e.weight);
					if (comparator.compare(dist.get(e.to), sum) > 0) {
						dist.put(e.to, sum);
						parent.put(e.to, e.from);
					}
				}
			}
		}
		
		return Pair.of(dist, parent);
	}
	
}
