package arrays.examples;

import java.util.ArrayList;

public class MultipleDuplicates {
	static int count=0;
	static int [] duplicateset = new int[] {1,2,3,1,2,4,2,1,3,4,0,6,7,8,7,6,4,5,2,3,2,3,2,3,4,5,6,7,8,9};
	static ArrayList<Integer> anotherduplicate = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		for(int i=0;i<duplicateset.length-1;i++) {
			if(!check(anotherduplicate,duplicateset[i])) {
				for(int j=i+1;j<duplicateset.length;j++) {
					if(duplicateset[i]==duplicateset[j]) {
						anotherduplicate.add(duplicateset[i]);
						count++;
						break;
					}
				}
			}
		}
		System.out.println("Total nos of duplicates are - "+count);
		System.out.println(anotherduplicate.toString());
	}
	
	public static boolean check(ArrayList<Integer> anotherduplicate, int key) { 
        for (int element : anotherduplicate) { 
            if (element == key) { 
               return true; 
            } 
        } 
        return false;
	}

}
