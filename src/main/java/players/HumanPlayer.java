package players;

import figures.Figure;
import figures.FiguresPicker;
import java.util.HashMap;
import java.util.Map;

public class HumanPlayer implements Player{

    private Map<Integer,String> resultPlayer = new HashMap<>();
    private FiguresPicker figuresPicker = new FiguresPicker();

    @Override
    public Map<Integer,String> createMove(int game,int pickedFigure){
        Figure figure = figuresPicker.pickFigure(pickedFigure);
        resultPlayer.put(game,figure.getFigureName(pickedFigure));
        return resultPlayer;
    }

    @Override
    public Map<Integer, String> getResult() {
        return resultPlayer;
    }
}
