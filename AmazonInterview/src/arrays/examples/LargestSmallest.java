package arrays.examples;
import java.util.Arrays;

public class LargestSmallest {

	public static void main(String[] args) {
		int [] largest = new int [] {5,3,1,4,2,8,6,12,9,11,10,15,14};
		
		for(int i=0;i<largest.length-1;i++) {
			for(int j=i+1;j<largest.length;j++) {
				if(largest[i]>largest[j]) {
					int store = largest[i];
					largest[i]=largest[j];
					largest[j]=store;
				}
			}
		}
		System.out.println(Arrays.toString(largest));
		System.out.println("Smallest element is - "+largest[0]);
		System.out.println("Largest element is - "+largest[largest.length-1]);
		
		int largestnum = findlargest(largest);
		System.out.println("Largest number is - "+largestnum);
	}
	
	public static int findlargest(int [] largest) {
		int largestnum = largest[0];
		for(int i=1;i<largest.length;i++) {
			if(largest[i]>largestnum) {
				largestnum = largest[i];
			}
		}
		return largestnum;
	}

}
