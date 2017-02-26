package com.a9ski.algo.arithmetic;

import java.util.Comparator;

public class DoubleArithmetic implements Arithmetic<Double> {

	private static final DoubleComparator comparator = new DoubleComparator();
	
	@Override
	public Double add(Double a, Double b) {
		return a + b;
	}

	@Override
	public Double substract(Double a, Double b) {
		return a - b;
	}

	@Override
	public Double multiply(Double a, Double b) {
		return a * b;
	}

	@Override
	public Double divide(Double a, Double b) {
		return a / b;
	}

	@Override
	public Double negative(Double a) {
		return -a;
	}

	@Override
	public Double minValue() {
		return Double.MIN_VALUE;
	}

	@Override
	public Double maxValue() {
		return Double.MAX_VALUE;
	}

	@Override
	public Double zero() {
		return 0D;
	}

	@Override
	public Comparator<Double> comparator() {
		return comparator;
	}

}
