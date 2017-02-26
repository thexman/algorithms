package com.a9ski.algo.graph;

import com.a9ski.algo.arithmetic.Arithmetic;

public class DirectedGraphBuilder<T> implements GraphBuilder<T> {
	
	private final Graph<T> graph;
	
	public DirectedGraphBuilder(final Arithmetic<T> arithmetic) {
		graph = new Graph<T>(arithmetic);
	}
	
	/* (non-Javadoc)
	 * @see com.a9ski.algo.graph.GraphBuilder#addEdge(int, int, T)
	 */
	@Override
	public GraphBuilder<T> addEdge(int from, int to, T weight) {		
		graph.addEdge(from, to, weight);		
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.a9ski.algo.graph.GraphBuilder#addVertex(int)
	 */
	@Override
	public GraphBuilder<T> addVertex(int v) {		
		graph.addVertex(v);
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.a9ski.algo.graph.GraphBuilder#build()
	 */
	@Override
	public Graph<T> build() {
		graph.build();
		return graph;
	}
}
