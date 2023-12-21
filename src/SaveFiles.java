import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SaveFiles {


    private List<Player> playerScoreCount;
    private int score;

    public SaveFiles(int score) {
        this.playerScoreCount = new ArrayList<>();
        this.score = score;
    }



    public int getScore() {
        return score;
    }

    public void readHighScores(){
        try {
            File highscoresFile = new File("src/highscores.txt");
            Scanner fileRead = new Scanner(highscoresFile);
            while (fileRead.hasNextLine()) {
                String entry = fileRead.nextLine();
                String[] data = entry.split(":");
                String username = data[0];
                int score = Integer.parseInt(data[1]);
                //used arrays instead of hashmap to implement binary search & to allow for duplicate names to be saved
                playerScoreCount.add(new Player(username, score));
            }
            fileRead.close();
        } catch (FileNotFoundException e) {
            System.out.println("pathname failed");
        }
    }
    public void writeHighScores(){
        try {
            FileWriter highscoreWriter = new FileWriter("src/highscores.txt");

            //got this from stack overflow
            for (Player playerEntry: playerScoreCount){
                highscoreWriter.write(playerEntry.getName() + ":" + playerEntry.getScore() +"\n");
            }
            highscoreWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void insertHighScoreEntry(int userScore) {
        if (userScore >= playerScoreCount.get(4).getScore()){
            Scanner scan = new Scanner(System.in);
            System.out.println("High Score!!! Please enter your name: ");
            String username = scan.nextLine();
            Player newHighScore = new Player(username, score);
            playerScoreCount.set(4, newHighScore);

            playerScoreCount.sort(Collections.reverseOrder());
            printLeaderboard();
            writeHighScores();

            //was running into problems when trying to implement the improved bubble sort.

        }
        else{
            printLeaderboard();
        }
    }

    public void printLeaderboard(){
        System.out.println("\nLEADERBOARD\n");
        for (Player player: playerScoreCount) {
            System.out.printf("%-20s %d%n", player.getName(), player.getScore());
        }
    }
}
