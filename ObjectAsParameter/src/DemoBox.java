
public class DemoBox {

	public static void main(String[] args) {
		
		Box mybox = new Box(100,20,40);
		Box mybox1 = new Box(7);
		Box mybox2 = new Box();
		
		Box myclone = new Box(mybox);
		
		double vol;
		
		//get volume for first box
		vol = mybox.volume();
		System.out.println("Volume of mybox is :" +vol);
		
		//get volume for first box
		vol = mybox1.volume();
		System.out.println("Volume of mybox is :" +vol);
				
		//get volume for first box
		vol = mybox2.volume();
		System.out.println("Volume of mybox is :" +vol);
		
		//get volume of clone
		vol = myclone.volume();
		System.out.println("Volume of clone is :" +vol);
		

	}

}
