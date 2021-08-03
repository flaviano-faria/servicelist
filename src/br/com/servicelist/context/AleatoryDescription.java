package br.com.servicelist.context;

import java.security.SecureRandom;

public class AleatoryDescription {
	
	private int id;
	private int month;
	private int year;
	
	private char[] consonantArray = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'r', 's', 't', 'v', 'x', 'z'};
	private char[] vowelArray = {'a', 'e', 'i', 'o', 'u'};
	
	public AleatoryDescription(int id, int month, int year) {
		this.id = id;
		this.month = month;
		this.year = year;
		
	}
	
	public String generateRequestId(int id, int month, int year, int index) {
		Timestamp t = new Timestamp();
		long timestampMonth = java.sql.Timestamp.valueOf(t.getFirstDayOfMonth(month, year).atStartOfDay()).getTime();
		
		long requestId = index+timestampMonth+id;
		StringBuilder requestIdStr = new StringBuilder(String.valueOf(requestId));
		
		return requestIdStr.toString();
	}

	public int generateRandomIndex() {
		
		SecureRandom r = new SecureRandom();		
		return r.nextInt(23);	
	}
	
	public int generateRandomPhraseLength() {
		SecureRandom random = new SecureRandom();
	    return random.ints(10, 61).findFirst().getAsInt();
	}
	
	public int getWordLength(String hash) {
	    return hash.length();
	}
	
	
	public String generateReadableWord(int id, int month, int year, int index) {
		String wordHash = generateRequestId(id, month, year, index);
		int hash = Math.abs(wordHash.hashCode());
		wordHash = wordHash.concat(String.valueOf(hash));
		int worldLength = getWordLength(wordHash);
		 
		char[] worldArray = new char[worldLength];
		if(isPairLength(worldLength)) {
			for (int i = 0; i < worldArray.length; i++) {
				
				if(i==0) {
					worldArray[i] = getConsonantAt(getHashCharAt(i, wordHash));
					continue;
				}
				if(i%2!=0) {
					worldArray[i] = getVowelAt(getHashCharAt(i, wordHash));
				} else {
					worldArray[i] = getConsonantAt(getHashCharAt(i, wordHash));
				}
			}
		} else {
			for (int i = 0; i < worldArray.length; i++) {
				
				if(i==0) {
					worldArray[i] = getVowelAt(getHashCharAt(i, wordHash));
					continue;
				}
				if(i%2!=0) {
					
					worldArray[i] = getConsonantAt(getHashCharAt(i, wordHash));
				} else {
					worldArray[i] = getVowelAt(getHashCharAt(i, wordHash));
				}
			}
		}
		return new String(worldArray);
	}
	
	private char getHashCharAt(int index, String wordHash) {
		return wordHash.charAt(index);
	}
	
	private boolean isPairLength(int worldLength) {
		return worldLength%2==0;
	}
	
	private char getConsonantAt(int index) {
		int ind = index - '0';
		return getConsonantArray()[ind];
	}
	
	private char getVowelAt(char index) {
		int ind = index - '0';
		if(index>4) {
			return getVowelArray()[ind%4];
		} else {
			return getVowelArray()[ind];
		}
	}
	
	
	public boolean isVowel(char letter) {
		return new String(getVowelArray()).indexOf(letter)>-1;
	}
	
	public boolean isConsonant(char letter) {
		return new String(getConsonantArray()).indexOf(letter)>-1;
	}
	
	
	public char[] getVowelArray() {
		return vowelArray;
	}

	public void setVowelArray(char[] vowelArray) {
		this.vowelArray = vowelArray;
	}
	
	public char[] getConsonantArray() {
		return consonantArray;
	}

	public void setConsonantArray(char[] consonantArray) {
		this.consonantArray = consonantArray;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}

