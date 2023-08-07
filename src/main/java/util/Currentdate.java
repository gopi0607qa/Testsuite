package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Currentdate {

	public static String Systemdate() {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy H:m:s:S");
		Date date = new Date();
		String curr_date = dateFormat.format(date);
		System.out.println(curr_date);
		return curr_date;
	}

}
