package com.a9ski.algo.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Heap<T> {
	protected final List<T> heap;
	protected final Comparator<T> comparator;
	
	protected Heap(List<T> list, Comparator<T> comparator) {
		this.comparator = comparator;
		heap = list;
	}
	
	public Heap(Comparator<T> comparator, List<T> list) {
		this.comparator = comparator;
		heap = list;
		buildHeap();
	}
	
	@SafeVarargs
	public Heap(Comparator<T> comparator, T...elements) {
		this(comparator, new ArrayList<T>(Arrays.asList(elements)));
	}
	
	protected int left(int i) {
		return 2*(i+1) - 1;
	}
	
	protected int right(int i) {
		return 2*(i+1);
	}
	
	protected int parent(int i) {		
		return (i+1)/2 - 1;
	}
	
	protected void exchange(int i, int j) {
		final T t = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, t);
	}
	
	protected T remove(int i) {
		return heap.remove(i);
	}
	
	public void heapify(int i) {
		heapify(i, heap.size());
	}
	
	public void heapify(int i, int size) {
//		final int size = heap.size();
		final int l = left(i);
		final int r = right(i);
		int largest;
		
		if (l < size && compareInd(l, i) > 0) {
			largest = l;
		} else {
			largest = i;
		}
		
		if (r < size && compareInd(r, largest) > 0) {
			largest = r;
		}
		
		if (largest != i) {
			exchange(largest, i);
			heapify(largest, size);
		}
	}
	
	public void buildHeap() {
		buildHeap(heap.size());
	}
	
	public void buildHeap(int size) {
		for(int i = parent(heap.size()-1); i >=0; i--) {
			heapify(i);
		}
	}

	public List<T> getHeap() {
		return heap;
	}
	
	public List<T> sort() {
		buildHeap();
		int size = heap.size();
		for(int i = size-1; i > 0; i--) {
			exchange(i, 0);
			size--;
			heapify(0, size);
		}
		//Collections.reverse(heap); // keep heapify property
		return getHeap();
	}
	
	public T getTop() {
		return heap.get(0);
	}
	
	public T removeTop() {
		final T max = heap.get(0);
		if (heap.size() > 1) {
			exchange(0, heap.size()-1);
			remove(heap.size()-1);
			heapify(0);
		} else if (heap.size() > 0){
			remove(0);
		}
		return max;
	}
	
	public int compareInd(int i, int j) {
		return comparator.compare(heap.get(i), heap.get(j));
	}
	
	public int compareVal(T a, T b) {
		return comparator.compare(a, b);
	}
	
	public void change(int i, T newVal) {
		final T oldVal = heap.get(i);
		heap.set(i, newVal);
		final int cmp = compareVal(newVal, oldVal);
		if (cmp < 0) {
			heapify(i);
		} else if (cmp > 0) {
			heapifyParent(i);
		}
	}
	

	protected void heapifyParent(int i) {
		int p = parent(i);
		while (i != 0 && compareInd(p, i) < 0) {
			exchange(p, i);
			i = p;
			p = parent(i);
		}
	}
	
	public void add(T newVal) {
		heap.add(newVal);
		heapifyParent(heap.size() - 1);
	}
	
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public boolean isNotEmpty() {
		return !isEmpty();
	}
	
	public static <T> void sort(Comparator<T> comparator, List<T> list) {
		final Heap<T> h = new Heap<>(comparator, list);
		h.sort();
	}
}
