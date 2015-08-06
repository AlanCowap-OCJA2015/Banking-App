import java.util.Random;
public class PersonalCustomer extends Customer {
	
	private String dateOfBirth;
	private String ppsNumber ;

	public PersonalCustomer() {
		this.randomGenerator();
	}


	public PersonalCustomer(String name, String address, String phoneNumber, String dateOfBirth,String ppsNumber){
		super(name, address, phoneNumber);
		this.dateOfBirth= dateOfBirth;
		this.ppsNumber =ppsNumber;
	}

	public void randomGenerator(){

		Random r = new Random();
		this.dateOfBirth = "01/01/" + (1940 + r.nextInt(60));
		this.ppsNumber= (r.nextInt(90000)+10000)+"J";
	}	

}

