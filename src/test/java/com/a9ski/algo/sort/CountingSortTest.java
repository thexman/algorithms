package com.a9ski.algo.sort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class CountingSortTest {

	@Test
	public void testSortOdd() {
		Integer a[] = new Integer[] { 3,7,8,2,2 };
		final CountingSort q = new CountingSort();
		q.sort(a);
		assertArrayEquals(new Integer[] {2,2,3,7,8}, a);
	}
	
	@Test
	public void testSortEven() {
		Integer a[] = new Integer[] { 3,7,8,1,5,2 };
		final CountingSort q = new CountingSort();
		q.sort(a);
		assertArrayEquals(new Integer[] {1,2,3,5,7,8}, a);
	}
	
	@Test
	public void testRandom() {
		Random r = new Random();
		int n = r.nextInt(1000) + 100;
		Integer a[] = new Integer[n];
		for(int i = 0; i < a.length; i++) {
			a[i] = r.nextInt(1000);
		}
		final CountingSort q = new CountingSort();
		q.sort(a);
		for(int i = 1; i < a.length; i++) {
			assertTrue(a[i-1] <= a[i]);
		}
	}

}
