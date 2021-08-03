package br.com.servicelist.dto;

public class Transaction {
	
	private int value;
	private String description;
	private long timestamp;
	
	public Transaction(int value, String description, long timestamp) {
		super();
		this.value = value;
		this.description = description;
		this.timestamp = timestamp;
	}
	
	public Transaction() {
		super();
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	

}
