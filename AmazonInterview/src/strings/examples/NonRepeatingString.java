package strings.examples;

import java.util.ArrayList;

public class NonRepeatingString{
	
	static String s = "ABCDEEEEFGHFFFFFIJKL";
	static ArrayList<Character> uniqueset = new ArrayList<Character>();
	static int count=0;
	
	public static void main(String[] args) {
		firstrepeatingchar(s);
	}
	
	
	public static void firstrepeatingchar(String s) {
		char[] ch = s.toCharArray();
		for(int i=0;i<ch.length-1;i++) {
			if(!check(uniqueset,ch[i])) {
				for(int j=i+1;j<ch.length;j++) {
					if(Character.toLowerCase(ch[i])==Character.toLowerCase(ch[j])) {
						break;
					}else {
						for(int z=j+1;z<ch.length;z++) {
							if(Character.toLowerCase(ch[i])==Character.toLowerCase(ch[z])) {
								break;
							}else {
								System.out.println("First nonrepeating character is - "+s.charAt(i));
								System.out.print("Firts non repeating character is - "+s.indexOf(i));
							}
					}
					}
				}
		}
		}
		
	}
	
	public static boolean check(ArrayList<Character> uniqueset, char key) {
		for(char element:uniqueset) {
			if(element==key)
				return true;
		}
		return false;
	}
}