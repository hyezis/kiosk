package Model;

public class Card extends Payment {
    private String CardNumber;
    private String expiryDate;

    public Card(String CardNumber, String expiryDate) {
        this.CardNumber = CardNumber;
        this.expiryDate = expiryDate;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
