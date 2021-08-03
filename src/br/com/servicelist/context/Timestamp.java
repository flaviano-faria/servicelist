package br.com.servicelist.context;

import java.time.LocalDate;

public class Timestamp {
	

	public long generateTimestamp(int month, int year, int index) {
		LocalDate lastDayOfMonth = getLastDayOfMmonth(month, year);
		int numOfDays = getLastDayOfMmonth(month, year).getDayOfMonth();
		
		if(isGreatherThanNumOfDays(index, numOfDays)) {
			if(isNumOfDaysDividable(index, numOfDays)) {
				return java.sql.Timestamp.valueOf(lastDayOfMonth.withDayOfMonth(1).atStartOfDay()).getTime();
			} else {
				return java.sql.Timestamp.valueOf(lastDayOfMonth.withDayOfMonth((index+1)%numOfDays).atStartOfDay()).getTime();
			}
			
		} else {
			return java.sql.Timestamp.valueOf(lastDayOfMonth.withDayOfMonth(index+1).atStartOfDay()).getTime();
		}
	}
	
	private boolean isNumOfDaysDividable(int index, int numOfDays) {
		return (index+1)%numOfDays==0;
	}
	
	private boolean isGreatherThanNumOfDays(int index, int numOfDays) {
		return index+1>numOfDays;
	}
	
	public LocalDate getFirstDayOfMonth(int month, int year) {
		String firstDay = parseYear(year) +"-" +parseMonth(month)+ "-" + "01";
		return LocalDate.parse(firstDay);
	}
	
	public LocalDate getLastDayOfMmonth(int month, int year) {
		String nextMonthDate = "";
		if(month==12) {
			++year;
			month = 1;
			
			nextMonthDate = parseYear(year) +"-" +parseMonth(month)+ "-" + "01";
		} else {
			nextMonthDate = parseYear(year) +"-" +parseMonth(month+1)+ "-" + "01";
		}
		
		
		
		return LocalDate.parse(nextMonthDate).minusDays(1);
	}
	
	private String parseMonth(int month) {
		return String.valueOf(month).length()==1?"0"+
				String.valueOf(month):String.valueOf(month);
	}
	
	private String parseYear(int year) {
		return String.valueOf(year);
	}
}
