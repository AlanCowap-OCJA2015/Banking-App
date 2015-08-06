import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class BankApp {

	Scanner scan = new Scanner(System.in);

	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Account> accounts = new ArrayList<Account>();


	public static void main (String[] args) {
		new BankApp().runApp();
	}

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

	public int showMainMenu() {

		System.out.println("Welcome to the bank app");
		System.out.println("");
		System.out.println("Please enter the number for the option you want and press ENTER");
		System.out.println("");
		System.out.println("0.  Exit Program");
		System.out.println("1.  List customer database with their accounts");
		System.out.println("2.  List accounts database with their customers");
		System.out.println("3.  Audit the database");
		System.out.println("");

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

	public void initialiseData() {
		System.out.println("Initialising customer and account records\n");

		// Create the customer database
		for (int i = 0; i < 100; ++i) {
			customers.add(new PersonalCustomer());
			customers.add(new BusinessCustomer());
		}

		CurrentAccount cAccount;
		DepositAccount dAccount;

		// Create accounts for each customer
		for (Customer c : customers) {

			switch (new Random().nextInt(3)) {

				case 0:
					cAccount = new CurrentAccount(c);
					accounts.add(cAccount);
					break;

				case 1:
					dAccount = new DepositAccount(c);
					accounts.add(dAccount);
					break;

				case 2:
					cAccount = new CurrentAccount(c);
					accounts.add(cAccount);
					dAccount = new DepositAccount(c);
					accounts.add(dAccount);
					break;

			}

		}


	}

	public void listCustomersWithAccounts() {
		System.out.println("List customers with their account details\n");
	}

	public void listAccountsWithCustomers() {
		System.out.println("List accounts with their customer details\n");
	}

	public void auditAccounts() {
		System.out.println("Audit the database\n");
	}

}
