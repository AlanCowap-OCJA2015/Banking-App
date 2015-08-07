package com.ocja.team_scaj;

import java.io.*;

public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8277613506499359544L;
	//state
	private int accountNumber;
	private Transaction transaction;
	private double balance;

	//constructor
	public Account(){
		this(0, 0, null);
	}

	public Account(double balance, int accountNumber){
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public Account(double balance, int accountNumber, Transaction transaction){
		this(balance, accountNumber);
		this.transaction = transaction;
	}

	//behaviour

	//get and set account number
	public void setAccountNumber(int accountNumber){
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber(){
		return this.accountNumber;
	}

	//get and set balance
	public void setBalance(double balance){
		this.balance = balance;
	}

	public double getBalance(){
		return this.balance;
	}

	//get and set balance
	public void setTransaction(Transaction transaction){
		this.transaction = transaction;
	}

	public Transaction getTransaction(){
		return this.transaction;
	}

	public String toString(){
		return "Account Number: " + this.accountNumber + "\nBalance: " + this.balance;
	}
}