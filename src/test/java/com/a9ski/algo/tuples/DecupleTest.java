package com.a9ski.algo.tuples;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecupleTest {

	@Test
	public void testCreate() {
		final Decuple<Long, Long, Long, Long, Long, Long, Long, Long, Long, Long> d = Decuple.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
		
		assertEquals(Long.valueOf(1L), d.get1());
		assertEquals(Long.valueOf(2L), d.get2());
		assertEquals(Long.valueOf(3L), d.get3());
		assertEquals(Long.valueOf(4L), d.get4());
		assertEquals(Long.valueOf(5L), d.get5());
		assertEquals(Long.valueOf(6L), d.get6());
		assertEquals(Long.valueOf(7L), d.get7());
		assertEquals(Long.valueOf(8L), d.get8());
		assertEquals(Long.valueOf(9L), d.get9());
		assertEquals(Long.valueOf(10L), d.get10());
		
		assertEquals("Decuple [a=1, b=2, c=3, d=4, e=5, f=6, g=7, h=8, i=9, j=10]", d.toString());
	}

}
