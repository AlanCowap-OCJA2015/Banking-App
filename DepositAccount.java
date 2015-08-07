package com.bank;

class DepositAccount extends Account{
	static final double interestRate = 0.04;
	static final String accountType = "Deposit";
	
	DepositAccount(Customer customer){
		super(customer);
	}

	public String getAccountType(){
		return DepositAccount.accountType;
	}
	
	public double calculateInterest(){
		return this.getAccountBalance() * DepositAccount.interestRate;
	}

	public String toString(){
		return "Deposit Account: " + super.toString(); 
	}

}
