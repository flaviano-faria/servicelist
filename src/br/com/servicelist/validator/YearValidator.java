package br.com.servicelist.validator;

import java.util.regex.Pattern;
import br.com.servicelist.exception.YearValidationException;

public class YearValidator {
	
	private Pattern pattern = Pattern.compile("\\d+");
	
	public void validateYear(String year) throws YearValidationException {
		
		
		if(null == year || year.length()==0) {
			throw new YearValidationException("year required");
		}
		
		if(!pattern.matcher(year).matches()) {
			throw new YearValidationException("Invalid year. This is numeric integer and positive param");
		}
		
		if(year.length()<4) {
			throw new YearValidationException("Invalid year. format yyyy is required ");
		}
		
		
		
		
	}

}
