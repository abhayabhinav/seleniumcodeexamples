
/*public class TestStack {
	private int stck[];
	private int toss;
	
	TestStack(int size){
		stck = new int[size];
		toss =-1;
	}
	
	//push an item
	void push(int item) {
		if(toss==stck.length-1)
			System.out.println("Stack is full");
		else
			stck[++toss]=item;
	}
	
	//pop an item
	int pop() {
		if(toss<0) {
			System.out.println("Stack is underflow");
			return 0;
		}
		else
		return stck[toss--];
	}
}
*/

public class TestStack {

       public static void main(String[] args) {
              String X[][] = new String[3][3];
              
              X[0][0] = "A01";
              X[0][1] = "A02";
              X[0][3] = "A03";
              
              X[1][1] = "A11";
              X[1][2] = "A12";
              X[1][3] = "A13";
              
              X[2][1] = "A21";
              X[2][2] = "A22";
              X[2][3] = "A23";
              
              System.out.println("RowNum is "+X.length);
              System.out.println("ColNum is "+X[0].length);
              
              int Rows = X.length;
              int Cols = X[0].length;
              
              for(int RowNum =0;RowNum<Rows;RowNum++) {
                     for(int ColNum=0;ColNum<Cols;ColNum++)
                           System.out.println(X[RowNum][ColNum]);
              }

       }

	public void push(int i) {
		// TODO Auto-generated method stub
		
	}

}
