import java.util.*;

public class Game {
    private Player player;
    private int score;
    private int round;
    private List<Card> playerHand;
    private List<Card> computerCard;
    private CardDeck cardDeck;
    private Map<Character, Integer> letterToIndexMap;
    private Map<Character, Integer> userInputMap;
    private List<GameRecord> gameRecords;
    private List<Card> playersCardsInARound;



    public Game(CardDeck cardDeck) {
        // Initialize the game with a player and a deck
        this.cardDeck = cardDeck;
        this.player = new Player();
        this.score = 0;
        this.round = 1;
        letterToIndexMap = new HashMap<>();
        letterToIndexMap.put('A', 0);
        letterToIndexMap.put('B', 1);
        letterToIndexMap.put('C', 2);
        letterToIndexMap.put('D', 3);
        letterToIndexMap.put('E', 4);
        userInputMap = new HashMap<>();
        userInputMap.put('Y', 0);
        userInputMap.put('N', 1);
        this.gameRecords = new ArrayList<>();
        this.playersCardsInARound = new ArrayList<>();
    }

    public void startGame() {
        // Start the game by dealing initial cards, etc.
        printWelcome();
        this.player.setHand(this.cardDeck.deal(5));
    }

    public boolean playRound() {
        // Play a round of the game
        playersCardsInARound.clear();
        List<Card> playersHandAtStartOfRound;
        playersHandAtStartOfRound = player.getHand();
        boolean pointScored = false;
        Scanner scanner = new Scanner(System.in);
        round++;
        Card computerCard = this.computerCard.get(0);
        System.out.println("Enter your selection: ");
        char userInput = scanner.next().toUpperCase().charAt(0);


        int selectedCardIndex = letterToIndexMap.getOrDefault(userInput, -1);
        while(selectedCardIndex == -1){
            System.out.println("Enter your selection: ");
            userInput = scanner.next().toUpperCase().charAt(0);
            selectedCardIndex = letterToIndexMap.getOrDefault(userInput, -1);
        }

            Card cardPlayed = playersHandAtStartOfRound.get(selectedCardIndex);
            System.out.println("You selected " + cardPlayed.toString());
            playersCardsInARound.add(cardPlayed);

            if (player.isEleven(cardPlayed, computerCard)) {
                pointScored = true;
                score++;
                System.out.println("You made 11!!!!");

                //this if statement catches exception if card deck is empty
                if(player.playCard(cardPlayed, cardDeck)) {
                    if (player.hasPictureCard()) {
                        System.out.println("Would you like to play any picture cards? (y/n): ");
                        char playPictureCards = scanner.next().toUpperCase().charAt(0);
                        int validInput = userInputMap.getOrDefault(playPictureCards, -1);
                        while (validInput==-1){
                            System.out.println("Would you like to play any picture cards? (y/n): ");
                            playPictureCards = scanner.next().toUpperCase().charAt(0);
                            validInput = userInputMap.getOrDefault(playPictureCards, -1);
                        }
                        if (validInput==0) {
                            swapPictureCards();
                        }
                    }
                    gameRecords.add(new GameRecord(player.getHand(), computerCard, playersCardsInARound, pointScored));
                    return true;
                }
                else{
                    return false;
                }
            } else if (computerCard.getSuit().equals(cardPlayed.getSuit())) {
                System.out.println("Same suit! Game continues, but no point scored.");
                player.playCard(cardPlayed, cardDeck);
                gameRecords.add(new GameRecord(player.getHand(), computerCard, playersCardsInARound, pointScored));
                return true;
            } else {
                System.out.println("Game over.");
                gameRecords.add(new GameRecord(player.getHand(), computerCard, playersCardsInARound, pointScored));
                printGameRecord();
                return false;
            }

    }


    public void swapPictureCards(){
        for (int i = playerHand.size() - 2; i >= 0; i--) {
            Card playerCard = playerHand.get(i);
            if (isPictureCard(playerCard)){
                playersCardsInARound.add(playerCard);
                playerHand.remove(playerCard);
                playerHand.add(cardDeck.deal(1).get(0));
            }
        }
    }

    public int getScore() {
        return score;
    }



    private boolean isPictureCard(Card card) {
        String rank = card.getValue();
        return rank.equals("Jack") || rank.equals("Queen") || rank.equals("King");
    }

    public void printWelcome(){
        String divider = "-".repeat(25);
        System.out.println(divider);
        System.out.println("---WELCOME TO MAKE 11---");
        System.out.println(divider);
    }


    public void gamePlayText(){
        this.computerCard = cardDeck.deal(1);
        this.playerHand = player.getHand();
        System.out.println("\nRound " + getRound());
        System.out.println("Can you make it up to 11?");
        System.out.println("Computer's card: " + computerCard.get(0).toString());
        System.out.println("Please choose a card:");
        for (char letter : letterToIndexMap.keySet()) {
            int index = letterToIndexMap.get(letter);
            System.out.println(letter + ": " + player.getHand().get(index).toString());
        }
    }

    private int getRound() {
        return this.round;
    }

    public void printGameRecord() {
        int recordRound = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Would you like to see a replay (Y/N): ");
        char choice = scan.next().toUpperCase().charAt(0);
        int validUserInput = userInputMap.getOrDefault(choice, -1);
        while (validUserInput==-1){
            System.out.println("Would you like to see a replay? (Y/N): ");
            choice = scan.next().toUpperCase().charAt(0);
            validUserInput = userInputMap.getOrDefault(choice, -1);
        }

        if (validUserInput==0) {
            for (GameRecord record:gameRecords){
                recordRound++;
                record.printRecord(recordRound);
            }
        }
    }

}
