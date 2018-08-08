package com.alienbankframework.domain;

import java.time.LocalDate;

public interface IEntryFactory {
	
	public IEntry getEntry(IAccount account, String accountNumber, LocalDate date, double amount, EntryType entryType);

}
