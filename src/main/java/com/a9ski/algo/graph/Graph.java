package com.a9ski.algo.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.a9ski.algo.Edge;
import com.a9ski.algo.IndexHeap;
import com.a9ski.algo.arithmetic.Arithmetic;
import com.a9ski.algo.tuples.Pair;


public class Graph<E> {
	private final List<Edge<E>> edges = new ArrayList<>();
	
	// pair(a,b); a = start index in edges list; b = end index in edges list
	private final List<Pair<Integer, Integer>> vertexes = new ArrayList<>(); 
	
	private final Arithmetic<E> arithmetic;
	
	protected Graph(Arithmetic<E> arithmetic) {
		super();
		this.arithmetic = arithmetic;		
	}
	
	protected void addEdge(int from, int to, E weight) {
		addVertex(Math.max(from, to));
		edges.add(new Edge<E>(from, to, weight));
	}
	
	protected void addVertex(int v) {
		if (vertexes.size() <= v) {
			for(int i = vertexes.size(); i <= v; i++) {
				vertexes.add(Pair.of(-1, -1));
			}
		}
	}
	
	protected void build() {
		edges.sort(new Comparator<Edge<E>>() {
			@Override
			public int compare(Edge<E> o1, Edge<E> o2) {
				return Integer.compare(o1.from, o2.from);
			}
		});
		for(int i = 0; i < edges.size(); i++) {
			final Edge<E> e = edges.get(i);
			final Pair<Integer, Integer> v = vertexes.get(e.from);			
			if (v.get1() < 0) {
				v.set1(i);
			}
			v.set2(i);
		}
	}
	
	/**
	 * Calculates the shortest paths from the <tt>start</tt> vertex to all other vertexes.
	 * Returns a pair of the shortest paths list and parents list
	 * 
	 * @param start the start vertex
	 * @return pair (element 1 is the shortest paths, element 2 is the parents)
	 */
	public Pair<List<E>, List<Integer>> dijkstra(int start) {
		final List<E> dist = new ArrayList<>(vertexes.size());
		final List<Integer> parent= new ArrayList<>(vertexes.size());
		
		final List<Integer> vertexList = new ArrayList<Integer>();
		for(int i = 0; i < vertexes.size(); i++) {
			parent.add(-1);
			dist.add(i == start ? arithmetic.zero() : arithmetic.maxValue());
			vertexList.add(i);
		}
		final Comparator<Integer> distComparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer v1, Integer v2) {
				return Graph.this.arithmetic.compare(dist.get(v2), dist.get(v1));
			}
		};
		final IndexHeap heap = new IndexHeap(distComparator, vertexList);
		heap.valueChanged(start);

		while(heap.isNotEmpty()) {
			final int v = heap.removeTop();
			final Pair<Integer, Integer> edgeIndexes = vertexes.get(v);
			if (edgeIndexes.get1() != -1) {
				for(int i = edgeIndexes.get1(); i <= edgeIndexes.get2(); i++) {
					final Edge<E> e = edges.get(i);
					final E sum = arithmetic.add(dist.get(e.from), e.weight);
					if (this.arithmetic.compare(dist.get(e.to), sum) > 0) {
						dist.set(e.to, sum);
						parent.set(e.to, e.from);
						heap.valueChanged(e.to);
					}
				}
			}
		}
		
		return Pair.of(dist, parent);
	}
	
}
