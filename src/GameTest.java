/*
public class GameTest {

    private Player player;
    @Test
    public void testSwapPictureCards() {
        this.player = new Player();
        CardDeck testDeck = new CardDeck();
        testDeck.deal(5);
        Game testGame = new Game(testDeck);

        // player hand
        testGame.player.setHand(testDeck.deal(5));
        Card pictureCard = new Card("Hearts", "King", 10);
        testGame.player.getHand().set(2, pictureCard);

        // Ensure the initial player hand contains the picture card
        assertTrue(testGame.isPictureCard(testGame.player.getHand().get(2)));

        // Perform the swapPictureCards operation
        testGame.swapPictureCards();
    }
//}
*/