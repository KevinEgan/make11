public class Card {

    private String suit;
    private String value;
    private int number;

    public Card(String suit, String value, int number){
        this.suit = suit;
        this.value = value;
        this.number = number;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    public int getNumber() {
        return number;
    }


    public String toString(){
        return getValue() + " of " + getSuit();
    }


}
