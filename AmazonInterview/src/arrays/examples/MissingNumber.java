package arrays.examples;

public class MissingNumber {

	public static void main(String[] args) {
		
		int[] missing = new int[] {5,4,3,2,1,9,7,6,10};
		int totalarraynum = 10;
		int currentarraynumbers=0;
		int Sumtotalarraynum = totalarraynum*(totalarraynum+1)/2;
		System.out.println("Sum of array size - "+Sumtotalarraynum);
		int missingnum;
		
		for(int i=0;i<missing.length;i++) {
			currentarraynumbers = currentarraynumbers+missing[i];
		}
		System.out.println("Sum of current array numbers - "+currentarraynumbers);
		missingnum = Sumtotalarraynum-currentarraynumbers;
		System.out.println("Missing number is - "+missingnum);
		
	}

}
