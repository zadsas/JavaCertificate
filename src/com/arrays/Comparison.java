package com.arrays;

import java.util.Arrays;

public class Comparison {

	public static void main(String[] args) {
		boolean[] arrayA = new boolean[5];
		boolean[] arrayB = new boolean[5];
		
		System.out.println(arrayA==arrayB); // compare references
		System.out.println(arrayA.equals(arrayB)); // compare objects as references, since it uses Object's equals method, which has the same implementation as the line above
		
		System.out.println(Arrays.equals(arrayA, arrayB)); //compare contents
	}
}
