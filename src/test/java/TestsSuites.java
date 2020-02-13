import figures.Figure;
import game.Results;
import game.WinnerPicker;
import org.junit.Assert;
import org.junit.Test;
import players.ComputerOne;
import players.ComputerTwo;
import players.RandomMoveGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestsSuites {

    @Test
    public void shouldPickWinnerFigure(){
        //Given
        Results results = new Results();
        String result = results.checkResults("SPOCK","SPOCK","ROCK","domi");
        List<String> list = new ArrayList<>();
        list.add("SPOCK");
        list.add("SPOCK");
        list.add("SPOCK");
        //When
        String result2 = results.calculateFinalResult(list);
        String result3 = results.pickWinner("PAPER","PAPER");
        String result4 = results.getWinnerFigure("ROCK","LIZARD");
        //Then
        Assert.assertEquals("DRAW",result2);
        Assert.assertEquals("DRAW",result3);
        Assert.assertEquals("DRAW",result);
        Assert.assertEquals("ROCK",result4);
    }

    @Test
    public void testShouldReturnDrawNumber(){
        //Given
        WinnerPicker wp = new WinnerPicker();
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1,"DRAW");
        map1.put(2,"ROCK");
        map1.put(3,"ROCK");

        Map<Integer,String> map2 = new HashMap<>();
        map2.put(1,"PAPER");
        map2.put(2,"ROCK");
        map2.put(3,"ROCK");
        //When
        long drawNumber2 = wp.countDraw(map2);
        long drawNumber1 = wp.countDraw(map1);
        //Then
        Assert.assertEquals(1,drawNumber1);
        Assert.assertEquals(0,drawNumber2);
    }

    @Test
    public void testShouldReturnNumberOfWinningGames(){
        //Given
        WinnerPicker wp = new WinnerPicker();
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1, ComputerOne.COMPUTER_ONE);
        map1.put(2,ComputerTwo.COMPUTER_TWO);
        map1.put(3,"DRAW");

        Map<Integer,String> map2 = new HashMap<>();
        map2.put(1,"DRAW");
        map2.put(2,"DRAW");
        map2.put(3,ComputerTwo.COMPUTER_TWO);
        map2.put(4,ComputerTwo.COMPUTER_TWO);
        map2.put(5,"Name");
        map2.put(6,"Name");
        map2.put(7,"Name");
        //When
        long winningGames = wp.countComputer2WinningGames(map2);
        long winningGames1 = wp.countComputer2WinningGames(map1);
        long winningGames2 = wp.countPersonWinningGames("Name",map2);
        //Then
        Assert.assertEquals(2,winningGames);
        Assert.assertEquals(1,winningGames1);
        Assert.assertEquals(3,winningGames2);
    }

    @Test
    public void testRandomMoveMethod(){
        //Given
        RandomMoveGenerator rmg = new RandomMoveGenerator();
        //When
        Figure rock = rmg.getFigure(2);
        Figure spock = rmg.getFigure(5);
        Figure lizard = rmg.getFigure(4);
        //Then
        Assert.assertEquals("ROCK",rock.getFigureName(2));
        Assert.assertEquals("SPOCK",spock.getFigureName(5));
        Assert.assertEquals("LIZARD",lizard.getFigureName(4));
    }
}
