package game;

import players.ComputerOne;
import players.ComputerTwo;
import java.util.Map;

public class WinnerPicker {

    public long countPersonWinningGames(String player,Map<Integer,String> resultsMap){
        return resultsMap.entrySet().stream()
                .filter(e->e.getValue().equals(player))
                .count();
    }

    public long countComputerWinningGames(Map<Integer,String> resultsMap){
        return resultsMap.entrySet().stream()
                .filter(e->e.getValue().equals(ComputerOne.COMPUTER_ONE))
                .count();
    }

    public long countComputer2WinningGames(Map<Integer,String> resultsMap){
        return resultsMap.entrySet().stream()
                .filter(e->e.getValue().equals(ComputerTwo.COMPUTER_TWO))
                .count();
    }

    public long countDraw(Map<Integer,String> resultsMap){
        return resultsMap.entrySet().stream()
                .filter(e->e.getValue().equals("DRAW"))
                .count();
    }

    public String chooseWinner(String player,Map<Integer,String> winnersMap){
        String gameWinner;
        long playersScore = countPersonWinningGames(player,winnersMap);
        long computerScores = countComputerWinningGames(winnersMap);
        long computer2Scores = countComputer2WinningGames(winnersMap);
        if(playersScore > computerScores && playersScore > computer2Scores){
            gameWinner = player;
        }else if(computer2Scores > computerScores && computer2Scores > playersScore){
            gameWinner = ComputerTwo.COMPUTER_TWO;
        }
        else gameWinner = ComputerOne.COMPUTER_ONE;
        return gameWinner;
    }
}
