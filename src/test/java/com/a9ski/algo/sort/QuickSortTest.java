package com.a9ski.algo.sort;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import com.a9ski.algo.arithmetic.IntegerComparator;

public class QuickSortTest {

	@Test
	public void testSortOdd() {
		Integer a[] = new Integer[] { 3,7,8,5,2 };
		final QuickSort<Integer> q = new QuickSort<>(new IntegerComparator());
		q.sort(a);
		for(int i = 1; i < a.length; i++) {
			assertTrue(a[i-1] <= a[i]);
		}
	}
	
	@Test
	public void testSortEven() {
		Integer a[] = new Integer[] { 3,7,8,1,5,2 };
		final QuickSort<Integer> q = new QuickSort<>(new IntegerComparator());
		q.sort(a);
		for(int i = 1; i < a.length; i++) {
			assertTrue(a[i-1] <= a[i]);
		}
	}
	
	@Test
	public void testRandom() {
		Random r = new Random();
		int n = r.nextInt(1000) + 100;
		Integer a[] = new Integer[n];
		for(int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(1000) - 500;
		}
		final QuickSort<Integer> q = new QuickSort<>(new IntegerComparator());
		q.sort(a);
		for(int i = 1; i < a.length; i++) {
			assertTrue(a[i-1] <= a[i]);
		}
	}

}
