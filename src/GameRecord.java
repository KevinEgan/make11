import java.util.ArrayList;
import java.util.List;

public class GameRecord {

    private List<Card> hand;
    private Card computerCard;
    private List<Card> playerCards;
    private boolean pointScored;

    public GameRecord(List<Card> hand, Card computerCard, List<Card> playerCards, boolean pointScored){
        this.hand = new ArrayList<>(hand);
        this.computerCard = computerCard;
        this.playerCards = new ArrayList<>(playerCards);
        this.pointScored = pointScored;
    }




    public void printRecord(int round) {
        String point="";
        //StringBuilder used as it was recommended to use it when adding strings together in a loop
        StringBuilder getRidOfSquareBrackets = new StringBuilder();
        StringBuilder cardsPlayerHasUsed = new StringBuilder();

        for (int i = 0; i < hand.size(); i++) {
            if (i > 0) {
                getRidOfSquareBrackets.append(", ");
            }
            getRidOfSquareBrackets.append(hand.get(i).toString());
        }

        for (int i = 0; i < playerCards.size(); i++) {
            if (i > 0) {
                cardsPlayerHasUsed.append(", ");
            }
            cardsPlayerHasUsed.append(playerCards.get(i).toString());
        }
        if(pointScored){
            point = "\nPoint scored";
        }
        System.out.println("\nRound " + round + "\nPlayer's hand: " + getRidOfSquareBrackets + "\nComputer plays: " + computerCard +"\nPlayer plays: "
                + cardsPlayerHasUsed + point);
    }
}
