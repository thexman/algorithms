package com.a9ski.algo.tuples;

public class Heptuple<A, B, C, D, E, F, G> extends Hextuple<A, B, C, D, E, F> {

	private G g;
	
	public Heptuple(A a, B b, C c, D d, E e, F f, G g) {
		super(a, b, c, d, e, f);
		this.g = g;
	}
	
	public G get7() {
		return g;
	}
	
	public void set7(G g) {
		this.g = g;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((g == null) ? 0 : g.hashCode());
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
		if (!(obj instanceof Heptuple)) {
			return false;
		}
		final Heptuple<?,?,?,?,?,?,?> other = (Heptuple<?,?,?,?,?,?,?>) obj;
		if (g == null) {
			if (other.g != null) {
				return false;
			}
		} else if (!g.equals(other.g)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Heptuple [a=%s, b=%s, c=%s, d=%s, e=%s, f=%s, g=%s]", get1(), get2(), get3(), get4(), get5(), get6(), get7());
	}
	
	public static <A,B,C,D,E,F,G> Heptuple<A, B, C, D, E, F, G> of(A a, B b, C c, D d, E e, F f, G g) {
		return new Heptuple<>(a, b, c, d, e, f, g);
	}
	

}
