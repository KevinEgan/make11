import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @Test
    void testCreateDeck() {
        CardDeck cardDeck = new CardDeck();
        int deckOfCards = 52;

        assertEquals(deckOfCards, cardDeck.getSize());
    }

    @Test
    void testDeckShuffle() {
        CardDeck cardDeckOne = new CardDeck();
        CardDeck cardDeckTwo = new CardDeck();
        assertFalse(Arrays.equals(cardDeckOne.getDeck().toArray(), cardDeckTwo.getDeck().toArray()));
    }

    @Test
    void testDeal() {
        CardDeck cardDeck = new CardDeck();
        int deckOfCards = 52;
        int dealNumOfCards = 5;
        List<Card> dealtCards = cardDeck.deal(dealNumOfCards);

        assertEquals(dealNumOfCards, dealtCards.size());
        assertEquals(deckOfCards - dealNumOfCards, cardDeck.getSize());
    }

    @Test
    void testEmptyDeckDeal() {
        CardDeck cardDeck = new CardDeck();
        int deckOfCards = 52;

        cardDeck.deal(deckOfCards);
        assertTrue(cardDeck.isEmpty());

        List<Card> dealtCards = cardDeck.deal(1);
        assertTrue(dealtCards.isEmpty());
    }

    @Test
    void testIsEmpty() {
        CardDeck cardDeck = new CardDeck();
        assertFalse(cardDeck.isEmpty());

        int deckSize = cardDeck.getSize();
        cardDeck.deal(deckSize);
        assertTrue(cardDeck.isEmpty());
    }
}