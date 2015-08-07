package com.bank;

import java.io.Console;


public class BankApp{

	private Bank bank = new Bank();

	public static void main(String[] args){

		new BankApp().startApp();
		
		
		

	}

	private void startApp(){

		Bank bank = new Bank();
		bank.createCustomers();

		Console input = System.console();
		

		boolean isRunning = true;

		do{
			System.out.println("1)List all customers and their accounts.");
			System.out.println("2)List all accounts and their customers.");
			System.out.println("3)Audit all customers.");
			System.out.println("4)Save to File");
			System.out.println("5)Load from file");
			System.out.println("6)Exit");
			String choice = input.readLine();
			int menuOption = 0;
			
			try{
				menuOption = Integer.parseInt(choice);
				if(menuOption < 1 || menuOption > 6){

					throw new NumberFormatException();

				}
			}catch(NumberFormatException nfe){

				System.out.println(choice + " is an invalid choice, please try again\n");
				continue;
			}

			switch(menuOption){

				case 1:
					bank.listCustomers();
					break;
				case 2:
					bank.listAccounts();
					break;
				case 3:
					bank.auditCustomers();
					break;
				case 4:
					bank.save();
					break;
				case 5:
					bank.loadCustomers();
					break;
				case 6:
					isRunning = false;
					break;
				

			}

			

		}while(isRunning);


	}


}
