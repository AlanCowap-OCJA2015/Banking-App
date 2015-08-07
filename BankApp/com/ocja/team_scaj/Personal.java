package com.ocja.team_scaj;
import java.io.*;
public class Personal extends Customer implements Serializable{

	//States of Personals class
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2558463905066525274L;
	private String DOB;
	private String PPS;
	private final String HEADING = "=============";

	
	//Constructor for Customer class	
	public Personal(){
	}

	public Personal(String name, String address, String phoneNum, String dob, String pps){
		super(name, address, phoneNum);
		this.DOB = dob;
		this.PPS = pps;
	}

	public void audit(){
		
		if(super.checkAccQty() > 1){
			
			Account tempAcc = super.getAccount(1);

			if((tempAcc instanceof Deposit) && (tempAcc.getBalance() * 0.04 > 1000)){

				//print all details
				System.out.println(HEADING + HEADING);
				System.out.println(this);
				System.out.println(tempAcc);
				System.out.println("Rate: " + tempAcc.getBalance() * 0.04);
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
		
			if(super.getAccount(0) instanceof Deposit && (tempAcc.getBalance() * 0.04 > 1000)){

				//print all details
				System.out.println(HEADING + HEADING);
				System.out.println(this);
				System.out.println(tempAcc);
				System.out.println("Rate: " + tempAcc.getBalance() * 0.04);
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

	public String getDOB(){
		return this.DOB;
	}

	public void setDOB(String dob){
		this.DOB = dob;
	}

	public String getPPS(){
		return this.PPS;
	}

	public void setPPS(String pps){
		this.PPS = pps;
	}

	public String toString(){
		return "\nPersonal Customer\n" + super.toString() + "\nD.O.B:" + this.DOB + "\nPPS:" + this.PPS + "\n";
	}

}