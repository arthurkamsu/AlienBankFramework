package com.alienbankframework.domain.implementations;

import com.alienbankframework.domain.IBalanceStrategy;

public class WithdrawStrategy implements IBalanceStrategy{

	// Not implemented
	@Override
	public double getUpdatedBalance(double balance, double transactionAmt) {
		return balance -= transactionAmt;
	}

}
