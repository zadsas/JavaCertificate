package com.strings;

public class Immutable {

	public static void main(String[] args) {
		//3 strings are produced
		String s = "Constant";
		s = s + " and unchangeable";
		System.out.println(s);
		
		//The same, but under the method concat
		s = "Constant";
		s = s.concat(" and unchangeable");
		System.out.println(s);
	}
}
