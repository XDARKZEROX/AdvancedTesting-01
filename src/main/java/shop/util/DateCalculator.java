package shop.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateCalculator {

	public static Date sumBusinessDays(Date date,int days){
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		for (int i = 0; i < days; i++){
			do {
				cal.add(Calendar.DAY_OF_MONTH, 1);
			} while (!isBusinessDay(cal));
		}
		return cal.getTime();
	}
	
	public static Date sumDays(Date date,int days){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	private static boolean isBusinessDay(Calendar cal) {
		int diaSemana = cal.get(Calendar.DAY_OF_WEEK);
		if (diaSemana == Calendar.SUNDAY || diaSemana == Calendar.SATURDAY)
			return false;
		return true;
	}
}
