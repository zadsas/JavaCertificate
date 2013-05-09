package com.types;

public class StaticDynamicType {

	public static void main(String[] args) {
		Figure fig = new StaticDynamicType().new Figure();
		System.out.println(fig.getClass().getName()); //Dynamic type (object)
		System.out.println(fig instanceof Figure);
		System.out.println(fig instanceof Square);
		//COMPILE ERROR: fig.getSquare() -> Neither the static nor the dynamic type now anything about Squares
		
		Figure square = new StaticDynamicType().new Square();
		System.out.println(square.getClass().getName()); //Dynamic type (object)
		System.out.println(square instanceof Figure);
		System.out.println(square instanceof Square);
		//COMPILE ERROR: square.getSquare() -> The static type determines what participates in polymorphism.
		//This would only work if 'getSquare()' were defined in Figure. 
		//From this point, the invocation square.getSquare() would use either the inherited version or the polymorphic one (overriden).
		
		Square square2 = new StaticDynamicType().new Square();
		System.out.println(square2.getClass().getName()); //Dynamic type (object)
		System.out.println(square2 instanceof Figure);
		System.out.println(square2 instanceof Square);
		square2.getSquare();
	}

	private class Figure {
	}
	
	private class Square extends Figure {
		public void getSquare(){
			System.out.println("SQUARE");
		}
	}
}
