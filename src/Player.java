import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player>{
    private List<Card> hand;
    private String name;
    private int score;




    //figure out a way to order the cards by increasing value,
    //then you have to use the most appropriate search
    public Player(){
        this.hand = new ArrayList<>();

    }
    //this is used to easily keep track of username & score for highscore table
    public Player(String name, int score){
        this.name = name;
        this.score =score;
    }

    public boolean playCard(Card cardPlayed, CardDeck gameDeck){
        try {
            this.hand.remove(cardPlayed);
            this.hand.add(gameDeck.deal(1).get(0));
            return true;
        }
        catch (Exception e){
            System.out.println("No more cards left! Game over!");
            return false;
        }
    }

    public boolean hasPictureCard(){
        for (Card playerCard: this.hand){
            String rank = playerCard.getValue();
        if(rank.equals("Jack") || rank.equals("Queen") || rank.equals("King")){
            return true;
        }
    }
        return false;
    }



    public boolean isEleven(Card cardPlayed, Card computer){
        return (cardPlayed.getNumber() + computer.getNumber()) == 11;
    }



    public List<Card> getHand() {
        return hand;
    }
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Player other) {
        // Compare players based on their scores
        return Integer.compare(this.score, other.score);
    }


}
