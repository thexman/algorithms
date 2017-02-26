package com.a9ski.algo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.a9ski.algo.arithmetic.IntegerComparator;

public class HeapTest {

	private static final IntegerComparator COMPARATOR = new IntegerComparator();


	@Test
	public void testLeftRightParent() {
		final Heap<Integer> h = new Heap<>(COMPARATOR, 0, 1,2,3,4,5,6);
		assertEquals(1, h.left(0));
		assertEquals(2, h.right(0));
		assertEquals(0, h.parent(1));
		assertEquals(0, h.parent(2));
		
		assertEquals(3, h.left(1));
		assertEquals(4, h.right(1));
		assertEquals(1, h.parent(3));
		assertEquals(1, h.parent(4));
		
		assertEquals(5, h.left(2));
		assertEquals(6, h.right(2));
		assertEquals(2, h.parent(5));
		assertEquals(2, h.parent(6));		
	}
	
	
	@Test
	public void testHeapify() throws Exception {
		final Heap<Integer> h = new Heap<>(COMPARATOR, 4, 1,3,2,16,9,10,14,8,7);
		assertEquals(Arrays.asList(16, 14, 10, 8, 7, 9, 3, 2, 4, 1), h.getHeap());
	}
	
	@Test
	public void testChange() throws Exception {
		final Heap<Integer> h = new Heap<>(COMPARATOR, 4, 1,3,2,16,9,10,14,8,7);
		h.change(8, 17);
		assertEquals(Arrays.asList(17, 16, 10, 14, 7, 9, 3, 2, 8, 1), h.getHeap());
	}
	
	@Test
	public void testAdd() throws Exception {
		final Heap<Integer> h = new Heap<>(COMPARATOR, 4, 1,3,2,16,9,10,14,8,7);
		h.add(17);
		assertEquals(Arrays.asList(17, 16, 10, 8, 14, 9, 3, 2, 4, 1, 7), h.getHeap());
	}
	
	@Test
	public void testAddEmpty() throws Exception {
		final Heap<Integer> h = new Heap<>(COMPARATOR);
		h.add(15);
		h.add(16);
		h.add(17);
		assertEquals(Arrays.asList(17,15, 16), h.getHeap());
		
		h.removeTop();
		assertEquals(Arrays.asList(16,15), h.getHeap());
		
		h.removeTop();
		assertEquals(Arrays.asList(15), h.getHeap());
		
		h.removeTop();
		assertEquals(Arrays.asList(), h.getHeap());
	}
	
	
	@Test
	public void testSort() throws Exception {
		final Heap<Integer> h = new Heap<>(COMPARATOR, 4, 1,3,2,16,9,10,14,8,7);
//		assertEquals(Arrays.asList(16, 14, 10, 9, 8, 7, 4, 3, 2, 1), h.sort());
		assertEquals(Arrays.asList(1, 2, 3, 4, 7, 8, 9, 10, 14, 16), h.sort());
	}
	
	
	@Test
	public void testRandomSort() throws Exception {
		final List<Integer> list = new ArrayList<>();
		final Random r = new Random();
		for(int i = 0; i < 1000; i++) {
			list.add(r.nextInt(1000));
		}
		
		final Heap<Integer> h = new Heap<>(COMPARATOR, list);
		list.sort(COMPARATOR);
		assertEquals(list, h.sort());
	}


}
