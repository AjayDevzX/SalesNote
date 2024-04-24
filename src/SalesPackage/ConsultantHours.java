package SalesPackage;

import org.joda.money.Money;

public class ConsultantHours extends Saleable{
	
	   int hours;
	   Money amountPerHour;
	  
	public ConsultantHours(int hours, Money amountPerHour) {
		super();
		this.hours = hours;
		this.amountPerHour = amountPerHour;
	}
	
	@Override
    public Money getAmount() {
        return amountPerHour.multipliedBy(hours);
    }
}
