import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    void testMakeCard() {
        Card card = new Card("Clubs", "King", 10);

        assertEquals("Clubs", card.getSuit());
        assertEquals("King", card.getValue());
        assertEquals(10, card.getNumber());
    }

    @Test
    void testToString() {
        Card card = new Card("Spades", "Jack", 10);

        assertEquals("Jack of Spades", card.toString());
    }

    @Test
    void testCompareCardNumber() {
        Card cardOne = new Card("Hearts", "Five", 5);
        Card cardTwo = new Card("Diamonds", "Ten", 10);

        assertTrue(cardOne.getNumber() < cardTwo.getNumber());
    }
}