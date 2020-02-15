
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
	private Vector<Rental> rentals;

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

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;

		String result = "Rental Record for " + getName() + "\n";

		for (Rental each : rentals) {
			double thisAmount = 0;

			// add rental price to total amount
			thisAmount += each.getRentalPrice();
			frequentRenterPoints += each.getFrequentRenterPoints();

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points\n";
		return result;
	}

}
