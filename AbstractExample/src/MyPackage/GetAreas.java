package MyPackage;

import MyPackage.Figure;

public class GetAreas {

	public static void main(String[] args) {
		Rectangle r = new Rectangle(10,5);
		Triangle t = new Triangle(10,5);
		
		Figure figref;
		
		figref = r;
		System.out.println(figref.area());
		
		figref = t;
		System.out.println(figref.area());

	}
}
