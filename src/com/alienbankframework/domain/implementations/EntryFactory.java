package com.alienbankframework.domain.implementations;

import java.time.LocalDate;

import com.alienbankframework.domain.EntryType;
import com.alienbankframework.domain.IAccount;
import com.alienbankframework.domain.IEntry;
import com.alienbankframework.domain.IEntryFactory;

public class EntryFactory implements IEntryFactory{
	
	private static IEntryFactory myInstance = new EntryFactory();
	
	private EntryFactory() {
		
	}
	
	public static IEntryFactory getInstance() {
		return myInstance;
	}

	public IEntry getEntry(IAccount account, String accountNumber, LocalDate date, double amount, EntryType entryType) {
		if(entryType == EntryType.DEPOSIT)
			return new DepositEntry(account, accountNumber, date, amount, entryType);
		else
			return new WithdrawEntry(account, accountNumber, date, amount, entryType);
	}
}
