package com.vishal.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConversion {

	public static void main(String[] args) {
		final String HYBRIS_STREET_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
		DateFormat originalFormat = new SimpleDateFormat(HYBRIS_STREET_DATE_FORMAT);
		DateFormat targetFormat = new SimpleDateFormat("mm/dd/yyyy hh:mm");
		targetFormat.setTimeZone(Calendar.getInstance().getTimeZone());
		try {
			Date date = originalFormat.parse("2019-09-09T15:42:24+0000");
			System.out.println(targetFormat.format(date));
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			System.out.println(calendar);
		} catch (ParseException e) {
			System.out.println("Parse Exception" + e);
		}
	}

}
