package com.alienbankframework.domain.implementations;

import com.alienbankframework.domain.ICustomer;
import com.alienbankframework.domain.ICustomerFactory;

public abstract class ACustomerFactory implements ICustomerFactory {
	public abstract ICustomer getCustomer(String name,String state,
			String street,String city,String zip,String email);
}
