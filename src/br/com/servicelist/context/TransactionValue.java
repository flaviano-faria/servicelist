package br.com.servicelist.context;

public class TransactionValue {
	
	private int userId;
	private int month;
	private int index;
	
	public TransactionValue(int userId, int month, int index) {
		this.userId = userId;
		this.month = month;
		this.index = index;
	}
	
	public int generateTransactionValue(int userId, int month, int index) {
		TransactionValue t = new TransactionValue(userId, month, index);
		return t.hashCode();
	}
	
	@Override
	public int hashCode() {
		final int prime = 50;
		int result = 1;
		result = prime * result + index;
		result = prime * result + month;
		result = prime * result + userId;
		return result;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
