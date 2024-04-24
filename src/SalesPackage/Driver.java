package SalesPackage;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class Driver {

    public static void main(String[] args) {
        // Create SalesNotes
        SalesNote sn1 = new SalesNote("20/02/2024", "SalesNoteDescriptionforSN1", Money.parse("EUR 250"));
        SalesNote sn2 = new SalesNote("24/02/2024", "DescriptionSN2", Money.parse("EUR 350")); 

        // Create a SalesPerson
        SalesPerson salesPerson = new SalesPerson();
        salesPerson.setName("John Doe");
        salesPerson.setProvision(BigDecimal.valueOf(0.05)); // Example provision rate
        ArrayList<SalesNote> salesNotes = new ArrayList<>();
        salesNotes.add(sn1);
        salesNotes.add(sn2);
        salesPerson.setPersons(salesNotes);

        // Print sales associated with the salesperson
        salesPerson.printSales();
        
     // Find the sales note representing the sale of poorest value
        SalesNote poorestSale = salesPerson.poorestSale();

        // Print the sales note representing the sale of poorest value
        System.out.println("Sale of Poorest Value:");
        System.out.println(poorestSale.toString());
        
     // Calculate and print total provision for sales with description "SalesNoteDescriptionforSN1"
        BigDecimal totalProvisionForSN1 = salesPerson.totalProvision("SalesNoteDescriptionforSN1");
        System.out.println("Total Provision for SalesNoteDescriptionforSN1: " + totalProvisionForSN1);
        
     // Calculate and print tax for a sales note
        Money taxAmount = sn1.tax();
        System.out.println("Tax Amount for SalesNote1: " + taxAmount);
        
     // Create an instance of ConsultantHours
        ConsultantHours consultantHours = new ConsultantHours(10, Money.of(CurrencyUnit.EUR, 50.00));
        
        // Get the total amount for consultant hours
        Money consultantHoursAmount = consultantHours.getAmount();
        System.out.println("Total amount for consultant hours: " + consultantHoursAmount);
   
    }
}

