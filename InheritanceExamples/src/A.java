public class A {
	int i,j;
	
	void showij() {
		System.out.println("Contetnts of i & j :"+i+" "+j);
	}
}
class B extends A {
	int k;
	void showk() {
		System.out.println("Conetents of k :"+k);
	}
	void sum() {
	int s = (i+j+k);
	System.out.println("Sum of i, J and K is :" +s);
	}
}
