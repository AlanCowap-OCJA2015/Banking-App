import java.util.Random;
import java.util.ArrayList;

public abstract class Account implements Auditable{

	public int accountNumber;
	ArrayList<Transaction> transactions = new ArrayList <Transaction>();
	public double balance;
	public Customer customer;

	public Account(){
		this.populate();
	}
	
	public Account(Customer c){
		this();
		this.customer = c;
	}

	private void populate(){
		Random rnd = new Random();
		this.accountNumber = rnd.nextInt(1000000);
		this.balance = rnd.nextDouble() * 200000.0 - 100000.0;
	}

	public void audit(){
	
	}
}