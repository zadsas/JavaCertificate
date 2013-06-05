package com.primitives;

public class Switch {
	
	public static void main(String[] args) {
		System.out.println(monthNameToDays("January", 1986));
	}

	static int monthNameToDays(String s, int year) {
		//more efficient byte code than if-then-else version
		switch(s) {
			case "April": case "June": case "September": case "November":
				return 30;
			case "January": case "March": case "May": case "July": case "August": case "December":
				return 31;
			case "February":
			default:
				return 30;
		}
	}
}
