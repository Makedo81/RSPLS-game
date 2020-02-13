package game;

public class WinningChanceCalculator {

    public int countChance( int gamesNumber) {
        return gamesNumber/4;
    }

    private int countPlayerChance(int gamesNumber) {
        return gamesNumber/2;
    }

    public int calculateDrawChance(int gamesNumber) {
        return  gamesNumber-countPlayerChance(gamesNumber)-countChance(gamesNumber);
    }
}
