package com.a9ski.algo.tuples;

public class Pentuple<A, B, C, D, E> extends Quadruple<A, B, C, D> {

	private E e;
	
	public Pentuple(A a, B b, C c, D d, E e) {
		super(a, b, c, d);
		this.e = e;
	}
	
	public E get5() {
		return e;
	}
	
	public void set5(E e) {
		this.e = e;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((e == null) ? 0 : e.hashCode());
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
		if (!(obj instanceof Pentuple)) {
			return false;
		}
		final Pentuple<?,?,?,?,?> other = (Pentuple<?,?,?,?,?>) obj;
		if (e == null) {
			if (other.e != null) {
				return false;
			}
		} else if (!e.equals(other.e)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Pentuple [a=%s, b=%s, c=%s, d=%s, e=%s]", get1(), get2(), get3(), get4(), get5());
	}
	
	public static <A,B,C,D,E> Pentuple<A, B, C, D, E> of(A a, B b, C c, D d, E e) {
		return new Pentuple<>(a, b, c, d, e);
	}
	
	

}
