package com.a9ski.algo.string;

import java.nio.CharBuffer;
import java.util.stream.IntStream;

public class SuffixArray {
	private final CharBuffer s;
	private final Integer[] suffixArray;
	private final int len;
	
	public SuffixArray(String str) {
		this.s = CharBuffer.wrap(str);
		this.len = s.length();
		this.suffixArray = suffixArray(str);
	}
	
	public CharBuffer suffixBuffer(int i) {
		return s.subSequence(suffixArray[i], len);
	}
	
	public String suffix(int i) {
		return new String(s.subSequence(suffixArray[i], len).toString());
	}
	
	public int suffixLength(int i) {
		return len - suffixArray[i];
	}
	
	public Integer[] getSuffixArray() {
		return suffixArray;
	}
	
	public static Integer[] suffixArray(String str) {
		final CharBuffer s = CharBuffer.wrap(str);
		final int len = s.length();
	
		final Integer[] arr = IntStream.range(0,  len)
				.boxed()
				.sorted((a, b) -> s.subSequence(a, len).compareTo(s.subSequence(b, len)))
				.toArray(size -> new Integer[size]);
		
		return arr;
	}
	
}
