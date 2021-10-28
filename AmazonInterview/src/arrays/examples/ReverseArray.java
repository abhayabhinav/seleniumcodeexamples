package arrays.examples;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int[] reversetheset = new int[] {1,3,4,2,5};
		for(int i=0;i<reversetheset.length/2;i++) {
			int temp = reversetheset[i];
			reversetheset[i] = reversetheset[reversetheset.length-i-1];
			reversetheset[reversetheset.length-i-1]=temp;
		}
		System.out.println("Reverse array is - "+Arrays.toString(reversetheset));
	}

}
