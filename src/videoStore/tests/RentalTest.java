package videoStore.tests;

import org.junit.Before;
import org.junit.Test;
import videoStore.Movie;
import videoStore.Rental;

import static org.junit.Assert.*;

public class RentalTest {

    private double delta = 0.01;
    private Movie kidMovie = new Movie("Caillou a le cancer", Movie.CHILDRENS);
    private Movie newMovie = new Movie("Fast and furious 38: Diesel Cars vs Google Cars", Movie.NEW_RELEASE);
    private Movie regMovie = new Movie("Les oiseaux se cachent pour mourir", Movie.REGULAR);

    private Rental kidRental = new Rental(kidMovie, 5);
    private Rental newRental = new Rental(newMovie, 5);
    private Rental regRental = new Rental(regMovie, 5);

    @Before
    public void setup() {

    }

    /*
        Test Frequent Renter points
     */
    @Test
    public void kidRentalGetFrequentRenterPoints() {
        assertEquals(1, kidRental.getFrequentRenterPoints());
    }

    @Test
    public void newRentalGetFrequentRenterPoints() {
        assertEquals(2, newRental.getFrequentRenterPoints());
    }

    @Test
    public void regRentalGetFrequentRenterPoints() {
        assertEquals(1, regRental.getFrequentRenterPoints());
    }


    /*
        Test Rental Get Price
     */
    @Test
    public void RegRentalGetPrice5Days() {
        double expAmount = 2 + (regRental.getDaysRented()-2) * 1.5;
        assertEquals(expAmount, regRental.getRentalPrice(), delta);
    }

    @Test
    public void RegRentalGetPrice2Days() {
        double expAmount = 2;
        regRental.setDaysRented(2);
        assertEquals(expAmount, regRental.getRentalPrice(), delta);
    }

    @Test
    public void newRentalGetPrice5Days() {
        double expAmount = 3*newRental.getDaysRented();
        assertEquals(expAmount, newRental.getRentalPrice(), delta);
    }

    @Test
    public void newRentalGetPrice1Day() {
        newRental.setDaysRented(1);
        double expAmount = 3;
        assertEquals(expAmount, newRental.getRentalPrice(), delta);
    }

    @Test
    public void kidRentalGetPrice5Days() {
        double expAmount = 1.5+ (kidRental.getDaysRented()-3)*1.5;
        assertEquals(expAmount, kidRental.getRentalPrice(), delta);
    }

    @Test
    public void kidRentalGetPrice3Days() {
        kidRental.setDaysRented(3);
        double expAmount = 1.5;
        assertEquals(expAmount, kidRental.getRentalPrice(), delta);
    }

}