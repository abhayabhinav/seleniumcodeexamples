package arrays.examples;

public class PairAddingToSum {

	public static void main(String[] args) {
		int [] pairset = new int[] {2,0,3,5,8,10,13};
		int NosOfPairs = printPairSum(pairset);
		System.out.println("No of pairs in the array adding up to sum of a number is array is - "+NosOfPairs);
	}
	
	public static int printPairSum(int[] pairset) {
		int counter=0;
		for(int i=0;i<pairset.length-1;i++) {
			for(int j=i+1;j<pairset.length;j++) {
				int Sum = pairset[i]+pairset[j];
				for(int z=0;z<pairset.length;z++) {
					if(Sum==pairset[z]) {
						counter++;
						System.out.println("Pair found - "+pairset[i]+" , "+pairset[j]);
					}
				}
			}
		}
		return counter;
	}

}
