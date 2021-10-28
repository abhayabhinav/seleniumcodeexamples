
public class StackDemo {

	public static void main(String[] args) {
		TestStack mystack1 = new TestStack();
		TestStack mystack2 = new TestStack();
		
		for(int i=0; i<5; i++) {
			mystack1.push(i);
		}
		for(int i=0; i<8; i++) {
			mystack2.push(i);
		}
		
		System.out.println("Items in mystack1 is :");
		for(int i=0;i<5;i++) {
			System.out.println(mystack1.pop());
		}
		System.out.println("Items in mystack2 is :");
		for(int i=0;i<8;i++) {
			System.out.println(mystack2.pop());
		}
	}

}
