package com.a9ski.algo.tuples;

public class Quadruple<A, B, C, D> extends Triple<A, B, C> {

	private D d;
	
	public Quadruple(final A a, final B b, final C c, final D d) {
		super(a, b, c);
		this.d = d;
	}
	
	public D get4() {
		return d;
	}
	
	public void set4(D d) {
		this.d = d;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((d == null) ? 0 : d.hashCode());
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
		if (!(obj instanceof Quadruple)) {
			return false;
		}
		final Quadruple<?, ?, ?, ?> other = (Quadruple<?, ?, ?, ?>) obj;
		if (d == null) {
			if (other.d != null) {
				return false;
			}
		} else if (!d.equals(other.d)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("Quadruple [a=%s, b=%s, c=%s, d=%s]", get1(), get2(), get3(), get4());
	}
	
	public static <A,B,C,D> Quadruple<A, B, C, D> of(A a, B b, C c, D d) {
		return new Quadruple<>(a, b, c, d);
	}
}
