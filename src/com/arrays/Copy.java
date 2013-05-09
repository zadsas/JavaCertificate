package com.arrays;

import java.util.Arrays;
import java.util.List;

public class Copy {

	public static void main(String[] args) {
		String[] original = new String[3];
		original[0] = new String("string0");
		original[1] = new String("string1");
		original[2] = null;
		
		//System.arraycopy
		String[] arrarcopy = new String[3];
		System.arraycopy(original, 0, arrarcopy, 0, 3);
		System.out.println("System.arraycopy");
		System.out.println(original==arrarcopy); //false: the local array references point to different spaces in the heap   
		System.out.println(original[0]==arrarcopy[0]); //true: the elements of the array point to the same string object in the heap
		System.out.println(original.length==3 && original.length==arrarcopy.length);
		
		//Arrays.copyOf
		String[] copyOf = Arrays.copyOf(original, 3);
		System.out.println("Arrays.copyOf"); 
		System.out.println(original==copyOf); //false: the local array references point to different spaces in the heap
		System.out.println(original[0]==copyOf[0]); //true: the elements of the array point to the same string object in the heap 
		System.out.println(original.length==3 && original.length==copyOf.length);

		//Object.clone()
		String[] clone = original.clone();
		System.out.println("Object.clone()"); 
		System.out.println(original==clone); //false: the local array references point to different spaces in the heap
		System.out.println(original[0]==clone[0]); //true: the elements of the array point to the same string object in the heap 
		System.out.println(original.length==3 && original.length==clone.length);
		
		//Arrays.asList()
		//The list reference and the array reference point to the same space in the space
		List<String> list = Arrays.asList(original);
		System.out.println("Arrays.asList()");
		
		System.out.println(original[0].equals("string0") && original[0]==list.get(0)); //true
		original[0] = new String("string2"); 										   //change array
		System.out.println(original[0].equals("string2") && original[0]==list.get(0)); //true.
		
		System.out.println(original[1].equals("string1") && original[1]==list.get(1)); //true		
		list.set(1, new String("string3"));											   //change list
		System.out.println(original[1].equals("string3") && original[1]==list.get(1)); //true
	}
}
