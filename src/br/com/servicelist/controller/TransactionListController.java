package br.com.servicelist.controller;

import br.com.servicelist.context.AleatoryDescription;
import br.com.servicelist.dto.Transaction;
import br.com.servicelist.context.Timestamp;
import br.com.servicelist.context.TransactionValue;

public class TransactionListController {
	
	
	public Transaction getTransactionByIdMonthYear(int id, int month, int year, int index) {
		Timestamp t = new Timestamp();
		long timestamp = t.generateTimestamp(month, year, index);
		
		TransactionValue value = new TransactionValue(id, month, index);
		int transactionValue = value.generateTransactionValue(id, month, index);
		
		AleatoryDescription description = new AleatoryDescription(id, month, year);
		String aleatoryDescription = description.generateReadableWord(id, month, year, index);
		
		return new Transaction(transactionValue, aleatoryDescription, timestamp);
	}
	
	public Transaction[] getTransactionList(int id, int month, int year){
		int numOfTransactions = getNumberOfTransacions(id, month);
		Transaction[] transactionList = new Transaction[numOfTransactions];
		for (int i = 0; i < numOfTransactions; i++) {
			transactionList[i] = new Transaction();
			Transaction transaction = getTransactionByIdMonthYear(id, month, year, i);
			transactionList[i].setDescription(transaction.getDescription());
			transactionList[i].setTimestamp(transaction.getTimestamp());
			transactionList[i].setValue(transaction.getValue());
		}
		return transactionList;
	}
	
	public int getNumberOfTransacions(int id, int month) {
		return month * getFirstDigitFromMonth(id);
	}
	
	private int getFirstDigitFromMonth(int id) {
		return String.valueOf(id).charAt(0)-'0';
	}


}
