package com.a9ski.algo.arithmetic;

import java.util.Comparator;

public class LongArithmetic implements Arithmetic<Long> {

	private static final LongComparator comparator = new LongComparator();
	
	@Override
	public Long add(Long a, Long b) {
		return a + b;
	}

	@Override
	public Long substract(Long a, Long b) {
		return a - b;
	}

	@Override
	public Long multiply(Long a, Long b) {
		return a * b;
	}

	@Override
	public Long divide(Long a, Long b) {
		return a / b;
	}

	@Override
	public Long negative(Long a) {
		return -a;
	}

	@Override
	public Long minValue() {
		return Long.MIN_VALUE;
	}

	@Override
	public Long maxValue() {
		return Long.MAX_VALUE;
	}

	@Override
	public Long zero() {
		return 0L;
	}

	@Override
	public Comparator<Long> comparator() {
		return comparator;
	}

}
