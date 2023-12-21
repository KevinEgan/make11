import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;
    private CardDeck cardDeck;


    @Test
    void testPlayCard() {
        player = new Player();
        cardDeck = new CardDeck();
        player.setHand(cardDeck.deal(5));

        int initialHandSize = player.getHand().size();
        Card cardPlayed = player.getHand().get(0);
        assertTrue(player.playCard(cardPlayed, cardDeck));

        assertEquals(initialHandSize - 1, player.getHand().size());
    }

    @Test
    void testNoCardsLeft() {
        player = new Player();
        cardDeck = new CardDeck();
        player.setHand(List.of());
        assertFalse(player.playCard(new Card("Hearts", "Ace", 1), cardDeck));
    }

    @Test
    void testHasPictureCard() {
        player = new Player();
        cardDeck = new CardDeck();
        player.setHand(List.of(
                new Card("Hearts", "Ace", 1),
                new Card("Hearts", "Queen", 10),
                new Card("Hearts", "Nine", 9),
                new Card("Clubs", "Two", 2),
                new Card("Clubs", "Three", 3)
        ));

        assertTrue(player.hasPictureCard());
    }

    @Test
    void testHasNoPictureCard() {
        player = new Player();
        cardDeck = new CardDeck();
        // Set up a player with no picture cards in hand
        player.setHand(List.of(
                new Card("Hearts", "Ace", 1),
                new Card("Clubs", "Eight", 8),
                new Card("Hearts", "Nine", 9),
                new Card("Clubs", "Two", 2),
                new Card("Clubs", "Three", 3)
        ));

        assertFalse(player.hasPictureCard());
    }

    @Test
    void testIsEleven() {
        player = new Player();
        cardDeck = new CardDeck();
        Card cardPlayed = new Card("Spades", "Seven", 7);
        Card computerCard = new Card("Hearts", "Four", 4);
        assertTrue(player.isEleven(cardPlayed, computerCard));
    }



}