
public class SuperSubException {

	public static void main(String[] args) {
		try {
			int a= 0;
			int b = 42/a;
			System.out.println("Divide by Zero");
		}
		
		catch(Exception e) {
			System.out.println("This will be displayed");
		}
		
		/*catch(ArithmeticException e) {
			System.out.println("This will never be printed and program will throw an error on compilation");
		}*/

	}

}
