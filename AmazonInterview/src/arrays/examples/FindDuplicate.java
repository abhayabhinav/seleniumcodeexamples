package arrays.examples;

import java.util.Arrays;

public class FindDuplicate {
	public static void main(String[] args) {
		
		 int [] duplicateset = new int[] {1,2,3,4,5,2,3,6,7,8,7,9,5,7};
		 System.out.println("length of duplicate array is - "+duplicateset.length);
		 int[] noduplicateset = new int[duplicateset.length];
		 int count=0;
		 int isthisisduplicate;
		 boolean duplicatefound;
		 
		 for(int i=0;i<duplicateset.length-1;i++) {
			 isthisisduplicate = duplicateset[i];
			 duplicatefound=false;
			 
			 for(int j=i+1;j<duplicateset.length;j++) {
				 if(duplicateset[i]==duplicateset[j]) {
					 System.out.println("This is duplicate - "+duplicateset[i]);
					 count++;
					 duplicatefound = true;
					 break;
				 }
			 }
			 if(!duplicatefound) {
				 noduplicateset[i] = isthisisduplicate;
			 }
		 }
		 System.out.println("Total number of duplicates found - "+count);
		 System.out.println(Arrays.toString(noduplicateset));
	}
}
