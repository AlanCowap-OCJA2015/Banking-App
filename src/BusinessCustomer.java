import java.util.Random;

public class BusinessCustomer extends Customer{
	
	public String vatNumber ;
	public boolean hasTaxCert;


	public BusinessCustomer () {
		super();
		super.randomGenerator();
		super.name += " Ltd";
		this.randomGenerator();
	}

	public BusinessCustomer (String name, String address, String phoneNumber, String vatNumber , boolean hasTaxCert) {
		super(name, address, phoneNumber);
		this.vatNumber = vatNumber;
		this.hasTaxCert = hasTaxCert;	
	}

	public void randomGenerator () {
		Random r = new Random();
		this.vatNumber= "IE" + (r.nextInt(90000)+10000) + "M";
		this.hasTaxCert= (r.nextInt(10) > 5);
	}

	public String toString () {
		return "Business Customer: " + super.toString() + "\n       VAT number: " + this.vatNumber + ", Tax clearance cert: " + (this.hasTaxCert ? "Y" : "N");
	}

	public String exportData() {
		return this.name + "\t" + this.address + "\t" + this.phoneNumber + "\t" + this.vatNumber + "\t" + this.hasTaxCert;
	}
}
