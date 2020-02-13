package game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final static String  SCISSORS = "SCISSORS";
    private final static String  PAPER = "PAPER";
    private final static String  ROCK = "ROCK";
    private final static String  DRAW = "DRAW";
    private final static String  LIZARD = "LIZARD";
    private final static String  SPOCK = "SPOCK";
    private final static String COMPUTER_TWO = "Computer_Two";
    private final static String COMPUTER_ONE = "Computer_one";
    private String result = "";

    public String getWinnerFigure(String figureOne, String figureTwo){
        String winner = "";
        switch(figureOne){
            case PAPER:{
                switch(figureTwo){
                    case SPOCK:
                    case ROCK:
                        winner = PAPER;
                            return winner;
                    case SCISSORS:
                        winner = SCISSORS;
                           return winner;
                    case LIZARD:
                        winner = LIZARD;
                            return winner;
                }
            }break;
            case LIZARD:{
                switch(figureTwo){
                    case PAPER:
                    case SPOCK:
                        winner = LIZARD;
                            return winner;
                    case SCISSORS:
                        winner = SCISSORS;
                            return winner;
                    case ROCK:
                        winner = ROCK;
                            return winner;
                    }
                }break;
            case SCISSORS:{
                switch(figureTwo){
                    case ROCK:
                        winner = ROCK;
                            return winner;
                    case PAPER:
                    case LIZARD:
                    case SPOCK:
                        winner= SCISSORS;
                             return winner;
                }
            }break;
            case ROCK:{
                switch(figureTwo){
                    case PAPER:
                        winner = PAPER;
                            return winner;
                    case SCISSORS:
                    case LIZARD:
                        winner = ROCK;
                            return winner;
                    case SPOCK:
                        winner = SPOCK;
                            return winner;
                }
            }break;
            case SPOCK:{
                switch(figureTwo){
                    case PAPER:
                        winner = PAPER;
                            return winner;
                    case SCISSORS:
                        winner = SCISSORS;
                            return winner;
                    case LIZARD:
                        winner = LIZARD;
                           return winner;
                    case ROCK:
                        winner = SPOCK;
                           return winner;
                }
            }break;
        }
        if(figureOne.equals(figureTwo)){
            winner = figureOne;
        }
        return  winner;
    }

    public String pickWinner(String figureOne, String figureTwo){
        String winner2;
        if(figureOne.equals(figureTwo)){
            winner2 = DRAW;
        }else{
            winner2 = getWinnerFigure(figureOne, figureTwo);
        }
        return winner2;
    }

    public String checkResults(String valuePlayer, String valueComputer, String valueComputer2,String player){

        List<String> winnersList = new ArrayList<>();
        String winner1 = getWinnerFigure(valuePlayer, valueComputer);
        winnersList.add(winner1);
        String winner2 = getWinnerFigure(valuePlayer,valueComputer2);
        winnersList.add(winner2);
        String winner3 = getWinnerFigure(valueComputer2,valueComputer);
        winnersList.add(winner3);

        List<String> listDistinct = winnersList.stream().distinct().collect(Collectors.toList());
        String resultFinal = calculateFinalResult(listDistinct);

        if(resultFinal.equals(valueComputer)&& resultFinal.equals(valuePlayer) ||
                resultFinal.equals(valueComputer)&& resultFinal.equals(valueComputer2)||
                resultFinal.equals(DRAW) ||
                resultFinal.equals(valuePlayer)&& resultFinal.equals(valueComputer2)){
            result = DRAW;
        }
        if (resultFinal.equals(valuePlayer) && !resultFinal.equals(valueComputer2) && !resultFinal.equals(valueComputer)) {
            result = player;
        }
        if (resultFinal.equals(valueComputer) && !resultFinal.equals(valueComputer2) && !resultFinal.equals(valuePlayer)){
            result = COMPUTER_ONE ;
        }
        if (resultFinal.equals(valueComputer2) && !resultFinal.equals(valueComputer) && !resultFinal.equals(valuePlayer)) {
            result = COMPUTER_TWO;
        }return  result;
    }

    public String calculateFinalResult(List<String> figuresList){
        String resultFinal = "";
        if(figuresList.size()==3){
            resultFinal =DRAW;
        }
        if(figuresList.size()==2){
            resultFinal = pickWinner(figuresList.get(0),figuresList.get(1));
        }
        if(figuresList.size()==1){
            resultFinal =DRAW;
        }
        return resultFinal;
    }
}
