
package videoStore;

import java.util.Vector;

import videoStore.Rental;

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
			thisAmount += rentalGetPrice(each);
			frequentRenterPoints += getFrequentRenterPoints(each);

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points\n";
		return result;
	}

	private int getFrequentRenterPoints(Rental each) {
		int frequentRenterPoints=0;
		// add frequent renter points
		frequentRenterPoints++;
		// add bonus for a new release rental
		if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

	private double rentalGetPrice(Rental rental) {
		double thisAmount = 0;

		// determines amount for each line
		switch (rental.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (rental.getDaysRented() > 2)
					thisAmount += (rental.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += rental.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (rental.getDaysRented() > 3)
					thisAmount += (rental.getDaysRented() - 3) * 1.5;
				break;
		}

		return thisAmount;
	}
}
