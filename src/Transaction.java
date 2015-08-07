public class Transaction implements java.io.Serializable {
	
	String description;
	double amount;
	static int currentSequence;
	int sequence;

	public Transaction(String description, double amount){

		this.description = description;
		this.amount = amount;
		this.sequence = currentSequence++;
	}

	public String toString() {
		return String.format ("%50s Amt: % 10.2f Seq: %6d", this.description, this.amount, this.sequence);
	}

	public String exportData() {
		return this.description + "\t" + this.amount + "\t" + this.sequence;
	}

}