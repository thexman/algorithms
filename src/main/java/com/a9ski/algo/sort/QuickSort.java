package com.a9ski.algo.sort;

import java.util.Comparator;

public class QuickSort<T> extends AbstractSort<T> {
	
	public QuickSort(Comparator<T> cmp) {
		super(cmp);
	}
	
	public void sort(T[] a) {
		sort(a, 0, a.length - 1);
	}
	
	
	public void sort(T[] a, int l, int r) {
		int i = l;
		int j = r;
		T pivot = a[(l + r) / 2];
		while(i <= j) {
			while(less(a[i], pivot)) { // a[i] < pivot
				i++;
			}
			while(less(pivot, a[j])) { // pivot < a[j] 
				j--;
			}
			if (i <= j) {
				exchange(a, i, j);
				i++;
				j--;
			}
		}
		
		if (l < j) {
			sort(a, l, j);
		}
		if (i < r) {
			sort(a, i, r);
		}
	}

	
}
