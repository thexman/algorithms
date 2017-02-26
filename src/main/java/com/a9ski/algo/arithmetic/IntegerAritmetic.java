package com.a9ski.algo.arithmetic;

import java.util.Comparator;

public class IntegerAritmetic implements Arithmetic<Integer>{

	private static final IntegerComparator comparator = new IntegerComparator(); 
	
	@Override
	public Integer add(Integer a, Integer b) {
		return a + b;
	}

	@Override
	public Integer substract(Integer a, Integer b) {
		return a - b;
	}

	@Override
	public Integer multiply(Integer a, Integer b) {
		return a * b;
	}

	@Override
	public Integer divide(Integer a, Integer b) {
		return a / b;
	}

	@Override
	public Integer negative(Integer a) {
		return -a;
	}

	@Override
	public Integer minValue() {
		return Integer.MIN_VALUE;
	}

	@Override
	public Integer maxValue() {
		return Integer.MAX_VALUE;
	}

	@Override
	public Integer zero() {
		return 0;
	}

	@Override
	public Comparator<Integer> comparator() {
		return comparator;
	}
	
}
