package com.strings;

public class Unicode {

	public static void main(String[] args) {
		String irene = "Ire\u0300ne";
		
		System.out.println(irene); //prints 5 characters (the encoding of the file must be UTF-16) 
		System.out.println(irene.length()); //outputs 6 due to the unicode character
	}
}
