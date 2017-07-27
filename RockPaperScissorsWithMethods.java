/**
 * Created by tso769 on 11/07/2017.
 */
import javax.swing.*;
public class RockPaperScissorsWithMethods {
        // declare a value for when we check whether user wants to start a new game
        static int startGameOption = 1;
        // declare some random value for a variable to hold response if user has selected player 1 as Human
        static int humanSelection = 5;
        // declare String player1's choice so we can use it later
        static String player1Choice = "Paper";
        // create a new array with the possible choices so we can use later
        static String[] gameChoices = {"Rock", "Paper", "Scissors"};
        // declaring variables for player scores to be 0 at the start of the game
        static int currentPlayerOneScore = 0;
        static int currentPlayerTwoScore = 0;
        public static void main(String[] args) {

            do {
                beginGame();
                Player1Selection();
                playGame(); }
            // added a do while function to rerun the whole thing if user selects new game
            while (startGameOption == 1);
        }

        static void beginGame() {
            String[] beginGameOptions = new String[]{"Exit", "New Game"};
            // create a dialog box with options using the array just above
            startGameOption = JOptionPane.showOptionDialog(null, "Hello, welcome to the 'Rock, Paper, Scissors' game", "Rock, Paper, Scissor Game",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, beginGameOptions,null);

            // where response is 0 when user clicks exit button, -1 for close x button or Esc key. In all these incidences, the game will close.
            if (startGameOption == 0 || startGameOption == -1) {
                System.exit(0);
            }
        }
        static void Player1Selection() {

                while (humanSelection == 5) {
                       /*
                       if human then gives user the options that they can select for the game.
                       Where response is 0 for Rock, 1 for Paper, 2 for Scissors and -1 for Esc key or clicking close icon
                       */
                    humanSelection = JOptionPane.showOptionDialog(null, "Please select one.", "Choices for Player 1",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                            null, gameChoices,null);
                    if (humanSelection == 0) {
                        // assign player1 value to be what user has selected, repeating for each option
                        player1Choice = "Rock";
                    } else if (humanSelection == 1) {
                        player1Choice = "Paper";
                    } else if (humanSelection == 2) {
                        player1Choice = "Scissors";
                    } else {
                        // if user clicks the close box on the player 1 choices (Rock, Paper or Scissors) dialog box then the game closes
                        System.exit(0);
                    }
                }
                /* reset these variables so that the while loops (at line 42 and line 62) will re-execute and same code is run again if
           user was to select a new game */
            humanSelection = 5;
            }

        static void playGame() {
            // since player 2 will always be computer, assign player2choice using a random generator to select a value from the gameChoices array defined above
            String player2choice = gameChoices[(int) Math.floor(Math.random() * 3)];
            // use a switch function based on player 1's choices and using multiple if statements based on the rules
            switch (player1Choice) {
                // using all the cases that player 1 can choose, here we look at when player 1 selects Rock.
                case "Rock":
                    if (player2choice == "Rock") {
                       /*
                       created dialog boxes with lots of information but adding new lines to make it more readable.
                       Also no scores to update when its a tie.
                       */
                        JOptionPane.showMessageDialog(null, "Player 1 and Player 2 selected " + player2choice + "." + "\n" + "It’s a tie!","Game results", JOptionPane.PLAIN_MESSAGE, null);
                    } else if (player2choice == "Scissors") {
                        JOptionPane.showMessageDialog(null, "Player 1 selected " + player1Choice + "." + "\n" + "Player 2 selected " + player2choice + "." + "\n" + "Rock beats Scissors, Player 1 wins!","Game results", JOptionPane.PLAIN_MESSAGE, null);
                        // updating player 1's score in this scenario
                        currentPlayerOneScore = currentPlayerOneScore + 1;
                    } else if (player2choice == "Paper") {
                        JOptionPane.showMessageDialog(null, "Player 1 selected " + player1Choice + "." + "\n" + "Player 2 selected " + player2choice + "." + "\n" + "Paper beats Rock, Player 2 wins!","Game results", JOptionPane.PLAIN_MESSAGE, null);
                        // updating player 2's score in this scenario
                        currentPlayerTwoScore = currentPlayerTwoScore + 1;
                    }
                    break;
                // repeating same checks for when player 1 has selected Paper
                case "Paper":
                    if (player2choice == "Paper") {
                        JOptionPane.showMessageDialog(null, "Player 1 and Player 2 selected " + player2choice + "." + "\n" + "It’s a tie!","Game results", JOptionPane.PLAIN_MESSAGE, null);
                    } else if (player2choice == "Rock") {
                        JOptionPane.showMessageDialog(null, "Player 1 selected " + player1Choice + "." + "\n" + "Player 2 selected " + player2choice + "." + "\n" + "Paper beats Rock, Player 1 wins!","Game results", JOptionPane.PLAIN_MESSAGE, null);
                        currentPlayerOneScore = currentPlayerOneScore + 1;
                    } else if (player2choice == "Scissors") {
                        JOptionPane.showMessageDialog(null, "Player 1 selected " + player1Choice + "." + "\n" + "Player 2 selected " + player2choice + "." + "\n" + "Scissors beats Paper, Player 2 wins!","Game results", JOptionPane.PLAIN_MESSAGE, null);
                        currentPlayerTwoScore = currentPlayerTwoScore + 1;
                    }
                    break;
                // repeating same checks for when player 1 has selected Scissors
                case "Scissors":
                    if (player2choice == "Scissors") {
                        JOptionPane.showMessageDialog(null, "Player 1 and Player 2 selected " + player2choice + "." + "\n" + "It’s a tie!","Game results", JOptionPane.PLAIN_MESSAGE, null);
                    } else if (player2choice == "Paper") {
                        JOptionPane.showMessageDialog(null, "Player 1 selected " + player1Choice + "." + "\n" + "Player 2 selected " + player2choice + "." + "\n" + "Scissors beats Paper, Player 1 wins!","Game results", JOptionPane.PLAIN_MESSAGE, null);
                        currentPlayerOneScore = currentPlayerOneScore + 1;
                    } else if (player2choice == "Rock") {
                        JOptionPane.showMessageDialog(null, "Player 1 selected " + player1Choice + "." + "\n" + "Player 2 selected " + player2choice + "." + "\n" + "Rock beats Scissors, Player 2 wins","Game results", JOptionPane.PLAIN_MESSAGE, null);
                        currentPlayerTwoScore = currentPlayerTwoScore + 1;
                    }
                    break;
            }
            // dialog box to show current scores for player 1 and player 2
            JOptionPane.showMessageDialog(null, "Player 1 Score = " + currentPlayerOneScore + ". " +"\n" + "Player 2 Score = " + currentPlayerTwoScore + ".", "Current Scores", JOptionPane.PLAIN_MESSAGE, null);
        }
}