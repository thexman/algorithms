package com.a9ski.algo.tuples;

import java.util.Arrays;

public class Tuple<T> {
	private T[] values;
	
	@SafeVarargs
	public Tuple(T...values) {
		this.values = values;
	}
	
	public T[] getValues() {
		return values;
	}
	
	public void setValues(T[] values) {
		this.values = values;
	}
	
	public T get(int i) {
		return this.values[i-1];
	}
	
	public void set(int i, T x) {
		this.values[i-1] = x;
	}
	
	public T get1() {
		return get(1);
	}
	
	public void set1(T x) {
		set(1, x);
	}
	
	public T get2() {
		return get(2);
	}
	
	public void set2(T x) {
		set(2, x);
	}
	
	public T get3() {
		return get(3);
	}
	
	public void set3(T x) {
		set(3, x);
	}
	
	public T get4() {
		return get(4);
	}
	
	public void set4(T x) {
		set(4, x);
	}
	
	public T get5() {
		return get(5);
	}
	
	public void set5(T x) {
		set(5, x);
	}
	
	public T get6() {
		return get(6);
	}
	
	public void set6(T x) {
		set(6, x);
	}
	
	public T get7() {
		return get(7);
	}
	
	public void set7(T x) {
		set(7, x);
	}
	
	public T get8() {
		return get(8);
	}
	
	public void set8(T x) {
		set(8, x);
	}
	
	public T get9() {
		return get(9);
	}
	
	public void set9(T x) {
		set(9, x);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(values);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Tuple)) {
			return false;
		}
		final Tuple<?> other = (Tuple<?>) obj;
		if (!Arrays.equals(values, other.values)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("Tuple [values=%s]", Arrays.toString(values));
	}
	
	@SafeVarargs
	public static <T> Tuple<T> of(T...values) {
		return new Tuple<>(values);
	}
}
