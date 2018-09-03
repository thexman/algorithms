package com.a9ski.algo.string;

import java.nio.CharBuffer;

public class LongestCommonPrefix {
	
	private final SuffixArray suffixArray;
	
	private final Integer[] lcp;
	
	public LongestCommonPrefix(String s) {
		this(new SuffixArray(s));
	}
	
	public LongestCommonPrefix(SuffixArray suffixArray) {
		this.suffixArray = suffixArray;
		this.lcp = calculateLcp();
	}
	
	public static int longestCommonPrefixLength(CharBuffer a, CharBuffer b) {
		int n = Math.min(a.remaining(), b.remaining());
		for(int i = 0; i < n; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				return i;
			}
		}
		return n;
	}
	
	public static int longestCommonPrefixLength(String a, String b) {
		return longestCommonPrefixLength(CharBuffer.wrap(a), CharBuffer.wrap(b));
	}
	
	private Integer[] calculateLcp() {
		final Integer[] lcp = new Integer[suffixArray.getSuffixArray().length];
		lcp[0] = 0;
		for(int i = 1; i < lcp.length; i++) {
			lcp[i] = longestCommonPrefixLength(suffixArray.suffixBuffer(i-1), suffixArray.suffixBuffer(i));
		}
		return lcp;
	}
	
	public Integer[] getLcp() {
		return lcp;
	}
	
	public SuffixArray getSuffixArray() {
		return suffixArray;
	}
	
	public CharBuffer longestCommonPrefixBuffer(int i) {
		return suffixArray.suffixBuffer(i).subSequence(0, lcp[i]);
	}
	
	public String longestCommonPrefix(int i) {
		return longestCommonPrefixBuffer(i).toString();
	}
	
	public int longestCommonPrefixLength(int i) {
		return lcp[i];
	}
}
