package SalesPackage;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class SalesPerson {
    String name;
    BigDecimal provision;
    ArrayList<SalesNote> persons;

    public SalesPerson(String name, BigDecimal provision, ArrayList<SalesNote> persons) {
        super();
        this.name = name;
        this.provision = provision;
        this.persons = persons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getProvision() {
        return provision;
    }

    public void setProvision(BigDecimal provision) {
        this.provision = provision;
    }

    public ArrayList<SalesNote> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<SalesNote> persons) {
        this.persons = persons;
    }

    public SalesPerson() {
        this.persons = new ArrayList<>();
    }

    // Method to add a sales note
    public void add(SalesNote sn) {
        persons.add(sn);
    }

    // Method to remove a sales note
    public void remove(SalesNote sn) {
        persons.remove(sn);
    }

    // Method to find the poorest sale
    public SalesNote poorestSale() {
        SalesNote poorest = null;
        for (SalesNote sn : persons) {
            if (poorest == null || sn.getAmount().isLessThan(poorest.getAmount())) {
                poorest = sn;
            }
        }
        return poorest;
    }

    // Method to find the best sale
    public SalesNote bestSale() {
        SalesNote best = null;
        for (SalesNote sn : persons) {
            if (best == null || sn.getAmount().isGreaterThan(best.getAmount())) {
                best = sn;
            }
        }
        return best;
    }

    // Method to calculate total provision
    public BigDecimal totalProvision(String description) {
       BigDecimal totalProvision = BigDecimal.ZERO; // Initialize total provision to zero
        // Iterate through each sales note
        for (SalesNote sale : persons) {
            // Check if the description matches the given parameter
            if (sale.getDescription().equals(description)) {
                // If it matches, calculate provision for this sale and add it to total provision
//                Money saleAmount = sale.getAmount().getAmount();
//                Money saleProvision = saleAmount.multipliedBy();
                totalProvision = totalProvision.add(provision.multiply(sale.getAmount().getAmount()));
            }
        }
        return totalProvision;
    }

    // Method to print all sales
    public void printSales() {
        Collections.sort(persons);
        System.out.println("Sales for " + name + ":");
        for (SalesNote sn : persons) {
            System.out.println(sn);
        }
    }
}

