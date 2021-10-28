import java.io.*;

public class InputOutput {
	
	public static void main(String args[]) throws IOException {
		 FileInputStream in = null;
		 FileOutputStream out = null;
		 
		 
		 try {
			 int c;
			 in = new FileInputStream("C:\\Users\\abhinav.abhay\\Downloads\\inputoutput\\input.txt");
			out= new FileOutputStream("C:\\Users\\abhinav.abhay\\Downloads\\inputoutput\\output.txt");
			
			while((c=in.read())!=-1) {
				out.write(c);
			}
		 }catch(Throwable e){
			 e.toString();
			 
		 }finally {
			 if(in !=null) {
				 in.close();
			 }
			 
			 if(out !=null) {
				 out.close();
			 }
		 }
		 
	}
}
