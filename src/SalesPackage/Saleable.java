package SalesPackage;

import org.joda.money.Money;

public class Saleable implements Taxable {
   
	
	private Money amount;
	
	
	public Money getAmount() {
		return amount;
	}

	@Override
	public Money tax() {
		// TODO Auto-generated method stub
		return null;
	}

}

