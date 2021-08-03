package br.com.servicelist.validator;

import java.util.regex.Pattern;

import br.com.servicelist.exception.MonthValidationException;

public class MonthValidator {
	
	private Pattern pattern = Pattern.compile("[0-9]+");
	
	public void validateMonth(String month) throws MonthValidationException {
		
		if(null == month || month.length()==0) {
			throw new MonthValidationException("month required");
		}
		
		if(!pattern.matcher(month).matches()) {
			throw new MonthValidationException("Invalid month. This is numeric integer and positive param");
		}
		
		if(!(Integer.parseInt(month)>=1 && Integer.parseInt(month)<=12)) {
			throw new MonthValidationException("Invalid month. This accepts values between 1 and 12");
		}
	}

}
