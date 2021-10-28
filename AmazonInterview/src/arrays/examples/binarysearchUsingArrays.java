package arrays.examples;

import java.util.Arrays;

public class binarysearchUsingArrays {

	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4,5,6,7,8,9,0};
		int[] lotto = new int[6];
		int value = binarysearch(numbers,5);
		System.out.println(value);
		lotto = sortarray(lotto);
		System.out.println(Arrays.toString(lotto));

	}
	
	private static int binarysearch(int[] numbers, int i) {
		int value = Arrays.binarySearch(numbers, i);
		return value;
	}
	
	public static int[] sortarray(int[] anotherlotto) {
		for(int i=0;i<6;i++) {
			anotherlotto[i] = (int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(anotherlotto));
		Arrays.sort(anotherlotto);
		return anotherlotto;	
	}
	
	

}
