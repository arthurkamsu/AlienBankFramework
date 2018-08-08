package com.alienbankframework.domain.implementations;

/*
 * Not used in the application
 */


import java.util.Iterator;
import java.util.List;

import com.alienbankframework.domain.IAccount;

public class AccountIterator implements Iterator<IAccount>{

	private List<IAccount> accountList;
	
	public AccountIterator(List<IAccount> list) {
		this.accountList = list;
	}
	
	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public IAccount next() {
		// TODO Auto-generated method stub
		return null;
	}

}
