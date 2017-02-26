package com.a9ski.algo.arithmetic;

import java.util.Comparator;

public interface Arithmetic<T> {
	public T add(T a, T b);
	public T substract(T a, T b);
	public T multiply(T a, T b);
	public T divide(T a, T b);
	public T negative(T a);
	public T minValue();
	public T maxValue();
	public T zero();
	public Comparator<T> comparator();
	
	default int compare(T a, T b) {
		return comparator().compare(a, b);
	}
	
}
