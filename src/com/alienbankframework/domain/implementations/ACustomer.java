package com.alienbankframework.domain.implementations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alienbankframework.domain.IAccount;
import com.alienbankframework.utils.IAutomatedEmail;
import com.alienbankframework.domain.ICustomer;
import com.alienbankframework.domain.IEntry;
import com.alienbankframework.utils.implementations.AutomatedEmail;


 
public abstract class ACustomer implements ICustomer{
	private String name;
	private String state;
	private String street;
	private String city;
	private String zip;
	private String email;
	IEntry entry;
	IAutomatedEmail autoEmail;
	List<IAccount> accnts;
	
	public ACustomer(String name,String state,String street,String city,String zip,String email){
		this.name = name;
		this.state = state;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.email = email;
		accnts = new ArrayList();
		 
		
	}
	
	public void addAccount(IAccount acct){
		accnts.add(acct);
	}
	public void removeAccount(IAccount acct){
		Iterator it = accnts.iterator();
		while (it.hasNext()){
			if (it.next().equals(acct)){
				it.remove();
			}
		}
	}
	public void sendEmailToCustomer(IEntry entry){
		this.entry = entry;
 		autoEmail = new AutomatedEmail(entry.getEntryType().toString(), entry.getTransactionAmount(),
				entry.getAccount().getCurrentBalance());
		autoEmail.excute();
	}

}
