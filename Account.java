package com.bank;

import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;

abstract class Account implements Serializable{
	
	private static int numberOfAccounts = 15456;
	private String accountNumber = null;
	private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	private double accountBalance; 
	private Customer accountOwner;
	
	public Account(Customer customer){
		Random rand = new Random();
		this.setAccountNumber();
		this.accountBalance = (rand.nextDouble() - 0.5) * 200_000;
		this.accountOwner = customer;
	}

	public boolean audit(){

		return false;
	}
	
	public abstract String getAccountType();

	
	private void setAccountNumber(){
		this.accountNumber = String.valueOf(numberOfAccounts); 
		++numberOfAccounts;
	}
	public String getAccountNumber(){
		return this.accountNumber;
	}
	public double getAccountBalance(){
		return this.accountBalance;
	}
	public void setAccountBalance(double accountBalance){
		this.accountBalance = accountBalance; 
	}
	public String toString (){
		return "Account number: " + this.accountNumber + "\nAccountBalance: " + this.accountBalance;
	}	

	public Customer getCustomer(){
		return this.accountOwner;
	}
	public ArrayList<Transaction> getTransactionList(){
		return this.transactionList;
	}

}
