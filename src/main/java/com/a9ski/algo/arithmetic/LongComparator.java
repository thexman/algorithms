package com.a9ski.algo.arithmetic;

import java.util.Comparator;

public class LongComparator implements Comparator<Long> {

	@Override
	public int compare(Long o1, Long o2) {
		return Long.compare(o1, o2);
	}

}
