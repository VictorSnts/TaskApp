package com.victor.taskapp.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Utils {
	
	public static Date getSystemDate() throws ParseException {
		Calendar data = Calendar.getInstance();
		Date d = data.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.parse(dateFormat.format(d));
	}
	
	public static Date getNextSystemDate() throws ParseException {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DAY_OF_MONTH, 1);
		Date d = data.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.parse(dateFormat.format(d));
	}
	
	public static LocalDate toLocalDate(String data) {
		String[] vetData = data.split("/");
		return LocalDate.of(Integer.parseInt(vetData[2]), Integer.parseInt(vetData[1]), Integer.parseInt(vetData[0]));
	}

}
