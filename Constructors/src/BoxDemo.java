
public class BoxDemo {

	public static void main(String[] args) {
		Box mybox = new Box(10,20,30);
		Box mybox1 = new Box(40,50,60);
		
		double vol;
		
		vol = mybox.volume();
		System.out.println("Volume of first box is: " + vol);
		
		vol = mybox1.volume();
		System.out.println("Volume of first box is: " + vol);

	}

}
