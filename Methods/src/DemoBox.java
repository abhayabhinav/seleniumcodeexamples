
public class DemoBox {

	public static void main(String[] args) {
		Box mybox = new Box();
		Box mybox1 = new Box();
		
		mybox.SetDim(1, 2, 3);
		System.out.println("volume of mybox is :" +mybox.volume());
		
		mybox1.SetDim(4, 5, 6);
		System.out.println("volume of mybox is :" +mybox1.volume());
		

	}

}
