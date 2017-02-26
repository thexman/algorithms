package com.a9ski.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IndexHeap extends Heap<Integer> {

	private final List<Integer> position = new ArrayList<Integer>();
	
	public IndexHeap(Comparator<Integer> comparator, List<Integer> list) {
		super(list, comparator);
		position.addAll(list);
		for(int i = 0; i < list.size(); i++) {
			position.set(list.get(i), i);
		}
		buildHeap();
	}
	
	@SafeVarargs
	public IndexHeap(Comparator<Integer> comparator, Integer...elements) {
		this(comparator, new ArrayList<>(Arrays.asList(elements)));
	}
	
	/**
	 * Indicates that element with <tt>index </tt> is changed so the heap property should be checked
	 * @param i
	 */
	public void valueChanged(Integer index) {
		final int pos = position.get(index);
		heapify(pos);
		heapifyParent(pos);
	}
	
	@Override
	protected void exchange(int i, int j) {
		final Integer indI = heap.get(i);
		final Integer indJ = heap.get(j);
		position.set(indI, j);		
		position.set(indJ, i);
		heap.set(i, indJ);
		heap.set(j, indI);
	}
	
	@Override
	protected Integer remove(int i) {
		final Integer ind = super.remove(i);
		position.set(ind, -1);
		return ind;
	}

}
