package ver.badminton.queing.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.ObjectMapper;

import ver.badminton.logging.ConsoleLog;
import ver.badminton.logging.DBLog;
import ver.badminton.logging.LogLevel;

public class Util {
	private static final String DATE_FORMAT_ONE ="yyyy-MM-dd HH:mm:ss.SSS";
	private static final String DATE_FORMAT_TWO ="yyyy-MM-dd";
	
	//Getting token
	private static final long TWELVE_MINUTES = 720000L;
	private static String acctInquiryToken;
	private static String paymentToken;
	private static long acctInquiryTokenValidity;
	private static long paymentTokenTimevalidity;
	
	private Util() {
		throw new IllegalStateException("Utility class");
	}
	
	public static boolean isValidAmount(Double amount) {
		return amount > 0.0;
	}

	public static String objToJson(Object org) {
		ObjectMapper obj = new ObjectMapper();
		String jsonStr = "";
		try {
			jsonStr = obj.writeValueAsString(org);
		} catch (Exception e) {
			Util.log("", "", "Util", "objToJson", LogLevel.ERROR, "Exception",
					"Got exception while converting Object to JSON", e.toString());
			return null;
		}
		return jsonStr;
	}

	public static void log(String transactionNumber, String accountNumber, String className, String methodName,
			LogLevel level, String title, String message, String jsonStr) {
		ConsoleLog.getInstance().log(transactionNumber, accountNumber, className, methodName, level, title, message,
				jsonStr);
		DBLog.getInstance().log(transactionNumber, accountNumber, className, methodName, level, title, message,
				jsonStr);
	}

	public static String coalesce(String a, String b) {
		if (a != null)
			return a;
		else
			return b;
	}

	public static void close(AutoCloseable e) {
		try {
			e.close();
		} catch (Exception ex) {
		}
	}
	
	public static String postingDateFormat(Date date) {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(date);
	}

	public static String dbDateFormat(Date date) {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT_ONE);
		df.setTimeZone(TimeZone.getTimeZone("Asia/Manila"));
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return df.format(cal.getTime());
		
	}
	public static String dbDateFormatStr(String date) {
		ConsoleLog.getInstance()._log("Not Formatted:" + date);
		Date dff = null;
		try {
			dff = new SimpleDateFormat(DATE_FORMAT_ONE).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ConsoleLog.getInstance()._log("Formatted:" + dbDateFormat(dff));
		return dbDateFormat(dff);
	}
	
	public static String postingDateFormat(String date) {
		Date dff = null;
		try {
			dff = new SimpleDateFormat(DATE_FORMAT_ONE).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return postingDateFormat(dff);
	}
	
	public static String bcDateFormat(String date) {
		Date dff = null;
		try {
			dff = new SimpleDateFormat("MM/dd/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return date;
		}

		DateFormat df = new SimpleDateFormat(DATE_FORMAT_TWO);
		df.setTimeZone(TimeZone.getTimeZone("Asia/Manila"));
		return df.format(dff)+" 00:00:00";
	}
}
