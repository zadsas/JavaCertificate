package com.varargs;

public class VarArgs {
	
	public static void main(String[] args) {
	    String[] bar = arrayOfTwo("hi", "mom");
	}

	static <T> T[] arrayOfTwo(T a, T b) {
	    return asArray(a, b); //returns an array of Object due to varargs
	}
	
	//@SafeVarargs
	static <T> T[] asArray(T... args) {
	    return args;
	}
	
	
}
