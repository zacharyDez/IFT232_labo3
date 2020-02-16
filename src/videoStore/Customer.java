
package videoStore;

import java.util.Vector;

/**
 * M. Fowler, et al., Refactoring, Improving the design of existing code,
 * Addison-Wiley, 2000. Exemple Chapitre 1
 * <p>
 * The Customer class represents the customer of the store.
 */

public class Customer {
    private String name;
    protected Vector<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        rentals = new Vector<Rental>();
    }

    public void addRentals(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String getRentalMessage() {
        String result = "";

        for (Rental each : rentals) {
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getRentalPrice() + "\n";
        }

        return result;
    }

    public double getTotalAmount() {
        double totalAmount = 0;

        for (Rental each : rentals) {
            double thisAmount = each.getRentalPrice();
            // show figures for this rental
            totalAmount += thisAmount;
        }

        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;

        for (Rental each : rentals) {
            // show figures for this rental
            frequentRenterPoints += each.getFrequentRenterPoints();
        }

        return frequentRenterPoints;
    }

    public String englishStatement() {
        EnglishStatement st = new EnglishStatement(this);
        return st.print();
    }

    public String frenchStatement() {
        FrenchStatement st = new FrenchStatement(this);
        return st.print();
    }

}
