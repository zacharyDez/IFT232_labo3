package videoStore;

public class FrenchStatement extends Statement {

    public FrenchStatement(Customer c) {
        super(c);
    }

    @Override
    protected String printHeader() {
        return "Dossier du locataire: " + customer.getName() + "\n";
    }

    @Override
    protected String printRentalLine(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" + rental.getRentalPrice() + "\n";
    }

    @Override
    protected String printFooter() {
        String result = "Le montant dû est: " + totalAmount + "\n";
        result += "Vous avez mérité " + frequentRenterPoints + " points de locataire régulier.\n";
        return result;
    }

}
