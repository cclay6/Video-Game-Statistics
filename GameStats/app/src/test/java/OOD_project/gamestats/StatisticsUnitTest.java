package OOD_project.gamestats;

import org.junit.Assert;
import org.junit.Test;

public class StatisticsUnitTest {
    /**
     * Tests averageMainlength()
     */
    @Test
    public void testAverageMainLength()
    {

        System.out.println("Run test averageMainLength");

        //creates Statistics object
        Statistics statistics= new Statistics();

        //Creates a game list
        GameList gameList = new GameList();

        //Sets the names of the 3 games for testing
        String name1 = "Chrono Trigger";
        String name2 = "Metal Gear Solid";
        String name3 = "Skyrim";

        //Sets the variables of three games
        int year = 2000;
        String console = "snes";
        boolean inProgress = false;
        boolean completed = true;
        long mainLength1= 10871;
        long mainLength2= 7425;
        long mainLength3=137;
        long mainExtrasLength= 0;

        //adds games to game list
        gameList.addGame(name1, year, console, inProgress, completed,
                mainLength1, mainExtrasLength);
        gameList.addGame(name2, year, console, inProgress, completed,
                mainLength2, mainExtrasLength);
        gameList.addGame(name3, year, console, inProgress, completed,
                mainLength3, mainExtrasLength);

        //calculates the average main length
        long averageMainLength= statistics.calculateAverageMainLength(gameList);

        //calculates the expected average main length
        long answer= (mainLength1+mainLength2+mainLength3)/3;


        //create empty gamelist
        GameList gameList2= new GameList();

        //test passes if the expected value is the same as the one returned by the method
        //and if the empty list returns 0 for the same method
        Assert.assertTrue(averageMainLength==answer &&
                statistics.calculateAverageMainLength(gameList2)==0);
    }

    /**
     * Tests calculate averageMainLength()
     */
    @Test
    public void calculateAverageMainExtrasLength()
    {
        System.out.println("Run test averageMainExtrasLength");

        //creates Statistics object
        Statistics statistics= new Statistics();

        //Creates a game list
        GameList gameList = new GameList();

        //Sets the names of the 3 games for testing
        String name1 = "Chrono Trigger";
        String name2 = "Metal Gear Solid";
        String name3 = "Skyrim";

        //Sets the variables of three games
        int year = 2000;
        String console = "snes";
        boolean inProgress = false;
        boolean completed = true;
        long mainExtrasLength1= 10871;
        long mainExtrasLength2= 7425;
        long mainExtrasLength3=137;
        long mainLength= 0;

        //adds games to game list
        gameList.addGame(name1, year, console, inProgress, completed,
                mainLength, mainExtrasLength1);
        gameList.addGame(name2, year, console, inProgress, completed,
                mainLength, mainExtrasLength2);
        gameList.addGame(name3, year, console, inProgress, completed,
                mainLength, mainExtrasLength3);

        //calculates average main extras length
        long averageMainExtrasLength= statistics.calculateAverageMainExtrasLength(gameList);

        //gets the expected answer
        long answer= (mainExtrasLength1+mainExtrasLength2+mainExtrasLength3)/3;

        //create empty gamelist
        GameList gameList2= new GameList();

        //Compares the value returned by the method and the expected answer, and
        //sees if empty list returns 0
        Assert.assertTrue(averageMainExtrasLength==answer &&
                statistics.calculateAverageMainExtrasLength(gameList2)==0);
    }

    /**
     * Tests totalMainLength()
     */
    @Test
    public void testTotalMainLength()
    {
        System.out.println("Run test totalMainLength");

        //Creates Statistics object
        Statistics statistics= new Statistics();

        //Creates a game list
        GameList gameList = new GameList();

        //Sets the names of the 3 games for testing
        String name1 = "Chrono Trigger";
        String name2 = "Metal Gear Solid";
        String name3 = "Skyrim";

        //Sets the variables of three games
        int year = 2000;
        String console = "snes";
        boolean inProgress = false;
        boolean completed = true;
        long mainLength1= 10871;
        long mainLength2= 7425;
        long mainLength3=137;
        long mainExtrasLength= 0;

        //adds games to game list
        gameList.addGame(name1, year, console, inProgress, completed,
                mainLength1, mainExtrasLength);
        gameList.addGame(name2, year, console, inProgress, completed,
                mainLength2, mainExtrasLength);
        gameList.addGame(name3, year, console, inProgress, completed,
                mainLength3, mainExtrasLength);

        //calculates the total main length
        long TotalMainLength= statistics.calculateTotalMainLength(gameList);

        //calculates what the answer should be
        long answer= (mainLength1+mainLength2+mainLength3);

        //create empty gamelist
        GameList gameList2= new GameList();

        //test passes if the value returned by the method is the same as the answer
        //and that an empty list returns 0
        Assert.assertTrue(TotalMainLength==answer &&
                statistics.calculateTotalMainLength(gameList2)==0);
    }

    /**
     * Tests totalMainExtrasLength()
     */
    @Test
    public void testTotalMainExtrasLength()
    {
        System.out.println("Run test averageMainExtrasLength");

        //creates Statistics object
        Statistics statistics= new Statistics();

        //Creates a game list
        GameList gameList = new GameList();

        //Sets the names of the 3 games for testing
        String name1 = "Chrono Trigger";
        String name2 = "Metal Gear Solid";
        String name3 = "Skyrim";

        //Sets the variables of three games
        int year = 2000;
        String console = "snes";
        boolean inProgress = false;
        boolean completed = true;
        long mainExtrasLength1= 10871;
        long mainExtrasLength2= 7425;
        long mainExtrasLength3=137;
        long mainLength= 0;

        //adds games to game list
        gameList.addGame(name1, year, console, inProgress, completed,
                mainLength, mainExtrasLength1);
        gameList.addGame(name2, year, console, inProgress, completed,
                mainLength, mainExtrasLength2);
        gameList.addGame(name3, year, console, inProgress, completed,
                mainLength, mainExtrasLength3);

        //calculates total main extras length
        long TotalMainExtrasLength= statistics.calculateTotalMainExtrasLength(gameList);

        //calculates what the answer should be
        long answer= (mainExtrasLength1+mainExtrasLength2+mainExtrasLength3);

        //creates an empty gamelist
        GameList gameList2= new GameList();

        //test passes if value returned by the method matches the answer
        Assert.assertTrue(TotalMainExtrasLength==answer &&
                statistics.calculateTotalMainExtrasLength(gameList2)==0);
    }

}
