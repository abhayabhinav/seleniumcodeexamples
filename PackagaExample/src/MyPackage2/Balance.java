package MyPackage2;

public class Balance {
	String name;
	double bal;
	
	public Balance(String n, double b){
		name = n;
		bal = b;
	}
	
	public void show() {
		if(bal<0)
			System.out.print("Low Account Balance ---->");
		System.out.println(name +" :$" +bal);
	}
}
