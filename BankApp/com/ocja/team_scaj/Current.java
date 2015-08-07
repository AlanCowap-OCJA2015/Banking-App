package com.ocja.team_scaj;
import java.io.*;
class Current extends Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3446196867265813163L;
	//state
	boolean hasChequebook;
	double maxOverdraw;

	//constructor
	public Current(double balance, int accountNumber, Transaction transaction, boolean hasChequebook, double maxOverdraw){
		super(balance, accountNumber, transaction);
		this.hasChequebook = hasChequebook;
		this.maxOverdraw = maxOverdraw;
	}

	//behaviour
	//get and setHasChequebook
	public void setChequebook(boolean hasChequebook){
		this.hasChequebook = hasChequebook;
	}

	public boolean getHasChequebook(){
		return hasChequebook;
	}

	public String toString(){
		return super.toString() + "\nChequebook: " + this.hasChequebook + "\nMax Overdraw: " + this.maxOverdraw;
	}
}