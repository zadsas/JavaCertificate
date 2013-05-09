package com.strings;

public class Comparison {

	public static void main(String[] args) {
		//Compare interned strings
		String firstLiteral = "Albacore Tuna";
		String secondLiteral = "Albacore Tuna";
		
		if (firstLiteral == secondLiteral) {
			System.out .println("firstLiteral and secondLiteral are the same object");
		} else {
			System.out.println("firstLiteral and secondLiteral are not the same object");
		}

		//Compare one interned string with a string from the heap
		String firstObject = new String("Albacore Tuna");
		if (firstLiteral == firstObject) {
			System.out.println("firstLiteral and firstObject are the same object");
		} else {
			System.out.println("firstLiteral and firstObject are not the same object");
		}

		//Do the comparison with the equals() method
		if (firstLiteral.equals(firstObject)) {
			System.out.println("firstLiteral and firstObject are the same object with equals method");
		} else {
			System.out.println("firstLiteral and firstObject are not the same object with equals method");
		}
		
		//Intern the string from the heap and make the comparison again
		firstObject = firstObject.intern();
		if (firstLiteral == firstObject) {
			System.out.println("firstLiteral and firstObject are the same object after interning the object");
		} else {
			System.out.println("firstLiteral and firstObject are not the same object after interning the object");
		}
	}
}
