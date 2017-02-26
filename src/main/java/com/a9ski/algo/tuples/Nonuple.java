package com.a9ski.algo.tuples;

public class Nonuple<A, B, C, D, E, F, G, H, I> extends Octuple<A, B, C, D, E, F, G, H> {

	private I i;
	
	public Nonuple(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
		super(a, b, c, d, e, f, g, h);
		this.i = i;
	}
	
	public I get9() {
		return i;
	}
	
	public void set9(I i) {
		this.i = i;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((i == null) ? 0 : i.hashCode());
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
		if (!(obj instanceof Nonuple)) {
			return false;
		}
		final Nonuple<?,?,?,?,?,?,?,?,?> other = (Nonuple<?,?,?,?,?,?,?,?,?>) obj;
		if (i == null) {
			if (other.i != null) {
				return false;
			}
		} else if (!i.equals(other.i)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Nonuple [a=%s, b=%s, c=%s, d=%s, e=%s, f=%s, g=%s, h=%s, i=%s]", get1(), get2(), get3(), get4(), get5(), get6(), get7(), get8(), get9());
	}
	
	public static <A,B,C,D,E,F,G,H,I> Nonuple<A, B, C, D, E, F, G, H, I> of(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
		return new Nonuple<>(a, b, c, d, e, f, g, h, i);
	}

}
