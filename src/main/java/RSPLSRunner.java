import game.Game;
import game.GameRules;
import java.util.Scanner;

public class RSPLSRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            Game game = new Game();
            GameRules gameRules = new GameRules();
            gameRules.showGamesRules();
            boolean end;
            boolean newGame;
            System.out.println("Type you name : ");
            String player = sc.next();
            do {
                int counter = 1;
                System.out.println("Type number wining turns : ");
                int turnsNumber = sc.nextInt();
                do {
                    System.out.println("\n" + "Game number: " + counter++ + ") Choose figure");
                    int number = sc.nextInt();
                    game.gameResult(number, counter - 1, player,turnsNumber);
                    end = game.setGameLimits(turnsNumber,player);
                } while (!end);
                game.showScores(player, counter - 1);
                game.showAllResult(player);
                game.clearAllResults();
                System.out.println("Do you want to finish?");

                if (sc.nextLine().equals("x")) {
                    newGame = true;
                } else newGame = false;
            } while (!sc.next().equals("x") && !newGame );
            System.out.println("Do you want to start new game?");
        } while (!sc.next().equals("x"));
    }
}
