package com.bank;

import java.util.ArrayList;
import java.util.Random;
import java.io.PrintWriter;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class Bank{

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public void listCustomers(){

		for(Customer c : customers){

			System.out.println(c.toString() + "\n");

		}

	}

	public void listAccounts(){

		for(Account a: accounts){
			System.out.println("Customer: " + a.getCustomer().getName() + "\n" + a.toString() + "\n");
		}
		

	}


	public void auditCustomers(){

		

		for(Customer c : customers){

			if(c.audit()){
				
				c.displayAccounts();

			}

		}


	}

		
	public void createCustomers(){

		for(int i = 0; i < 100;i++){

			Random rand = new Random();
			int amountOfAccountsPers = rand.nextInt((2 - 1) + 1) + 1;
			int amountOfAccountsBusi = rand.nextInt((2 - 1) + 1) + 1;
			PersonalCustomer personal = new PersonalCustomer("Sam" + i, i + " that street", "555-49" + i, "06/08/1980", "394" + i + "458F" );
			BusinessCustomer business = new BusinessCustomer("Bob" + i, i + " some street", "555-34" + i, "IE339" + i, rand.nextBoolean()); 
			
			if(amountOfAccountsPers == 1){

				int accountType = rand.nextInt((2 - 1) + 1) + 1;
				boolean isCurrentAccount = accountType == 1;
				createAccount(personal, isCurrentAccount);		

			}else{
				createAccount(personal, true);
				createAccount(personal, false);
			}

			if(amountOfAccountsBusi == 1){

				int accountType = rand.nextInt((2 - 1) + 1) + 1;
				boolean isCurrentAccount = accountType == 1;
				createAccount(business,isCurrentAccount);

			}else{

				createAccount(business,true);
				createAccount(business, false);

			}

			customers.add(personal);
			customers.add(business);

		}

	}

	public void createAccount(Customer c, boolean isCurrentAccount){
		
		
		Account a = isCurrentAccount ? new CurrentAccount(c) : new DepositAccount(c);
		accounts.add(a);
		c.addAccount(a);

	}

	public void save(){
		
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customers.txt"));
		
			for(Customer c: customers){
				oos.writeObject(c);
			}


			oos.flush();
			oos.close();
		}catch(Exception e){}
		
		
		


	}

	public void loadCustomers(){

		try{
			ArrayList<Customer> custs = new ArrayList<Customer>();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customers.txt"));
			
			for(int i = 0; i < 200; i++){
				Customer c = (Customer)ois.readObject();
				custs.add(c);
			}
			customers = custs;
		}catch(Exception e){
			e.printStackTrace();
		}


	}

	

}
