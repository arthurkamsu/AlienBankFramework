package com.alienbankframework.service.implementations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alienbankframework.Alien;
import com.alienbankframework.controller.implementations.AlienController;
import com.alienbankframework.domain.EntryType;
import com.alienbankframework.domain.IAccount;
import com.alienbankframework.domain.IEntry;
import com.alienbankframework.domain.IEntryFactory;
import com.alienbankframework.domain.implementations.EntryFactory;
import com.alienbankframework.service.IAccountManager;

public class AccountManager implements IAccountManager {
	
	private static volatile AccountManager instance = null;
	
	private List<IAccount> accountList = new ArrayList<IAccount>();

	private IEntryFactory entryFactory = EntryFactory.getInstance();
	
	private double updatedAccountBalance;
	
	
    public static AccountManager getInstance() {
        if (instance == null) {
            synchronized(Alien.class) {
                if (instance == null) {
                    instance = new AccountManager();
                }                
            }
        }else System.out.println("Instance of AccountManager alredy exists. The existing instance is being returned.");
        return instance;
    }
    
    private AccountManager() {}
	
	
	public void addAccount(IAccount acc) {
		accountList.add(acc);
	}
	
	public void createEntry(String accountNumber, LocalDate date, double amount, EntryType entryType) {
		
		IAccount account = this.getAccount(accountNumber);
		
		IEntry entry = entryFactory.getEntry(account, accountNumber, date,amount, entryType);
		account.addEntry(entry);
		updatedAccountBalance = account.getCurrentBalance();
	}
	
	public Iterator<IAccount> generateReport() {
		return this.accountList.iterator();
	}
	
	public void addInterestOnAccounts(double interest) {
		for(IAccount account: accountList) {
			account.addInterest(interest);
		}
	}
	
	public IAccount getAccount(String accountNumber) {
		for(IAccount account: accountList) {
			if(accountNumber.equals(account.getAccountNumber()))
				return account;
		}
		return null;
	}
	
	public double getEntryBalance() {
		return updatedAccountBalance;
	}

	public Iterator<IAccount> iterator() {
		return accountList.iterator();
	}
	
}
