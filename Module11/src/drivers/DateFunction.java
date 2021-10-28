package drivers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFunction {

	public static void main(String[] args) throws ParseException {
		
		 String a = "100";
		 String b = "200";
		 
		 int c = Integer.parseInt(a) + Integer.parseInt(b);
		 System.out.println(c);
		 
		 String d = "15/02/2014";
		 
		 Date d1 = new Date();
		 System.out.println(d);
		 
		 SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		 Date dateformatted = sd.parse(d);
		 System.out.println(dateformatted);
		 String day = new SimpleDateFormat("dd").format(dateformatted);
		 String month = new SimpleDateFormat("MMM").format(dateformatted);
		 String year = new SimpleDateFormat("yyyy").format(dateformatted);
		 System.out.println(day);
		 System.out.println(month);
		 System.out.println(year);
	}

}
