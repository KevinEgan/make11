import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private List<Card> deck;


    public CardDeck() {
        this.deck = new ArrayList<>();
        String[] values = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};

        for (int i = 0; i < 13; i++){
            for (int j =0; j< 4; j++) {

                //had to put this here to avoid 'cannot recognise symbol card' error
                Card card;

                if (i < 10) {
                    card = new Card(suits[j], values[i], i + 1);
                }else {
                    card = new Card(suits[j], values[i], 10);
                }

                this.deck.add(card);

            }

        }
        Collections.shuffle(this.deck);
    }



    public List<Card> deal(int numOfCards){
        //need to check for error when number of cards required is greater than the number of cards in the deck
        List<Card> newCards = new ArrayList<>();
        for (int i = 0; i < numOfCards; i++){
        if (this.deck.size() > 0) {
            Card newCard = this.deck.get(0);
            this.deck.remove(0);
            newCards.add(newCard);
        }
        }
        return newCards;
    }

    @Override
    public String toString() {
        return "CardDeck{" +
                "deck=" + deck +
                '}';
    }

    public boolean isEmpty(){
        return this.deck.isEmpty();
    }

    public int getSize(){
        return this.deck.size();
    }

    public List<Card> getDeck(){
        return this.deck;
    }
}
