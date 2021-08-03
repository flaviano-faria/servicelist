package br.com.servicelist.dto;

public class ValidatorMessage {
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ValidatorMessage(String description) {
		super();
		this.description = description;
	}

}
