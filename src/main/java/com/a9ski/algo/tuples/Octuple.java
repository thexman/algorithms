package com.a9ski.algo.tuples;

public class Octuple<A, B, C, D, E, F, G, H> extends Heptuple<A, B, C, D, E, F, G> {

	private H h;
	
	public Octuple(A a, B b, C c, D d, E e, F f, G g, H h) {
		super(a, b, c, d, e, f, g);
		this.h = h;
	}
	
	public H get8() {
		return h;
	}
	
	public void set8(H h) {
		this.h = h;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((h == null) ? 0 : h.hashCode());
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
		if (!(obj instanceof Octuple)) {
			return false;
		}
		final Octuple<?,?,?,?,?,?,?,?> other = (Octuple<?,?,?,?,?,?,?,?>) obj;
		if (h == null) {
			if (other.h != null) {
				return false;
			}
		} else if (!h.equals(other.h)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Octuple [a=%s, b=%s, c=%s, d=%s, e=%s, f=%s, g=%s, h=%s]", get1(), get2(), get3(), get4(), get5(), get6(), get7(), get8());
	}
	
	public static <A,B,C,D,E,F,G,H> Octuple<A, B, C, D, E, F, G, H> of(A a, B b, C c, D d, E e, F f, G g, H h) {
		return new Octuple<>(a, b, c, d, e, f, g, h);
	}
	

}
