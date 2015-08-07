import java.util.Random;
import java.util.ArrayList;

public abstract class Account {

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
		this.balance = (rnd.nextInt(20000000) - 10000000) / 100;
	}

	public void audit(){
	
	}

	public String toString () {
		return "A/c: " + String.format("%08d, Bal: % 10.2f", this.accountNumber, this.balance);
	}
	
}