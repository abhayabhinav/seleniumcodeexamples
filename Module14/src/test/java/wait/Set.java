package wait;

import java.util.HashSet;
import java.util.Iterator;

import org.testng.annotations.Test;

public class Set {

	@Test
	public static void main(String[] args) {
		
		HashSet<String> s = new HashSet<String>();
		System.out.println(s.size());
		s.add("Indina");
		s.add("China");
		s.add("USA");
		s.add("Russia");
		s.add("Germany");
		s.add("Germany");
		
		System.out.println(s.size());
		
		Iterator<String> its = s.iterator();
		
		while(its.hasNext()) {
			System.out.println(its.next());
		}
	}

}
