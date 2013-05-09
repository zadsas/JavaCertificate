package com.arrays;

public class Initialization {

	public static void main(String[] args) {
		boolean[] array = new boolean[5];
		for (boolean elem : array) {
			System.out.println(elem);
		}
		
		Person p = new Initialization().new Person(); // Allocated in the heap -> Default initialization of variable 'age' 
		System.out.println(p.age);
	}
	
	private class Person {
		public int age;
	}
}
