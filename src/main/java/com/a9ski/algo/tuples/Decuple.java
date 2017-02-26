package com.a9ski.algo.tuples;

public class Decuple<A, B, C, D, E, F, G, H, I, J> extends Nonuple<A, B, C, D, E, F, G, H, I> {

	private J j;
	
	public Decuple(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
		super(a, b, c, d, e, f, g, h, i);
		this.j = j;
	}
	
	public J get10() {
		return j;
	}
	
	public void set10(J j) {
		this.j = j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((j == null) ? 0 : j.hashCode());
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
		if (!(obj instanceof Decuple)) {
			return false;
		}
		final Decuple<?,?,?,?,?,?,?,?,?,?> other = (Decuple<?,?,?,?,?,?,?,?,?,?>) obj;
		if (j == null) {
			if (other.j != null) {
				return false;
			}
		} else if (!j.equals(other.j)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Decuple [a=%s, b=%s, c=%s, d=%s, e=%s, f=%s, g=%s, h=%s, i=%s, j=%s]", get1(), get2(), get3(), get4(), get5(), get6(), get7(), get8(), get9(), get10());
	}
	
	public static <A,B,C,D,E,F,G,H,I,J> Decuple<A, B, C, D, E, F, G, H, I, J> of(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
		return new Decuple<>(a, b, c, d, e, f, g, h, i, j);
	}

}
