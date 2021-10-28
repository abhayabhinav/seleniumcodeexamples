
public class SimpleInheritance {

	public static void main(String[] args) {
		A superOb = new A();
		B subOb = new B();
		
		//The superclass may be used by itself.
		
		superOb.i = 10;
		superOb.j = 20;
		
		System.out.println("Contents of SuperOb: ");
		superOb.showij();
		System.out.println();
		
		//The subclass has access to all public members of it's superclass
		
		subOb.i = 11;
		subOb.j = 12;
		subOb.k = 13;
		
		System.out.println("Contents of SubOb: ");
		subOb.showij();
		subOb.showk();
		System.out.println();
		
		System.out.println("Sum of i, j and K in subOb: ");
		subOb.sum();
	}

}
