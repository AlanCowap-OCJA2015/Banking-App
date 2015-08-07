package com.ocja.team_scaj;
import java.util.Calendar;
import java.io.*;

public class Transaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9222678844870827449L;
	//state
	Calendar date;
	double amount;
	//constructor
	public Transaction(){
	}

	public Transaction(Calendar date, double amount){
		this.date = date;
		this.amount = amount;
	}
	
	
	//get and set date
	public void setDate(Calendar date){
		this.date = date;
	}
		public Calendar getDate(){
		return this.date;
	}

	//get and set amount
	public void setAmount(double amount){
		this.amount = amount;
	}
		public double getAmount(){
		return this.amount;
	}
}
