package arrays.examples;

public class arrayssum {

	public static void main(String[] args) {
		
		int[] check = new int[] {1,2,3,4,5,6};
		
		for(int i=0;i<check.length-3;i++) {
			for(int j=i+1;j<check.length-2;j++) {
				for(int k=j+1;k<check.length-1;k++) {
					for(int l=k+1;l<check.length;l++) {
						int a = check[i];
						System.out.println(a);
						int b = check[j];
						System.out.println(b);
						int c = check[k];
						System.out.println(c);
						int z = (a+b+c);
						System.out.println("Sum is - "+z);
						if(z==check[k+1]) {
							System.out.println("Sum found - Sum of "+check[i]+check[j]+check[k]+ " is equal to "+check[k+1]);
					}
					}
				}
			}
		}
	}

}
