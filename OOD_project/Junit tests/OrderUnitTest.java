package OOD_project.gamestats;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the methods of the Order class
 */
public class OrderUnitTest {
    /**
     * Tests the byMainLength method
     */
    @Test
    public void testByMainLength()
    {
        System.out.println("Run test byMainLength");

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
        long mainLength1= 300;
        long mainLength2= 100;
        long mainLength3=500;
        long mainExtrasLength= 0;

        //adds games to game list
        gameList.addGame(name1, year, console, inProgress, completed,
                mainLength1, mainExtrasLength);
        gameList.addGame(name2, year, console, inProgress, completed,
                mainLength2, mainExtrasLength);
        gameList.addGame(name3, year, console, inProgress, completed,
                mainLength3, mainExtrasLength);

        //create a new GameList to hold the sorted list
        GameList sortedGameList= new GameList();

        //create the Order object, responsible for sorting the GameList
        Order order= new Order();

        //order the game list by main length and store into sortedGameList
        sortedGameList= order.byMainLength(gameList);

        //get the index for each game
        int indexChronoTrigger= sortedGameList.searchList(name1);
        int indexMetalGearSolid= sortedGameList.searchList(name2);
        int indexSkyrim= sortedGameList.searchList(name3);


        //Test passes if the index of each game matches the expected index after
        //the sort
        Assert.assertTrue(indexChronoTrigger==1 && indexMetalGearSolid==0 &&
                indexSkyrim==2);
    }

    /**
     * Tests the byMainExtrasLength method
     */
    @Test
    public void testByMainExtrasLength()
    {
        System.out.println("Run test byMainExtrasLength");

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
        long mainExtrasLength1= 300;
        long mainExtrasLength2= 100;
        long mainExtrasLength3=500;
        long mainLength= 0;

        //adds games to game list
        gameList.addGame(name1, year, console, inProgress, completed,
                mainLength, mainExtrasLength1);
        gameList.addGame(name2, year, console, inProgress, completed,
                mainLength, mainExtrasLength2);
        gameList.addGame(name3, year, console, inProgress, completed,
                mainLength, mainExtrasLength3);

        //create a new GameList to hold the sorted list
        GameList sortedGameList= new GameList();

        //create the Order object, responsible for sorting the GameList
        Order order= new Order();

        //order the game list by mainExtrasLength and store into sortedGameList
        sortedGameList= order.byMainExtrasLength(gameList);

        //assign the position to an  index variable
        int indexChronoTrigger= sortedGameList.searchList(name1);
        int indexMetalGearSolid= sortedGameList.searchList(name2);
        int indexSkyrim= sortedGameList.searchList(name3);

        //Test passes if the index of each game matches the expected index after
        //the sort
        Assert.assertTrue(indexChronoTrigger==1 && indexMetalGearSolid==0 &&
                indexSkyrim==2);
    }
}
