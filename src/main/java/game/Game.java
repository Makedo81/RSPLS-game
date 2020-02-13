package game;

import players.ComputerOne;
import players.ComputerTwo;
import players.HumanPlayer;
import players.Player;
import java.util.*;

public class Game {

    private Results results = new Results();
    private WinnerPicker winnerPicker = new WinnerPicker();
    private WinningChanceCalculator winningChanceCalculator = new WinningChanceCalculator();
    private Player computerOne = new ComputerOne();
    private Player computerTwo = new ComputerTwo();
    private Player humanPlayer = new HumanPlayer();
    private Map<Integer, String> mapResult = new HashMap<>();

    public Map<Integer, String> getMapResult() {
        return mapResult;
    }

    public void gameResult(int figureNumber, int gameNumber, String player, int winningGames) {
        Map<Integer, List<String>> map = new HashMap<>();
        if (setDrawLimits(winningGames)) {
            humanPlayer.createMove(gameNumber, figureNumber);
            do {
                computerOne.createMove(gameNumber, figureNumber);
                computerTwo.createMove(gameNumber, figureNumber);
                map.put(gameNumber,createFiguresList(gameNumber,figureNumber));
            } while (generateResult(createFiguresList(gameNumber,figureNumber),player).equals("DRAW"));
            showResult(figureNumber, gameNumber, player);
        } else if (!setDrawLimits(winningGames)) {
            humanPlayer.createMove(gameNumber, figureNumber);
            computerOne.createMove(gameNumber, figureNumber);
            computerTwo.createMove(gameNumber, figureNumber);
            map.put( gameNumber,createFiguresList(gameNumber,figureNumber));
            showResult(figureNumber, gameNumber, player);
        }
    }

        public List<String> createFiguresList(int gameNumber, int number) {
        String valuePlayer = humanPlayer.createMove(gameNumber,number).get(gameNumber);
        String valueComputer = computerOne.getResult().get(gameNumber);
        String valueComputer2 = computerTwo.getResult().get(gameNumber);
        List<String> list = new ArrayList<>();
        list.add(valuePlayer);
        list.add(valueComputer);
        list.add(valueComputer2);
        return list;
    }

    private String generateResult(List<String> list, String player) {
        String result = results.checkResults(list.get(0),list.get(1),list.get(2),player);
        return result;
    }

    private void showResult(int figureNumber, int gameNumber, String player){
        String valuePlayer = humanPlayer.createMove(gameNumber,figureNumber).get(gameNumber);
        String valueComputer = computerOne.getResult().get(gameNumber);
        String valueComputer2 = computerTwo.getResult().get(gameNumber);

        String result = generateResult(createFiguresList(gameNumber,figureNumber),player);
        mapResult.put(gameNumber,result);
        System.out.println(("\n" + "                               " + gameNumber + " )  " + player +
                " " + valuePlayer + " : " +
                ComputerOne.COMPUTER_ONE + " "+ valueComputer + " : " + ComputerTwo.COMPUTER_TWO + " "+ valueComputer2)+          "\n"
                + "                                           WINNER : " + result+
                "\n"
                + "                                Computer1 winning games : " + winnerPicker.countComputerWinningGames(getMapResult())+
                "  Your winning games : " + winnerPicker.countPersonWinningGames(player,getMapResult())+
                "  Computer2 winning games : " + winnerPicker.countComputer2WinningGames(getMapResult()));
    }

    private boolean setDrawLimits(int winningGames){
        if(winnerPicker.countDraw(getMapResult()) >= winningChanceCalculator.calculateDrawChance(winningGames)){
            return true;
        }else
            return false;
    }

    public void clearAllResults(){
        mapResult.clear();
    }

    public boolean setGameLimits(int turnsNumber, String player) {
        if (winnerPicker.countComputerWinningGames(getMapResult()) == turnsNumber ||
                winnerPicker.countPersonWinningGames(player,getMapResult()) == turnsNumber ||
                winnerPicker.countComputer2WinningGames(getMapResult()) == turnsNumber) {
            return  true;
        } else return false;
    }

    public void showScores(String player, int gamesNumber) {
        System.out.println("\n" + " ************ Scores *********** ");
        System.out.println(" Games number in total :  " + gamesNumber);
        System.out.println(" Player :  " + player.toUpperCase() + " " + winnerPicker.countPersonWinningGames(player, mapResult) + " of " + gamesNumber + " games won");
        System.out.println(" " + "COMPUTER1 :  " + winnerPicker.countComputerWinningGames(mapResult) + " of " + gamesNumber + " games won");
        System.out.println(" " + "COMPUTER2 :  " + winnerPicker.countComputer2WinningGames(mapResult) + " of " + gamesNumber + " games won");
    }

    public void showAllResult(String player){
        Set keys = mapResult.keySet();
        for (Object o : keys) {
            Integer key = (Integer) o;
            String valuePlayer = humanPlayer.getResult().get(key);
            String valueComputer = computerOne.getResult().get(key);
            String valueComputer2 = computerTwo.getResult().get(key);
            String result = results.checkResults(valuePlayer,valueComputer,valueComputer2,player);
            System.out.println(("\n" + "                               " + key + ") " + player + " " + valuePlayer + " : " +
                    " Computer " +
                    valueComputer + " : " + " Computer2 " + valueComputer2));
            System.out.println("\n" + "                                WINNER : " + result);
        }
        System.out.println("\n" + "                                ************** GAME WINNER IS : " +
                winnerPicker.chooseWinner(player,getMapResult()).toUpperCase()+ " *****************");
    }
}

