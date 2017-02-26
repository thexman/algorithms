package com.a9ski.algo.tuples;

public class Triple<A, B, C> extends Pair<A, B> {

	private C c;
	
	public Triple(final A a, final B b, final C c) {
		super(a, b);
		this.c = c;
	}
	
	public C get3() {
		return c;
	}
	
	public void set3(C c) {
		this.c = c;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Triple)) {
			return false;
		}
		final Triple<?, ?, ?> other = (Triple<?, ?, ?>) obj;
		if (c == null) {
			if (other.c != null) {
				return false;
			}
		} else if (!c.equals(other.c)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("Triple [a=%s, b=%s, c=%s]", get1(), get2(), get3());
	}
	
	public static <A,B,C> Triple<A, B, C> of(A a, B b, C c) {
		return new Triple<>(a, b, c);
	}
}
