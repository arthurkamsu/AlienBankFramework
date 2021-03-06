package com.alienbankframework.domain;

import java.util.Iterator;

public interface IAccount {

	public void addEntry(IEntry entry);
	public double getCurrentBalance();
	public void notifyCustomer(IEntry entry);
	public void addInterest(double interest);
	public String getAccountNumber();
	public Iterator<IEntry> getEntryListIterator();
}
