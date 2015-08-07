package com.ocja.team_scaj;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import javax.swing.*;

public class BankApp{
	private ArrayList<Customer> customersList = new ArrayList<Customer>();
	
	private ArrayList<String> nameList = new ArrayList<String>();
	private ArrayList<String> lastNames = new ArrayList<String>();
	private ArrayList<String> firstNames = new ArrayList<String>();	

	private final String HEADING = "=============";
	private Random rand = new Random();

	public static void main(String[] args){
		//System.out.println("Banking App Working");
		BankApp ba = new BankApp();
		ba.runProgram();
	}

	private void runProgram(){
		populateNames();
		populateArrayList(customersList);
		displayMenu();

	}

	private void displayMenu(){
		Scanner scan = new Scanner(System.in);
		boolean invalidInput = true;
		do{
		System.out.println(HEADING + "Banking App Menu" + HEADING);
		System.out.println("1) List all Customers, and their Accounts\n2) List all Accounts, and their Customers\n3) Audit all Customers\n4) Save to file\n5) Read from file\n6) Exit");
		
			

			System.out.print("Enter Your Choice: ");
			
			String userInput = scan.nextLine();

			try{
				int userNumber = Integer.parseInt(userInput);
				
				switch(userNumber){
				case 1: listCustomers();
					//invalidInput = false; 
					break;
				case 2: listAccounts();
					//invalidInput = false; 
					break;
				case 3: auditAllCustomers();
					//invalidInput = false; 
					break;
				case 4: save();
					writeObject();
					break;
				case 5: readObject();
					break;
				case 6: System.out.println("\nExiting Program...");
					invalidInput = false; break;
				default: System.out.println("\nPlease enter digit between (1-4)"); 
					invalidInput = true; break;
				}
			} catch (NumberFormatException nfe) {
				//nfe.printStackTrace();
				System.out.println("\nInvalid Input can't use alpha characters");
			}
		} while(invalidInput);	

		scan.close();
	}

	private void populateNames(){
		Random randy = new Random();

		try {
			Scanner hL = new Scanner(new File("lastNames.txt"));
			Scanner hF = new Scanner(new File("firstNames.txt"));


			while (hL.hasNext()){
				lastNames.add(hL.next());
			}

			while (hF.hasNext()){
				firstNames.add(hF.next());
			}


			hL.close();
			hF.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for(int i = 0; i < 500; ++i){
			String firstName = firstNames.get(randy.nextInt(firstNames.size()));
			String temp = firstName.substring(1, firstName.length()).toLowerCase();
			firstName = firstName.charAt(0) + temp;

			String lastName = lastNames.get(randy.nextInt(lastNames.size()));
			temp = lastName.substring(1, lastName.length()).toLowerCase();
			lastName = lastName.charAt(0) + temp;

			String name = firstName + " " + lastName;

			nameList.add(name);
		}


	}

	private void save(){
		JFileChooser saver = new JFileChooser();
		saver.showSaveDialog(null);
		String strFile = saver.getSelectedFile().toString();
		if(!strFile.endsWith(".txt")){
			strFile += ".txt";
		}
				
		File file = new File(strFile);
		String separator = System.getProperty("line.separator");
		String text = "";

		for(int i = 0; i < customersList.size(); ++i){
			text += customersList.get(i).toString();

			for(int j = 0; j < customersList.get(i).checkAccQty(); ++j){
				text += customersList.get(i).getAccount(j).toString() + "\n";
			}
		}


		//String text = textPane.getText();
		text = text.replaceAll("\n", separator);
		try {
			
			PrintWriter out = new PrintWriter(file);
			out.println(text);
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void populateArrayList(ArrayList<Customer> list){
		for(int i = 0; i < 100; ++i){
			list.add(new Personal(nameList.get(i), "129 Cashel Raod" , "0858349667", "18/07/78",("4803" + i)+ "83Y"));
			list.add(new Business(nameList.get(i + 1), "212312 Cashel Road", "0-39103312", "18/31/33", true));
		
			nameList.remove(i);
			nameList.remove(i+1);
		}

		for(Customer c: customersList){
			assignAccount(c);
		}
	}

	private void assignAccount(Customer c){
		
		for(int i = 0;i < (randomGenerator(2)+1); ++i){

			boolean temp = randomGenerator(2) == 1? true : false;		

			Account acc = randomGenerator(2) == 1? new Deposit((randomGenerator(200000) - 100000), randomGenerator(10000) + i,new Transaction(), 0.04D): new Current((randomGenerator(200000) - 100000), randomGenerator(10000) + i,new Transaction(), temp, randomGenerator(10000000)); 
			c.setAccount(acc);
		}
	}

	private int randomGenerator(int index){
		return rand.nextInt(index);
	}

	private void listCustomers(){
		System.out.println("");
		System.out.println(HEADING + "Customers" + HEADING);
		for(Customer c: customersList){
			System.out.println(c);
			for(int i = 0; i < c.checkAccQty(); ++i){
				//System.out.println(HEADING);
				System.out.println(c.getAccount(i) + " " + c);
				System.out.println(HEADING + HEADING);
			}
			
		}


	}
	
	private void listAccounts(){
		System.out.println("");
		System.out.println(HEADING + "Accounts" + HEADING);
		for(Customer c: customersList){
			for(int i = 0; i < c.checkAccQty(); ++i){
				//System.out.println(HEADING);
				System.out.println(c.getAccount(i) + " " + c);
				System.out.println(HEADING + HEADING);
			}
		}
	}

	private void auditAllCustomers(){
		System.out.println("");
		System.out.println(HEADING + "Audits" + HEADING);

		for(Customer c : customersList){
			c.audit();
		}
	}

	private void writeObject(){
		try{
			FileOutputStream fileOut = new FileOutputStream("customers.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			for(Customer c: customersList){
				out.writeObject(c);
			}

			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved to cutomers.ser");
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
	}

	private void readObject(){
		try{
			FileInputStream fileIn = new FileInputStream("customers.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			for(int i = 0; i < 200; ++i){
				customersList.add((Customer)in.readObject());
			}
		

			in.close();
			fileIn.close();	
		} catch(IOException ioe){
			ioe.printStackTrace();
			return;	
		} catch (ClassNotFoundException cnfe){
			 System.out.println("Customer class not found");
        		 cnfe.printStackTrace();
        		 return;
		}
	}

}