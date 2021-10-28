package arrays.examples;

public class Arraydeclaration {

	public static void main(String[] args) {
		boolean[] locker = new boolean[1001];
		
		//true = open & false = close
		
		for(int i=1;i<1001;i++) {
			locker[i] = false;
		}
		
		for(int i=1;i<1001;i++) {
			locker[i] = true;
		}
		
		for(int i=2;i<1001;i++) {
			for(int j=i;j<1001;j+=i) {
				if(locker[j]==true) {
					locker[j]=false;
				}else {
					locker[j]=true;
				}
			}
		}
		int opencount =0;
		for(int i=1;i<1001;i++) {
			if(locker[i]) {
				opencount++;
			}
		}
		System.out.println("Total number of open counters are - "+opencount);
	}
}
