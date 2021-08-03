package br.com.servicelist.exception;

public class MonthValidationException extends Exception{

	private static final long serialVersionUID = 1L;

	public MonthValidationException(String msg) {
		super(msg);
	}
}
