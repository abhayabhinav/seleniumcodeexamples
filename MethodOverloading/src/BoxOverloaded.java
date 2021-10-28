
public class BoxOverloaded {

	public static void main(String[] args) {
		Box mybox1 = new Box(10,20,30);
		Box mybox2 = new Box();
		Box mycube = new Box(7);
		
		double vol;
		
		//get volume of first box
		
		vol = mybox1.volume();
		System.out.println("volume of mybox1 is: " + vol);
		
		//get volume of second box box
		
		vol = mybox2.volume();
		System.out.println("volume of mybox1 is: " + vol);
		
		//get volume of cube
				
		vol = mycube.volume();
		System.out.println("volume of mybox1 is: " + vol);
	}

}
