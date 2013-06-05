package com.primitives;

public class Unicode {

	public static void main(String[] args) {
		
		//the format of the file itself must be UTF
		
		System.out.println(Character.toString((char)0x2202));

		System.out.println(Character.toString((char)0x0041));
		
		System.out.println(Character.codePointAt("A",0)); //0x0041 = 65

		System.out.println(Character.isLetter(0x0041));
		
	}
}
