package se.uu.it.TaskUtil;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A tool class to deal with time and date
 *
 */
public final class TimeUtil {
	private TimeUtil() {

	}
 
	/**
	 * Get current Date
	 */
	public static String getCurrDate() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	/**
	 * Get current time
	 */
	public static String getCurrTime() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("HH:mm:ss");
		return formatter.format(date);
	}

	/**
	 * Get current year and month
	 */
	public static String getCurrMonth() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM");
		return formatter.format(date);
	}

	/**
	 * Get change date
	 */
	@SuppressWarnings("deprecation")
	public static String getChangedDate(String strMonth,int monthCount) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM");

		try {
			java.util.Date date = myFormatter.parse(strMonth);
			date.setMonth(date.getMonth()+monthCount);
						
			Format formatter = new SimpleDateFormat("yyyy-MM");
			return formatter.format(date);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Get days in a month
	 * 
	 * @param strMonth
	 * @return
	 */
	public static int getDaysInAMonth(String strMonth) {
		String[] arr=strMonth.split("[-]");
		Calendar cal = new GregorianCalendar(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])-1, 1);
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH); 
		return days;
	}
	
	/**
	 * Get the week day of the first day in a month
	 * @param strMonth
	 * @return
	 */
	public static int getWeekOfFirstDay(String strMonth){
		String[] arr=strMonth.split("[-]");
		
		Calendar xmas = new GregorianCalendar(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])-1, 1);
	    int dayOfWeek = xmas.get(Calendar.DAY_OF_WEEK)-1;    
	    return dayOfWeek;
	}
}