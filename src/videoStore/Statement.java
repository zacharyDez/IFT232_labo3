package videoStore;

import java.util.Vector;

public abstract class Statement {
    Customer customer;
    double totalAmount;
    int frequentRenterPoints;

    public Statement(Customer c) {
        customer = c;
        totalAmount = customer.getTotalAmount();
        frequentRenterPoints = customer.getFrequentRenterPoints();
    }

    abstract String printHeader();

    abstract String printRentalLine(Rental rental);

    abstract String printFooter();

    public String print() {


        String result = printHeader();

        for (Rental each : customer.rentals) {
            result += printRentalLine(each);
        }

        result += printFooter();

        return result;
    }

}
