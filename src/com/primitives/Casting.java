package com.primitives;

public class Casting {

	public static void main(String[] args) {
		//Wide conversion is OK
		int i = 'i';
		double d = 3;
		System.out.println(d);
		
		//Narrow conversion needs explicit casting. It will truncate where necessary
		float f = 3.14f;
		int fi = (int) f;
		System.out.println(fi);
		
		//Casting in a narrow conversion is needed even if the value fits in the target type
		int number = 100;
		byte b = (byte) number;
		
		//The only exception is if you assign an int literal (default) to a short or byte variable
		byte bb = 100;
		short ss = 100;
		
		//This exception does not apply to double literal (default), which need to be casted to float
		float dd = (float) 3.14;
	}
}
