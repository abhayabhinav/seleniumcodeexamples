
public class Exec0 {
	
	public static void subroutine() {
		int d = 0;
		try {
		int c= 42/d;
		System.out.println("The result is :" +c);
		}
		catch(ArithmeticException e){
			System.out.println("Dived by zero is not allowed");
		}System.out.println("After catch statement");
	}
	public static void main(String[] args) {	
		Exec0.subroutine();
	}
}
