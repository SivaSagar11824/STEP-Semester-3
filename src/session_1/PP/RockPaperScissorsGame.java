import java.util.Random;

public class RockPaperScissorsGame {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if (playerMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors")
                || playerMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock")
                || playerMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper")) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void playGame(String[] playerMoves) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int wins = 0;
        int losses = 0;
        int draws = 0;
        String[] computerMoves = new String[playerMoves.length];
        String[] results = new String[playerMoves.length];

        for (int i = 0; i < playerMoves.length; i++) {
            computerMoves[i] = moves[random.nextInt(3)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);
            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.printf("%-7s | %-12s | %-13s | %s%n", "Round", "Player Move", "Computer Move", "Result");
        for (int i = 0; i < playerMoves.length; i++) {
            System.out.printf("%-7d | %-12s | %-13s | %s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }
        double winPercentage = wins * 100.0 / playerMoves.length;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        playGame(playerMoves);
    }
}