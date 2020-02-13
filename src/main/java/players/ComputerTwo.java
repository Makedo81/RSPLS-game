package players;

import figures.Figure;
import java.util.HashMap;
import java.util.Map;

public class ComputerTwo implements Player {

    private Map<Integer,String> resultComputer2 = new HashMap<>();
    private RandomMoveGenerator rmg = new RandomMoveGenerator();
    public final static String COMPUTER_TWO = "Computer_Two";

    public Map<Integer, String> createMove(int game, int pickedFigure) {
        int figureNumber = rmg.randomMove();
        Figure figure = rmg.getFigure(figureNumber);
        resultComputer2.put(game,figure.getFigureName(figureNumber));
        return resultComputer2;
    }

    @Override
    public Map<Integer, String> getResult() {
        return resultComputer2;
    }
}
