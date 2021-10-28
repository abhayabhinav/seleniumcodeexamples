
public class SwapNumberNoThirdvar {

	public static void main(String[] args) {
		int x= 3;
		int y =7;
		System.out.println("Before swap:");
		System.out.println("x value: "+x);
		System.out.println("y value: "+y);
		x = x+y;
		y=x-y;
		x=x-y;
		System.out.println("After swap:");
		System.out.println("x value: "+x);
		System.out.println("y value: "+y);
		
	}

}
