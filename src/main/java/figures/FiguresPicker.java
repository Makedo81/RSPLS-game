package figures;

public class FiguresPicker {

    public Figure pickFigure(int number){
        switch(number) {
            case 1:
                return new Paper();

            case 2:
                return new Rock ();

            case 3:
                return new Scissors ();

            case 4:
                return new Lizard ();

            case 5:
                return new Spock ();
            default:return null;
        }
    }
}

