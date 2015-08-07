package com.bank ;
import java.util.ArrayList ;
import com.bank.Account;
import java.io.Serializable;

public abstract class Customer implements Auditable, Serializable{
	private String name ;
	private String address ;
	private String phoneNo ;
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public Customer(String name , String address , String phoneNo){
		this.setName(name);
		this.setAddress(address);
		this.setPhoneNo(phoneNo);
	}

	public Customer(){
		this("N/A","N/A","N/A");
	}

	public void setName(String name){
		this.name = name;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public void setPhoneNo(String phoneNo){
		this.phoneNo = phoneNo;
	}
	
	public void addAccount(Account account){
		this.accounts.add(account);
	}

	public String getName(){
		return this.name;
	}
	
	public String getAddress(){
		return this.address;
	}

	public String getPhoneNo(){
		return this.phoneNo;
	}

	public ArrayList<Account> getAccounts(){
		return this.accounts;
	}

	public boolean audit(){
		for(Account acc: this.accounts){
			Account ac = acc;
			if(ac instanceof Auditable){
				return ac.audit();	
			}//end if
			else{
				return false;
			}//end else
		}//end for
		return false;	
	}//end audit

	public void displayAccounts(){
		System.out.println(this.name + " has the account/s");
		for(Account ac : accounts){
			System.out.println(ac);
		}//end for	
	}//end display



	public String toString(){
		String output = this.name;
		output += "\n" + this. address;
		output += "\n" + this. phoneNo + "\n";
		for(Account ac: accounts){
			output += (ac.getAccountType() +  " " + ac.getAccountNumber()) + " | ";
		}//end for
		return output;
	}//end toString

}
