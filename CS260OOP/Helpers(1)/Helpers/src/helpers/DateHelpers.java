package helpers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelpers {
	
	static Date today;
	static String dateOut;
	
	public static String TodaysDate() {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
		today = new Date();

		return df.format(today);
		
	}

}
