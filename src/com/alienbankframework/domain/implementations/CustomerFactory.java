package com.alienbankframework.domain.implementations;

import com.alienbankframework.domain.ICustomer;
import com.alienbankframework.domain.ICustomerFactory;

public class CustomerFactory implements ICustomerFactory {
	
	String name;
	String state;
	String street;
	String city;
	String zip;
	String email;
	
	public CustomerFactory() {
	}
	
	public CustomerFactory (String name,String state,
			String street,String city,String zip,String email){
		this.name = name;
		this.state = state;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.email = email;
		
	}
	
	@Override
	public ICustomer getCustomer() {
 		return new Customer(name, state, street, city, zip, email);
	}
	

}
