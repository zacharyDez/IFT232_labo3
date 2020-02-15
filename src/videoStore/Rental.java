
package videoStore;

import java.util.Date;

/**
 * M. Fowler, et al., Refactoring, Improving the design of existing code,
 * Addison-Wiley, 2000. Exemple Chapitre 1
 * 
 * The class Rental is just a simple data class
 */

public class Rental {
	private int daysRented_;
	private Movie movie_;
	private Date date_;

	
	public Rental(Movie movie, Date initialDate, int daysRented) {
		movie_ = movie;
		daysRented_ = daysRented;
		//Initialise avec la date du jour
		date_ = initialDate;
	}
	
	public Rental(Movie movie, int daysRented) {
		this(movie,new Date(),daysRented);
	}

	public int getDaysRented() {
		return daysRented_;
	}

	public Movie getMovie() {
		return movie_;
	}
	
	public Date getDate() {
		return date_;
	}

    public int getFrequentRenterPoints() {
        // add frequent renter points
        int frequentRenterPoints=1;
        // add bonus for a new release rental
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

	public double getRentalPrice() {
		double thisAmount = 0;

		// determines amount for each line
		switch (getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (getDaysRented() > 2)
					thisAmount += (getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (getDaysRented() > 3)
					thisAmount += (getDaysRented() - 3) * 1.5;
				break;
		}

		return thisAmount;
	}

	public void setDaysRented(int i) {
		daysRented_ = i;
	}
}
