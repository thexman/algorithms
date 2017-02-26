package com.a9ski.algo.tuples;

public class Hextuple<A, B, C, D, E, F> extends Pentuple<A, B, C, D, E> {

	private F f;
	
	public Hextuple(A a, B b, C c, D d, E e, F f) {
		super(a, b, c, d, e);
		this.f = f;
	}
	
	public void set6(F f) {
		this.f = f;
	}
	
	public F get6() {
		return f;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((f == null) ? 0 : f.hashCode());
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
		if (!(obj instanceof Hextuple)) {
			return false;
		}
		final Hextuple<?,?,?,?,?,?> other = (Hextuple<?,?,?,?,?,?>) obj;
		if (f == null) {
			if (other.f != null) {
				return false;
			}
		} else if (!f.equals(other.f)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Hextuple [a=%s, b=%s, c=%s, d=%s, e=%s, f=%s]", get1(), get2(), get3(), get4(), get5(), get6());
	}
	
	public static <A,B,C,D,E,F> Hextuple<A, B, C, D, E, F> of(A a, B b, C c, D d, E e, F f) {
		return new Hextuple<>(a, b, c, d, e, f);
	}

}
