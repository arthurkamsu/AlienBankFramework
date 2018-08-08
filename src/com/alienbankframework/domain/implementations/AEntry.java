package com.alienbankframework.domain.implementations;

import java.time.LocalDate;

import com.alienbankframework.domain.EntryType;
import com.alienbankframework.domain.IAccount;
import com.alienbankframework.domain.IEntry;

public abstract class AEntry implements IEntry{

	private String accountNumber;
	private LocalDate date;
	private double transactionAmount;
	private EntryType entryType;

	private IAccount account;
	
	public AEntry() {
		
	}
	
	public AEntry(IAccount account, String accountNumber, LocalDate date, double amt, EntryType entryType) {
		this.account = account;
		this.accountNumber = accountNumber;
		this.date = date;
		this.transactionAmount = amt;
		this.entryType = entryType;
	}
	
	public abstract double getUpdatedBalance(double balance);
	
	
	public IAccount getAccount() {
		return account;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public EntryType getEntryType() {
		return entryType;
	}
	
	
	
}
