public class Main {
    public static void main(String[] args) {
        CardDeck cards = new CardDeck();
        boolean gameplay = true;

        Game play = new Game(cards);
        play.startGame();
        //main gameplay loop
        while (gameplay) {
            if (cards.isEmpty()){
                break;
            }
            play.gamePlayText();
            gameplay = play.playRound();
        }
        int score = play.getScore();
        System.out.println("Score: " + score);

        //leaderboard functionality
        SaveFiles saveHighScore = new SaveFiles(score);
        saveHighScore.readHighScores();
        saveHighScore.insertHighScoreEntry(score);


    }
}