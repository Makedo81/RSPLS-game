package figures;

public class Lizard implements Figure{

    public final static String  LIZARD = "LIZARD";

    @Override
    public String getFigureName(int number) {
        return LIZARD;
    }
}

