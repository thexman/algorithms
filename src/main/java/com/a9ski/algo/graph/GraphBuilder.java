package com.a9ski.algo.graph;

public interface GraphBuilder<T> {

	GraphBuilder<T> addEdge(int from, int to, T weight);

	GraphBuilder<T> addVertex(int v);

	Graph<T> build();

}