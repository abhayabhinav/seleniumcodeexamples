package strings.examples;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.html.HTMLDocument.Iterator;

public class DuplicateStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char chatAt(int) - Gives you character at that index
		//int indexOf(char) - Index of the first occurrence of teh char in the string
		//char[] toCharArray() - Converts the string to an array of individual characters
		
		String duplicate = "ABAACBCBCDFEC";
		int countofduplcuate  = findduplicate(duplicate);
		System.out.println("Count of duplucate characters in String are - "+countofduplcuate);
	}
	
	public static int findduplicate(String inputString) {
		ArrayList<Character> uniqueset = new ArrayList<Character>();
		int count=0;
		char[] stringchar = inputString.toCharArray();
		System.out.println(Arrays.toString(stringchar));
		
		for(int i=0;i<stringchar.length-1;i++) {
			if(!check(uniqueset,stringchar[i])) {
				for(int j=i+1;j<stringchar.length;j++) {
					if(stringchar[i]==stringchar[j]) {
						System.out.println("Duplicat found - "+stringchar[i]);
						uniqueset.add(stringchar[i]);
						count++;
						break;
					}
				}
			}
		}
		
		return count;
	}
	
	public static boolean check(ArrayList<Character> unique, char key) {
		java.util.Iterator<Character> ie = unique.iterator();
		while(ie.hasNext()){
			if(ie.next()==key)
				return true;
		}
		return false;
	}

}
