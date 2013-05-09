package com.primitives;

public class Unicode {

	public static void main(String[] args) {
		System.out.println(Character.codePointAt("A",0));

		System.out.println(Character.isLetter(0x0041)); //This is the hexadecimal for the codepoint 65
	}
}
