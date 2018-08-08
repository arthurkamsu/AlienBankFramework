package com.alienbankframework.domain;


public interface ICustomer {
	public void addAccount(IAccount acct);
	public void removeAccount(IAccount acct);
	public void sendEmailToCustomer(IEntry entry);
}
