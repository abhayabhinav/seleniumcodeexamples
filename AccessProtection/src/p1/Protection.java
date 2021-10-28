package p1;

public class Protection {
	int n = 10;
	private int n_pri = 20;
	protected int n_pro = 30;
	public int n_pub = 40;
	
	public Protection(){
	System.out.println("Base Constructor");
	System.out.println("n = :" + n);
	System.out.println("n_pri :"+ n_pri);
	System.out.println("n_pro :"+ n_pro);
	System.out.println("n_pub :" + n_pub);
	}
}
