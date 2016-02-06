package shop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	
	private static String pattern="MMM. d, yyyy";

	public static String format(Date fecha) {
		SimpleDateFormat dt = new SimpleDateFormat(pattern);
		return dt.format(fecha);
	}
	
	public static Date parse(String fecha){
		SimpleDateFormat dt = new SimpleDateFormat(pattern);
		try {
			return dt.parse(fecha);
		} catch (ParseException e) {
			return null;
		}
	}
}
