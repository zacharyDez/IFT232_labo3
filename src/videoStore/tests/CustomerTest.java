package videoStore.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import videoStore.Customer;
import videoStore.Movie;
import videoStore.Rental;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private double delta = 0.01;
    private Customer grandmaman;

    @Before
    public void setup() {
        Movie movies[] = new Movie[5];

        movies[0] = new Movie("Caillou a le cancer", Movie.CHILDRENS);
        movies[1] = new Movie("Fast and furious 38: Diesel Cars vs Google Cars", Movie.NEW_RELEASE);
        movies[2] = new Movie("31 Jump Street: Ninja Academy", Movie.NEW_RELEASE);
        movies[3] = new Movie("Les oiseaux se cachent pour mourir", Movie.REGULAR);
        movies[4] = new Movie("Les gars chauds se cachent pour vomir", Movie.REGULAR);

        grandmaman = new Customer("Grand-môman");

        grandmaman.addRentals(new Rental(movies[0], 4));
        grandmaman.addRentals(new Rental(movies[1], 1));
        grandmaman.addRentals(new Rental(movies[2], 2));
        grandmaman.addRentals(new Rental(movies[3], 7));
        grandmaman.addRentals(new Rental(movies[4], 1));
    }

    @Test
    public void testGetTotalAmount() {
        assertEquals(23.5, grandmaman.getTotalAmount(), delta);
    }

    @Test
    public void testGetTotalFrequentRenterPoints() {
        assertEquals(7, grandmaman.getFrequentRenterPoints());
    }

    @Test
    public void testGetRentalMessage() {
        String expected = "";
        expected += "\tCaillou a le cancer\t3.0\n";
        expected += "\tFast and furious 38: Diesel Cars vs Google Cars\t3.0\n";
        expected += "\t31 Jump Street: Ninja Academy\t6.0\n";
        expected += "\tLes oiseaux se cachent pour mourir\t9.5\n";
        expected += "\tLes gars chauds se cachent pour vomir\t2.0\n";
        assertEquals(grandmaman.getRentalMessage(), expected);
    }

    @Test
    public void testWholeTextStatement() {

        String expected = "Rental Record for Grand-môman\n";
        expected += "\tCaillou a le cancer\t3.0\n";
        expected += "\tFast and furious 38: Diesel Cars vs Google Cars\t3.0\n";
        expected += "\t31 Jump Street: Ninja Academy\t6.0\n";
        expected += "\tLes oiseaux se cachent pour mourir\t9.5\n";
        expected += "\tLes gars chauds se cachent pour vomir\t2.0\n";
        expected += "Amount owed is 23.5\n";
        expected += "You earned 7 frequent renter points\n";
        assertEquals(grandmaman.statement(), expected);

    }

    @After
    public void teardown() {
        grandmaman = null;
    }

}
