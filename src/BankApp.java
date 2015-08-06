import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class BankApp {

	Scanner scan = new Scanner(System.in);

	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Account> accounts = new ArrayList<Account>();

	/*
	 * Program entry point
	 */
	public static void main (String[] args) {
		new BankApp().runApp();
	}

	/*
	 * Program core
	 */
	public void runApp() {

		initialiseData();

		while (true) {
			switch(showMainMenu()) {
				case 0: return;
				case 1: listCustomersWithAccounts(); break;
				case 2: listAccountsWithCustomers(); break;
				case 3:	auditAccounts(); break;
			}
		}
	}

	/*
	 * Show the main menu, wait for an option to be entered and return it as an int
	 */
	public int showMainMenu() {

		System.out.println(".-------------------------.");
		System.out.println("| Welcome to the bank app |");
		System.out.println("`-------------------------'");
		System.out.println("  Please enter the number for the option you want and press ENTER");
		System.out.println();
		System.out.println("  0.  Exit Program");
		System.out.println("  1.  List customer database with their accounts");
		System.out.println("  2.  List accounts database with their customers");
		System.out.println("  3.  Audit the database");
		System.out.println();

		while (true) {
			String input = scan.nextLine();
			try {
				switch (Integer.parseInt(input)) {
					case 0: return 0;
					case 1: return 1;
					case 2: return 2;
					case 3: return 3;
				}
			} catch (Exception e) {
			}
			System.out.println("Invalid entry. Please try again.");
		}
	}

	/*
	 * Generate random customers and associated accounts
	 */
	public void initialiseData() {
		System.out.println("Initialising customer and account records\n");

		// Create the customer database
		for (int i = 0; i < 100; ++i) {
			customers.add(new PersonalCustomer());
			customers.add(new BusinessCustomer());
		}

		CurrentAccount newCurrent;
		DepositAccount newDeposit;

		// Create accounts for each customer
		for (Customer c : customers) {

			switch (new Random().nextInt(3)) {

				case 0:
					newCurrent = new CurrentAccount(c);
					accounts.add(newCurrent);
					c.accounts.add(newCurrent);
					break;

				case 1:
					newDeposit = new DepositAccount(c);
					accounts.add(newDeposit);
					c.accounts.add(newDeposit);
					break;

				case 2:
					newCurrent = new CurrentAccount(c);
					accounts.add(newCurrent);
					c.accounts.add(newCurrent);
					newDeposit = new DepositAccount(c);
					accounts.add(newDeposit);
					c.accounts.add(newDeposit);
					break;
			}
		}
	}

	/*
	 * List all the bank customers along with each of their accounts
	 */
	public void listCustomersWithAccounts() {
		System.out.println("List customers with their account details\n");
		for (Customer c : customers) {
			System.out.println (c);	
			for (Account a : c.accounts) {
				System.out.println ("       " + a);
			}
			System.out.println ("----------------------------------------------------------------------------");
			
		}
	}

	/*
	 * List all the bank accounts with their owners' names
	 */
	public void listAccountsWithCustomers() {
		System.out.println("List accounts with their customer details\n");
		for (Account a : accounts) {
			System.out.printf ("%-75s - %-20.20s\n", a, a.customer.name);
		}
	}

	/*
	 * Audit the bank accounts and for any accounts which are either current accounts of
	 * personal banking customers or any accounts of business banking customers, show the details
	 * If they have a negative balance, have had more than 1,000 applied in interest, or have no tax cert if 
	 * a business customer's account
	 */
	public void auditAccounts() {
		System.out.println("Audit the database\n");

		System.out.println("Auditing accounts for negative balance");
		for (Account a : accounts) {
			if (a instanceof CurrentAccount || a.customer instanceof BusinessCustomer) {
				// Check for negative balance
				if (a.balance < 0) {
					System.out.println ("Balance < 0: " + a.customer);
				}
			}
		}
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Auditing business customers for no tax clearance certificate");
		for (Account a : accounts) {
			if (a.customer instanceof BusinessCustomer) {
				// Check for business customer with no tax clearance certificate
				if (a.customer instanceof BusinessCustomer) {
					BusinessCustomer bc = (BusinessCustomer)a.customer;
					if (bc.hasTaxCert == false) System.out.println (a + " " + bc);
				}
			}
		}
		System.out.println("------------------------------------------------------------------------\n");

		System.out.println("Auditing deposit accounts for interest earned > 1,000");
		for (Account a : accounts) {
			if (a instanceof DepositAccount && a.customer instanceof BusinessCustomer) {
				double totalInterest = 0;
				for (Transaction t : a.transactions) {
					if (t.description.equals("Deposit interest")) {
						totalInterest += t.amount;
					}
				}
				if (totalInterest > 1000) {
					System.out.printf ("% 9.2f total interest. A/c %08d, %-70s\n", totalInterest, a.accountNumber, a.customer);
				}
			}
		}
		System.out.println("------------------------------------------------------------------------\n");
	}

}
