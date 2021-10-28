package strings.examples;

public class Anagram {

	public static void main(String[] args) {
		String s1 = "NOw";
		String s2 = "won";
		
		boolean isAnagram = isItAnagram(s1,s2);
		if(isAnagram)
			System.out.println("The two string compared are Anagram");
		else
			System.out.println("The two string compared are NOT Anagram");
	}
	
	
	public static boolean isItAnagram(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		
		for(int i=0, j=s2.length()-1;i<s1.length();i++,j--) {
			if(Character.toLowerCase(s1.charAt(i))!=Character.toLowerCase(s2.charAt(j))) {
				return false;
			}
		}
		
		return true;
	}
}