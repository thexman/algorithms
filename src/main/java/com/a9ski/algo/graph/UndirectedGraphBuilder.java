package com.a9ski.algo.graph;

import com.a9ski.algo.arithmetic.Arithmetic;

public class UndirectedGraphBuilder<T> extends DirectedGraphBuilder<T> {

	public UndirectedGraphBuilder(Arithmetic<T> arithmetic) {
		super(arithmetic);
	}
	
	@Override
	public GraphBuilder<T> addEdge(int from, int to, T weight) {
		super.addEdge(from, to, weight);
		super.addEdge(to, from, weight);
		return this;
	}

}
