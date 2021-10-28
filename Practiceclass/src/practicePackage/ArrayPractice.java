package practicePackage;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayPractice {
	
	 public static void main(String[] args) {
		int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
		int[] sumarray = new int[] {50,40,30,20,10};
		int[] comsumarray = new int[] {50,40,30,20,10};
		int[] minmax = new int[] {4,7,2,9,1};
		String[] str = new String[] {"Abhinav","Abhay","Abhinav","Neha"};
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
			
		}
		
		HashSet<String> set = new HashSet<String>();
		for(String val:str) {
			if(set.add(val)==false) {
				System.out.println("This is duplicate value "+val);
			}
		}
		
		int totalvalue = sum(sumarray);
		System.out.println("Sum of all number sin an array = "+totalvalue);
		
		boolean result = compare(sumarray,comsumarray);
		
		if(result) {
			System.out.println("Both arrays are equal");
		}else {
			System.out.println("Both arrays are not equal");
		}
		
		
		Arrays.sort(sumarray);
		for(int i=0;i<sumarray.length;i++) {
			System.out.print(sumarray[i]+" ");
		}
		
		System.out.println();
		
		
		int[]  arr1 = new int[50];
		int[]  arr2 = new int[100];
		arr1 = arr2;
		System.out.println(arr1.length);
		
		  int[]  binarysearcharray = {1, 2, 3, 4};

		    /* if element present in Array, binarySearch()
		    method will return index */
		    System.out.println("Result of search is "+Arrays.binarySearch(binarysearcharray, 2));
		
		minmax(minmax);    

	 }
	 
	public static boolean compare(int[] test1array, int[] test2array) {
		return Arrays.equals(test1array,test2array);
	}
		  
		
	public static int sum(int[] sumarray) {
		int summation = 0;
		for(int i=0;i<sumarray.length;i++) {
			  summation+=sumarray[i];
		  }
		  return summation;
	}
	
	public static void minmax(int[] arraytest3) {
		int max = arraytest3[0];
		for(int i=1;i<arraytest3.length;i++) {
			if(arraytest3[i]>max) {
				max = arraytest3[i];
			}
		} System.out.println("Max number in array is "+max);
		
		int min = arraytest3[0];
		for(int i=1;i<arraytest3.length;i++) {
			if(arraytest3[i]<min) {
				min = arraytest3[i];
			}
		} System.out.println("Min number in array is "+min);
	}
}
