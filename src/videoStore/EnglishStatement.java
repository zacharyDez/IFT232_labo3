package videoStore;

public class EnglishStatement extends Statement {

    public EnglishStatement(Customer c) {
        super(c);
    }

    @Override
    protected String printHeader() {
        return "Rental Record for " + customer.getName() + "\n";
    }

    @Override
    protected String printRentalLine(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + rental.getRentalPrice() + "\n";
    }

    @Override
    protected String printFooter() {
        String result = "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";
        return result;
    }

}
