public class Transaction{
	
	String description;
	double amount;
	static int currentSequence;
	int sequence;

	public Transaction(String description, double amount){

		this.description = description;
		this.amount = amount;
		this.sequence = currentSequence++;
	}

}