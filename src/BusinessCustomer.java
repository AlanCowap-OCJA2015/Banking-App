import java.util.Random;

public class BusinessCustomer extends Customer{
	
	public String vatNumber ;
	public boolean hasTaxCert;

	public BusinessCustomer () {

		this.randomGenerator();

	}

	public BusinessCustomer(String name, String address, String phoneNumber, String vatNumber , boolean hasTaxCert){
		super();
		this.vatNumber = vatNumber;
		this.hasTaxCert = hasTaxCert;	


	}
	public void randomGenerator(){

		Random r = new Random();
		this.vatNumber= "IE"+(r.nextInt(90000)+10000)+"M";
		this.hasTaxCert= (r.nextInt(10)>5);
	
	
		

	}
}
