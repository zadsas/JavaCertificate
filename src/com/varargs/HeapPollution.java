package com.varargs;

import java.util.Arrays;
import java.util.List;

public class HeapPollution {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("1", "2");
		List<String> list2 = Arrays.asList("3", "4");
		merge(list1, list2);
	}
	
	//@SafeVarargs
	static void merge(List<String>... stringLists) {
		Object[] array = stringLists;
		List<Integer> tmpList = Arrays.asList(42);
		array[0] = tmpList; // Semantically invalid, but compiles without warnings
		String element = stringLists[0].get(0); // runtime ClassCastException
	}

}
