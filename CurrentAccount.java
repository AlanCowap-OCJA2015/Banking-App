package com.bank;

import java.util.Random;

public class CurrentAccount extends Account implements Auditable{
	static final double MAX_OVERDRAW = -1000.0;
	boolean hasChequeBook = false;
	static final String accountType = "Current";

	CurrentAccount(Customer customer){
		super(customer);
		Random rand = new Random();
		this.hasChequeBook = rand.nextBoolean();
		if (this.getAccountBalance() < MAX_OVERDRAW) {
			this.setAccountBalance(MAX_OVERDRAW);
		}
	}

	public boolean audit(){
		if (this.getAccountBalance() < 0) {
			return true;		
		} else {
			return false;
		}
	}

	public String getAccountType(){
		return CurrentAccount.accountType;
	}
	public String toString(){
		return "Current Account: " + super.toString() 
			+ (hasChequeBook ? "\nHas Cheque Book." : "\nDoes not have Cheque Book"); 
				
	}


}
