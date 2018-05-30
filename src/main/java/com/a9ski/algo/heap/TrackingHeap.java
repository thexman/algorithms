package com.a9ski.algo.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrackingHeap<T> extends Heap<T> {

	private Map<T, Integer> index = new HashMap<T, Integer>();
	
	public TrackingHeap(Comparator<T> comparator, List<T> list) {
		super(comparator, list);
		for(int i = 0; i < list.size(); i++) {
			index.put(list.get(i), i);
		}
	}
	
	@SafeVarargs
	public TrackingHeap(Comparator<T> comparator, T...elements) {
		this(comparator, new ArrayList<T>(Arrays.asList(elements)));
	}
	
	/**
	 * Indicates that element with value <tt>V</tt> is changed so the heap property should be checked
	 * @param i
	 */
	public void valueChanged(T v) {
		final int ind = index.get(v);
		heapify(ind);
		heapifyParent(ind);
	}
	
	@Override
	protected void exchange(int i, int j) {
		index.put(getHeap().get(i), j);
		index.put(getHeap().get(j), i);
		super.exchange(i, j);
	}
	
	@Override
	protected T remove(int i) {
		final T val = getHeap().get(i);
		index.put(val, -1);
		return super.remove(i);
	}

}
