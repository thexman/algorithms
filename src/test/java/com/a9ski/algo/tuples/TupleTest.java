package com.a9ski.algo.tuples;

import static org.junit.Assert.*;

import org.junit.Test;

public class TupleTest {

	@Test
	public void testCreate() {
		final Tuple<Integer> t = Tuple.of(1,2,3,4,5,6,7,8,9);
		
		final Integer[] expected = new Integer[] { 1,2,3,4,5,6,7,8,9 };
		assertArrayEquals(expected, t.getValues());
		
		assertEquals(Integer.valueOf(1), t.get1());
		assertEquals(Integer.valueOf(2), t.get2());
		assertEquals(Integer.valueOf(3), t.get3());
		assertEquals(Integer.valueOf(4), t.get4());
		assertEquals(Integer.valueOf(5), t.get5());
		assertEquals(Integer.valueOf(6), t.get6());
		assertEquals(Integer.valueOf(7), t.get7());
		assertEquals(Integer.valueOf(8), t.get8());
		assertEquals(Integer.valueOf(9), t.get9());
	}

}
