package br.com.servicelist.validator;

import java.util.regex.Pattern;

import br.com.servicelist.exception.IdValidationException;

public class IdValidator {
	private Pattern pattern = Pattern.compile("\\d+");
	
	public void validateId(String id) throws IdValidationException {
		
		if(null == id || id.length()==0) {
			throw new IdValidationException("id required");
		}
		
		if(!pattern.matcher(id).matches()) {
			throw new IdValidationException("Invalid id. This is numeric integer and positive param");
		}
		
		if(!(Integer.parseInt(id)>=1000 && Integer.parseInt(id)<=100000)) {
			throw new IdValidationException("Invalid id. This accepts values between 1.000 and 100.000");
		}
	}

}
