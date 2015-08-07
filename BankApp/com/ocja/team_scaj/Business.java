package com.ocja.team_scaj;
import java.io.*;
public class Business extends Customer implements Serializable{

	//States of Business class
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String VAT;
	private boolean taxClearance;
	private final String HEADING = "=============";

	
	//Constructors for Business class
	
	public Business(){
	
		this("", "", "", "", false);
	}

	public Business(String name, String address, String phoneNum, String vat, boolean taxClear){
		
		super(name, address, phoneNum);
		this.VAT = vat;
		this.taxClearance = taxClear;

	}

	//Behaviour

	public void audit(){
		
		if(super.checkAccQty() > 1){
			
			Account tempAcc = super.getAccount(1);

			if(tempAcc instanceof Deposit && tempAcc.getBalance() * 0.04D > 1000){
				
				System.out.println(HEADING + HEADING);
				System.out.println(this);
				System.out.println(tempAcc);
				System.out.println(HEADING + HEADING);

			} else if(super.getAccount(1).getBalance() < 0){

				//print all details
				System.out.println(HEADING + HEADING);
				System.out.println(this);
				System.out.println(tempAcc);
				System.out.println(HEADING + HEADING);

			}


		} else {

			Account tempAcc = super.getAccount(0);
		
			if(tempAcc instanceof Deposit && tempAcc.getBalance() * 0.04D > 1000){

				//print all details
				System.out.println(HEADING + HEADING);
				System.out.println(this);
				System.out.println(tempAcc);
				System.out.println(HEADING + HEADING);

			} else if(super.getAccount(0).getBalance() < 0){

				//print all details
				System.out.println(HEADING + HEADING);
				System.out.println(this);
				System.out.println(tempAcc);
				System.out.println(HEADING + HEADING);

			}

		}
	}


	public boolean getTaxClearnace(){
		return this.taxClearance;
	}

	public void setTaxClearnace(boolean bool){
		this.taxClearance = bool;
	}


	public String getVAT(){
		return this.VAT;
	}

	public void setVAT(String vat){
		this.VAT = vat;
	}

	public String toString(){
		return "\nBusiness Customer\n" + super.toString() + "\nVAT: " + this.VAT + "\nTax Clearance: " + this.taxClearance + "\n";
	}


}