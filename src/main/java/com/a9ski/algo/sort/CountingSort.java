package com.a9ski.algo.sort;

import com.a9ski.algo.arithmetic.IntegerComparator;

public class CountingSort extends AbstractSort<Integer> {

	public CountingSort() {
		super(new IntegerComparator());
	}

	@Override
	public void sort(Integer[] a) {
		Integer m = 0;
		for(int i = 0; i < a.length; i++) {
			if (less(m, a[i])) {
				m = a[i];
			}
		}
		int[] c = new int[m.intValue()+1];
		for(int i = 0; i < a.length; i++) {
			c[a[i]]++;
		}
		int ind = 0;
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[i]; j++) {
				a[ind] = i;
				ind++;
			}
		}
	}
	
	

}
