package players;

import figures.Figure;
import figures.FiguresPicker;
import java.util.Random;

public class RandomMoveGenerator {

    private FiguresPicker figuresPicker = new FiguresPicker();

    public int randomMove() {
        Random computerMove = new Random();
        int figureNumber = computerMove.nextInt(6);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return figureNumber;
    }

    public Figure getFigure(int figureNumber){
        Figure figure = figuresPicker.pickFigure(figureNumber);
        if(figureNumber==0){
            figure = figuresPicker.pickFigure(figureNumber+1);
        }
        if(figureNumber==6) {
            figure = figuresPicker.pickFigure(figureNumber - 1);
        }
        return figure;
    }
}
