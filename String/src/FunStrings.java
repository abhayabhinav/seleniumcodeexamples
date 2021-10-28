
public class FunStrings {

	public static void main(String[] args) {
		String strob1 = "First String";
		String strob2 = "Second String";
		String strob3 = strob2;
		
		if(strob1.equals(strob2)) {
			System.out.println("strob1==strob2");
		}
		else {
			System.out.println("strob1!=strob2");
		}
		
		if(strob2.equals(strob3)) {
			System.out.println("strob2==strob3");
		}
		else {
			System.out.println("strob2!=strob3");
		}
		
		
		System.out.println("Lenght of the strob1 :" + strob1.length());
		
		System.out.println("Length at index 3 in strob1 :" +strob1.charAt(3));
	}

}
