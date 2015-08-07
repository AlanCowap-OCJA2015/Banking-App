package com.bank ;

public class BusinessCustomer extends Customer {
	private String vat;
	private boolean taxClearanceCert ;
	public BusinessCustomer(String name , String address , String phoneNum , String vat , boolean cert){
		super(name , address , phoneNum );
		this.setVat(vat);
		this.setCert(cert);
	
	}

	public void setVat(String vat){

		this.vat=vat;
	}

	public void setCert(boolean cert){
		
		this.taxClearanceCert=cert;
	}

	public String getVat(){

		return this.vat;	
	}

	public boolean hasCert(){

		return this.taxClearanceCert;
	}

	public boolean audit(){
		if(super.audit()){
			return super.audit();
		}
		else{
			return !this.hasCert();
		}//end else if
	}//end overriden audit

	public String toString(){
		String hasCert = "has a Tax Clearance Cert";
		String noCert = "doesn't have a Tax Clearance Cert";
		return super.toString()+this.vat+ "\n" + ((this.taxClearanceCert) ? hasCert:noCert);
	}

}
