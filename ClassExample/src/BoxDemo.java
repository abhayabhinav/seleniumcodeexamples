
public class BoxDemo {
	public static void main(String args[]) {
		Box mybox = new Box();
		Box mybox1 = new Box();
		
		mybox.breadth=10;
		mybox.height=10;
		mybox.width=10;
		
		mybox1.breadth=20;
		mybox1.height=20;
		mybox1.width=20;
		mybox.volume();
		mybox1.volume();		
	}
}
