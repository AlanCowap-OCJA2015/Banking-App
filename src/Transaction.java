public class Transaction{
	
	private String description;
	private double amount;
	private static int currentSequence;
	private int sequence;

	public Transaction(String description, double amount){

		this.description = description;
		this.amount = amount;
		this.sequence = currentSequence++;
	}

}