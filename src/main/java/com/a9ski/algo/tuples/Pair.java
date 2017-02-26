package com.a9ski.algo.tuples;

public class Pair<A, B> {
	private A a;
	private B b;
	
	public Pair(A a, B b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public A get1() {
		return a;
	}
	
	public B get2() {
		return b;
	}
	
	public static <A,B> Pair<A,B> of(A a, B b) {
		return new Pair<>(a, b);
	}
	
	public void set1(A x) {
		this.a = x;
	}
	
	public void set2(B y) {
		this.b = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
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
		if (!(obj instanceof Pair)) {
			return false;
		}
		final Pair<?,?> other = (Pair<?,?>) obj;
		if (a == null) {
			if (other.a != null) {
				return false;
			}
		} else if (!a.equals(other.a)) {
			return false;
		}
		if (b == null) {
			if (other.b != null) {
				return false;
			}
		} else if (!b.equals(other.b)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("Pair [a=%s, b=%s]", get1(), get2());
	}
}
