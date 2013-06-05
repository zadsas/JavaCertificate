package com.primitives;


public class Binary {

	public static void main(String[] args) {
		int b = 0b1001;
		System.out.println(b);
		
		byte value = (byte) 0b0111_1010;
		byte result = (byte) (value & 0b0000_1111);
		System.out.println("result: " + Integer.toBinaryString(result));
	}

}