package players;

import figures.Figure;
import java.util.HashMap;
import java.util.Map;

public class ComputerOne implements Player {

    private Map<Integer,String> resultComputer = new HashMap<>();
    private RandomMoveGenerator rmg = new RandomMoveGenerator();
    public final static String COMPUTER_ONE = "Computer_one";

    @Override
    public Map<Integer, String> createMove(int game,int pickedFigure) {
        int figureNumber = rmg.randomMove();
        Figure figure = rmg.getFigure(figureNumber);
        resultComputer.put(game,figure.getFigureName(figureNumber));
        return resultComputer;
    }

    @Override
    public Map<Integer, String> getResult() {
        return resultComputer;
    }
}

