package players;

import java.util.Map;

public interface Player {

    Map<Integer,String> createMove(int gamesNumber,int chosenFigure);
    Map<Integer,String> getResult();
}
