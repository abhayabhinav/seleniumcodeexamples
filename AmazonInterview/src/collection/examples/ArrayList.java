package collection.examples;

import java.util.Iterator;
import java.util.LinkedList;

public class ArrayList {

	public static void main(String[] args) {
		int[] e = new int[] {1,2,3,4,5,6,7,8,9,0};
		java.util.ArrayList<String> abhi = new java.util.ArrayList<String>();
		abhi.add("I love to play Tennis");
		abhi.add("I love to play squash too");
		
		for(int i=0;i<abhi.size();i++) {
			System.out.println(abhi.get(i));
		}
		
		for(String s:abhi) {
			System.out.println(s);
		}
		
		Iterator<String> ie = abhi.iterator();
		while(ie.hasNext()) {
			System.out.println(ie.next());
		}
		
		LinkedList list = new LinkedList();
		for (int i = 0; i < 100; i++) {
			list.add((int)(Math.random()*10000)+1);
		}
		
		Iterator<?> ielist = list.iterator();
		
		while(ielist.hasNext()) {
			System.out.println(ielist.next());
		}
	}

}
