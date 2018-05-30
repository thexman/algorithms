package com.a9ski.algo.sort;

import java.util.Comparator;

public abstract class AbstractSort<T> {

	protected final Comparator<T> cmp;
	
	protected AbstractSort(Comparator<T> cmp) {
		this.cmp = cmp;
	}
	
	protected void exchange(T[] array, int i, int j) {
		final T x = array[i];
		array[i] = array[j];
		array[j] = x;
	}
	
	protected boolean less(T a, T b) {
		return cmp.compare(a, b) < 0;
	}
	
	protected boolean lessOrEquals(T a, T b) {
		return !greater(a, b);
	}
	
	protected boolean greater(T a, T b) {
		return cmp.compare(a, b) > 0;
	}
	
	protected boolean greaterOrEquals(T a, T b) {
		return !less(a, b);
	}
	
	public abstract void sort(T[] a);
	
}
