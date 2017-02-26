package com.a9ski.algo.arithmetic;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

	private final Comparator<T> cmp;
	
	public ReverseComparator(Comparator<T> cmp) {
		super();
		this.cmp = cmp;
	}

	@Override
	public int compare(T o1, T o2) {
		return cmp.compare(o2, o1);
	}

}
