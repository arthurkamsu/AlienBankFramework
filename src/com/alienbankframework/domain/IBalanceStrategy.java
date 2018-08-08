package com.alienbankframework.domain;

public interface IBalanceStrategy {

	public double getUpdatedBalance(double balance, double transactionAmt);
	
}
