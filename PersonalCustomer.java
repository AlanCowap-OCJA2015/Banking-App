package com.bank;

import java.util.ArrayList;

public class PersonalCustomer extends Customer{

	private String dateOfBirth;
	private String pps;

	public PersonalCustomer(String name, String address, String phoneNo, String date, String pps){
		super(name, address, phoneNo);
		this.setDateOfBirth(date);
		this.setPPS(pps);
	}//end constructor

	public void setDateOfBirth(String date){
		this.dateOfBirth = date;
	}//end set

	public void setPPS(String pps){
		this.pps = pps;		
	}//end set

	public String getDateOfBirth(){
		return this.dateOfBirth;
	}//end get

	public String getPPS(){
		return this.pps;
	}//end get

	public String toString(){
		String output = super.toString();
		output += "\n" + this.dateOfBirth + "\n" + this.pps;
		return output;
	}//end toStirng

}//end class
