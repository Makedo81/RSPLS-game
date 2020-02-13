package game;

public class GameRules {

    public void showGamesRules(){
        System.out.println(
                        "         button 1 - play \"paper\",\n" +
                        "         button 2 - play \"rock\",\n" +
                        "         button 3 - play \"scissors\",\n" +
                        "         button 4 - play \"lizard\",\n" +
                        "         button 5 - play \"spock\",\n" +
                        "         button x - ending game" +
                        "         button n - starting new game,\n"
                +
                                "\nScissors cut Paper,\n" +
                                "Rock destroy Scissors,\n" +
                                "Rock hurt Lizard,\n" +
                                "Spock destroy Rock,\n" +
                                "Paper wrap Rock,\n"+
                                "Lizard eat Paper,\n"+
                                "Paper prove Spock mistake,\n"
        );
    }
}

