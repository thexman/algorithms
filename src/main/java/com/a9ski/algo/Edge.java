package com.a9ski.algo;

public class Edge<T> {
	public final T weight;
	public final int from;
	public final int to;
	
	public Edge(int from, int to, T weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}
