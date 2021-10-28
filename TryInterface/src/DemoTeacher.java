
public class DemoTeacher {

	public static void main(String[] args) {
		SubTeacher t = new SubTeacher();
		
		if(t.isNotNegative(10))
			System.out.println("10 is not negative");
		if(t.isNotNegative(-2))
			System.out.println("This will not get printed");
	}

}
