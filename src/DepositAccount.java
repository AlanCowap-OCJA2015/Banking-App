import java.util.Random;

public class DepositAccount extends Account{

	private double interestRate = 4.0;

	public DepositAccount(Customer c){
		super(c);

		if (new Random().nextInt(10) > 5) {
			transactions.add(new Transaction("Deposit interest", super.balance * (interestRate / 100)));
			super.balance += super.balance * (interestRate / 100);
		}
	}

	public String toString () {
		return "Deposit " + super.toString() + ", Interest rate: " + this.interestRate + "%";
	}

}