import java.util.Random;

public class CurrentAccount extends Account {

	private double overDraft;
	private boolean chequeBookIssued;

	public CurrentAccount(Customer c){
		super(c);
		this.chequeBookIssued = (new Random().nextInt(10) > 5);
		this.overDraft = new Random().nextInt(15) * 100;
	}

	public String toString () {
		return String.format("Current %s, O/d: % 8.2f, ChequeBk Issued: %s", super.toString(), this.overDraft, (this.chequeBookIssued ? "Y" : "N"));
	}

}