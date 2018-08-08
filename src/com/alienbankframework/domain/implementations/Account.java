package com.alienbankframework.domain.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alienbankframework.domain.ICustomer;
import com.alienbankframework.domain.IEntry;

public class Account extends AAccount{

	/*
	private ICustomer customer;
	private String accountNumber;
	private double balance;
	
	private List<IEntry> entryList = new ArrayList<IEntry>();
	
	private IBalanceStrategy balanceTransaction;
	
	*/
	
	public Account(ICustomer customer, String accNumber, double balance) {
		/*
		this.customer = customer;
		this.accountNumber = accNumber;
		this.balance = balance;
		*/
		super(customer, accNumber, balance);
	}
	
	public Account(ICustomer customer, String accNumber) {
		/*
		this.customer = customer;
		this.accountNumber = accNumber;
		this.balance = 0.00;
		*/
		super(customer, accNumber);
	}
	
	public void addEntry(IEntry entry) {
		/*
		this.setCurrentBalance(executeTransaction(entry));
		entryList.add(entry);
		this.notifyCustomer(entry);
		*/
		super.addEntry(entry);
	}
	
	public void notifyCustomer(IEntry entry) {
//		customer.sendEmailToCustomer(entry);
		super.notifyCustomer(entry);
	}
	
	public void addInterest(double interest) {
		/*
		double bal = (interest * balance) + balance;
		setCurrentBalance(bal);
		*/
		super.addInterest(interest);
	}
	
	// does it get the strategy reference
	public double executeTransaction(IEntry entry) {
		/*
		if(entry.getEntryType() == EntryType.DEPOSIT) {
			balanceTransaction = new DepositStrategy();
		} else if(entry.getEntryType() == EntryType.WITHDRAW) {
			balanceTransaction = new WithdrawStrategy();
		}
		return balanceTransaction.getUpdatedBalance(this.getCurrentBalance(), entry.getTransactionAmount());
		*/
		return super.executeTransaction(entry);
	}
	/*
	public void setCurrentBalance(double balance) {
		this.balance = balance;
	}
	
	public double getCurrentBalance() {
		return balance;
	}

	public ICustomer getCustomer() {
		return customer;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Iterator<IEntry> getEntryListIterator() {
		return entryList.iterator();
	}
*/
	
	/*

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}
	
	*/
	
	
}
