package com.exceptions;

import com.myexceptions.ChildCheckedException;
import com.myexceptions.ParentCheckedException;

public class CatchExceptions {
	
	public static void main(String[] args) {
		
		Parent parentRef = new Parent();
		try {
			parentRef.method();
		} catch (ChildCheckedException e) {
		
		} catch (ParentCheckedException e) { // Catch the exception of the class
			e.printStackTrace();
		}
		
		Child childRef = new Child();
		try {
			childRef.method();
		} catch (ChildCheckedException e) { // Catch the exception of the class
			e.printStackTrace();
		}
		
		Parent ref = new Child();
		try {
			ref.method();
		} catch (ParentCheckedException e) { // Catch the parent exception
			e.printStackTrace();
		}

		Parent otherRef = new OtherChild();
		try {
			otherRef.method();
		} catch (ParentCheckedException e) { // Catch the parent exception, even if the child does not have it
			e.printStackTrace();
		}
	}

}
