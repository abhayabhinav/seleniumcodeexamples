
public class IfExample {

	public static void main(String[] args) {
		int x, y;
		x=10;
		y=20;
		if(x<y) System.out.println("X is less than Y");
		x=x*2;
		if(x==y)System.out.println("X is equal to Y");
		x=x*2;
		if(x>y)System.out.println("X is greater than Y");
		if(x==y)System.out.println("Dont Print this");
	}

}
