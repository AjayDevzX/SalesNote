package SalesPackage;

import java.math.BigDecimal;

import org.joda.money.Money;

public class SalesNote extends Saleable implements Comparable<SalesNote> {
	
	public String getDescription() {
		return description;
	}


	String date,description;
	Money amount;
	
	public SalesNote(String date, String description, Money amount) {
		super();
		this.date = date;
		this.description = description;
		this.amount = amount;
	}
		
		public Money getAmount() {
	        return amount;
	    }
		
		 @Override
		    public Money tax() {
		        // Calculate tax amount (20% in Denmark)
		        BigDecimal taxRate = new BigDecimal("0.20"); // 20% tax rate
		        long scaledTaxRate = taxRate.multiply(BigDecimal.valueOf(100)).longValue(); // Convert to scaled long value
		        Money taxAmount = amount.multipliedBy(scaledTaxRate);
		        return taxAmount;
		    }
		
		 // Implementing compareTo method for chronological ordering
	    @Override
	    public int compareTo(SalesNote other) {
	        int dateComparison = this.date.compareTo(other.date);
	        if (dateComparison == 0) {
	            // If dates are the same, compare by amount
	            return this.amount.compareTo(other.amount);
	        }
	        return dateComparison;
	    }
		
	@Override
	public String toString() {
		return "SalesNote [date=" + date + ", description=" + description + ", amount=" + amount + "]";
	}
	
	
	

}
