package com.alienbankframework.service;

import java.time.LocalDate;
import java.util.Iterator;

import com.alienbankframework.domain.EntryType;
import com.alienbankframework.domain.IAccount;

public interface IAccountManager {

	void createEntry(String accountNumber, LocalDate date, double amount, EntryType entryType);
	void addAccount(IAccount acc);
	Iterator<IAccount> generateReport();
	void addInterestOnAccounts(double interest);
	IAccount getAccount(String accountNumber);
	double getEntryBalance();
	Iterator<IAccount> iterator();
}
