package com.primitives;

public class Precision {

	public static void main(String[] args) {
		float f = 0.1f;
		for (int i = 0; i < 9; i++) {
			f += 0.1f;
		}
		System.out.println(f);
	}

}
