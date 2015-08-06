import java.util.Random;
public class Customer{

	public String name;
	public String address;
	public String phoneNumber;
	
	public  Customer(){

		randomGenerator();
	
	}

	public Customer(String name, String address, String phoneNumber){
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public void randomGenerator(){

		Random r = new Random();
		this.name= "John Smith"+r.nextInt(10000);
		this.address=r.nextInt(1000)+"Greenhills Road Dublin12";
		this.phoneNumber="0145"+(r.nextInt(90000)+10000);
	}
		
}
