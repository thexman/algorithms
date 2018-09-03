package com.a9ski.algo.string;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SuffixArrayTest {

	@Test
	public void createSuffixArray() {
		// suffixes
		// 0 camel
		// 1 amel
		// 2 mel
		// 3 el
		// 4 l
		
		// suffix array:
		// 1 amel
		// 0 camel
		// 3 el
		// 4 l
		// 2 mel
		assertEquals(Arrays.asList(1,0,3,4,2), Arrays.asList(SuffixArray.suffixArray("camel")));
	}
	
	@Test
	public void testSuffixArray() {
		// suffixes
		// 0 camel
		// 1 amel
		// 2 mel
		// 3 el
		// 4 l
		
		// suffix array:
		// 1 amel
		// 0 camel
		// 3 el
		// 4 l
		// 2 mel
		final SuffixArray sa = new SuffixArray("camel");
		assertEquals(Arrays.asList(1,0,3,4,2), Arrays.asList(sa.getSuffixArray()));
		assertEquals("amel", sa.suffix(0));
		assertEquals("camel", sa.suffix(1));
		assertEquals("el", sa.suffix(2));
		assertEquals("l", sa.suffix(3));
		assertEquals("mel", sa.suffix(4));
	}

}
