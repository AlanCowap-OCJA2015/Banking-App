package com.ocja.team_scaj;
import java.io.*;
class Deposit extends Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5069585522301928003L;
	//state
	double rate;

	//constructor
	public Deposit(double balance, int accountNumber, Transaction transaction, double rate){
		super(balance, accountNumber, transaction);
		this.rate = balance * rate;
	}

	//behaviour
	public void setRate(Double rate){
		this.rate = rate;
	}

	public double getRate(){
		return this.rate;
	}
}