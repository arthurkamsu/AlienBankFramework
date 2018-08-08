package com.alienbankframework.domain;

import java.time.LocalDate;

public interface IEntry {
	
	public IAccount getAccount();

	public String getAccountNumber();

	public LocalDate getDate();

	public double getTransactionAmount();

	public EntryType getEntryType();

	public double getUpdatedBalance(double balance);
}
