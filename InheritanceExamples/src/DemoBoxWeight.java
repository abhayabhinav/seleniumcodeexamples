
public class DemoBoxWeight {

	public static void main(String[] args) {
		// Auto-generated method stub
		
		Box mybox = new Box();
		
		BoxWeight mybox1 = new BoxWeight(10,20,30,40);
		BoxWeight mybox2 = new BoxWeight(5,15,25,35);
		
		System.out.println("Volume of mybox is :" + mybox.volume());
		
		System.out.println("Volume of mybox1 is :" + mybox1.volume());
		System.out.println("Weight of mybox1 is :" + mybox1.weight);
		System.out.println();
		
		System.out.println("Volume of mybox2 is :" + mybox2.volume());
		System.out.println("Weight of mybox2 is :" + mybox2.weight);
	}

}
