package com.a9ski.algo.string;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class LongestCommonPrefixTest {

	@Test
	public void testLcp() {
		final LongestCommonPrefix lcp = new LongestCommonPrefix("ABABBAB");
		assertEquals(Arrays.asList(0,2,2,0,1,3,1), Arrays.asList(lcp.getLcp()));
		
		assertEquals(3, lcp.longestCommonPrefixLength(5));
		
		assertEquals("", lcp.longestCommonPrefix(0));
		assertEquals("AB", lcp.longestCommonPrefix(1));
		assertEquals("AB", lcp.longestCommonPrefix(2));
		assertEquals("", lcp.longestCommonPrefix(3));
		assertEquals("B", lcp.longestCommonPrefix(4));
		assertEquals("BAB", lcp.longestCommonPrefix(5));
		assertEquals("B", lcp.longestCommonPrefix(6));
	}

}
