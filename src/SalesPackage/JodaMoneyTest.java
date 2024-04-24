package SalesPackage;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class JodaMoneyTest {
    public static void main(String[] args) {
        // Create a monetary value of 10 EUR
        Money money1 = Money.of(CurrencyUnit.EUR, 10);

        // Print the monetary value
        System.out.println("Money 1: " + money1); // Money 1: EUR 10.00

        // Create another monetary value of 5 EUR
        Money money2 = Money.of(CurrencyUnit.EUR, 5);

        // Add money1 and money2
        Money total = money1.plus(money2);

        // Print the total
        System.out.println("Total: " + total); // Total: EUR 15.00

        // Subtract money2 from money1
        Money difference = money1.minus(money2);

        // Print the difference
        System.out.println("Difference: " + difference); // Difference: EUR 5.00

        // Format the monetary value
        String formatted = money1.toString(); // By default, formatted as 'EUR 10.00'
        System.out.println("Formatted: " + formatted); // Formatted: EUR 10.00
    }
}
