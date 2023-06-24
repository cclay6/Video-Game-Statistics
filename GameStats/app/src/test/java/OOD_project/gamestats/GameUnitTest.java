package OOD_project.gamestats;
import org.junit.*;

import java.util.LinkedList;
import java.util.List;
import static OOD_project.gamestats.Game.getCompByMainExtrasLength;
import static OOD_project.gamestats.Game.getCompByMainLength;

/**
 * Tests the Game class
 */
public class GameUnitTest {
    /**
     * Tests getName()
     */
    @Test
    public void testGetName()
    {
        System.out.println("Run test getName");

        //create a game object
        Game game= new Game("Pokemon Red", 0000, "GB", false,
                false, 0, 0);

        //test passes if get name returns the correct name
        Assert.assertTrue(game.getName().equals("Pokemon Red"));
    }

    /**
     * Tests getYear()
     */
    @Test
    public void testGetYear()
    {
        System.out.println("Run test getYear");

        //create a game object
        Game game= new Game("Pokemon Red", 1998, "GB", false,
                false, 0, 0);

        //test passes if the correct year is returned
        Assert.assertTrue(game.getYear()==1998);
    }

    /**
     * Tests getConsole()
     */
    @Test
    public void testGetConsole()
    {
        System.out.println("Run test getConsole");

        //create a game object
        Game game= new Game("Pokemon Red", 1998, "Game Boy", false,
                false, 0, 0);

        //test passes if the right console name is returned
        Assert.assertTrue(game.getConsole().equals("Game Boy"));
    }

    /**
     * Tests getInprogress()
     */
    @Test
    public void testGetInProgress()
    {
        System.out.println("Run test getInProgress");

        //create a game object
        Game game= new Game("Pokemon Red", 1998, "Game Boy", false,
                false, 0, 0);

        //test passes if inProgress state that is returned is correct
        Assert.assertTrue(game.getInProgress()==false);
    }

    /**
     * Tests getCompleted()
     */
    @Test
    public void testGetCompleted()
    {
        System.out.println("Run test getCompleted");

        //create a game object
        Game game= new Game("Pokemon Red", 1998, "Game Boy", false,
                true, 0, 0);

        //test passes if completed state that is returned is correct
        Assert.assertTrue(game.getCompleted()==true);
    }

    /**
     * Tests getMainLength()
     */
    @Test
    public void testGetMainLength()
    {
        System.out.println("Run test getMainLength");

        //create a game object
        Game game= new Game("Pokemon Red", 1998, "Game Boy", false,
                false, 95400, 0);

        //test passes if correct main length that is returned is correct
        Assert.assertTrue(game.getMainLength()==95400);
    }

    /**
     * Tests getMainExtrasLength()
     */
    @Test
    public void testGetMainExtrasLength()
    {
        System.out.println("Run test getMainExtrasLength");

        //create a game object
        Game game= new Game("Pokemon Red", 1998, "Game Boy", false,
                true, 95400, 171000);

        //test passes if correct main extras length that is returned is correct
        Assert.assertTrue(game.getMainExtrasLength()==171000);
    }

    /**
     * Tests toString()
     */
    @Test
    public void testToString()
    {
        System.out.println("Run test toString");

        //create a game object
        Game game = new Game("Pokemon Red", 1998, "Game Boy", false,
                true, 95402, 171040);

        //create an equivalent string to the one that should be returned
        String equivalentString = "Name: " + "Pokemon Red" + "\n"
                + "Year: " + "1998" + "\n"
                + "Console: " + "Game Boy" + "\n"
                + "In progress: " + "no" + "\n"
                + "Completed: " + "yes" + "\n"
                + "Main length: " + "26h 30m 2s" + "\n"
                + "Main + extras length: " + "47h 30m 40s" + "\n";

        //test passes if toString() is the same as equivalent string
        Assert.assertTrue(game.toString().equals(equivalentString));
    }

    /**
     * Tests getMainLengthInHours()
     */
    @Test
    public void testGetMainExtrasLengthInHours()
    {
        System.out.println("Run test getMainExtrasLengthInHours");

        //create a game object
        Game game = new Game("Pokemon Red", 1998, "Game Boy", false,
                true, 0, 5400);

        //test passes if mainExtrasLengthInHours that is returned is correct
        Assert.assertTrue(game.getMainExtrasLengthInHours()== 1.5);
    }

    /**
     * Tests getMainLengthInHours()
     */
    @Test
    public void testGetMainLengthInHours()
    {
        System.out.println("Run test getMainLengthInHours");

        //create a game object
        Game game = new Game("Pokemon Red", 1998, "Game Boy", false,
                true, 9540, 0);

        //test passes if mainLengthInHours that is returned is correct
        Assert.assertTrue(game.getMainLengthInHours()== 2.65);
    }

    /**
     * Tests getCompByMainLength()
     */
    @Test
    public void testGetCompByMainLength()
    {
        System.out.println("Run test getCompByMainLength");

        //create game objects
        Game game1 = new Game("Pokemon Red", 1998, "Game Boy", false,
                true, 500, 0);

        Game game2 = new Game("Pokemon Blue", 1998, "Game Boy", false,
                true, 100, 0);

        Game game3 = new Game("Pokemon Yellow", 1998, "Game Boy", false,
                true, 300, 0);

        //create a linked list to hold game objects
        List<Game> list= new LinkedList<Game>();

        //Adds games to list
        list.add(game1);
        list.add(game2);
        list.add(game3);

        //sort list by main length
        list.sort(getCompByMainLength());

        //get position of games in the list
        int indexPokemonRed= list.indexOf(game1);
        int indexPokemonBlue= list.indexOf(game2);
        int indexPokemonYellow= list.indexOf(game3);

        //Test passes if position of games match the expected positions after the sort
        Assert.assertTrue(indexPokemonRed==2 && indexPokemonBlue==0 &&
                indexPokemonYellow==1);


    }
    /**
     * Tests getCompByMainExtrasLength()
     */
    @Test
    public void testGetCompByMainExtrasLength()
    {
        System.out.println("Run test getCompByMainExtrasLength");

        //create game objects
        Game game1 = new Game("Pokemon Red", 1998, "Game Boy", false,
                true, 0, 500);

        Game game2 = new Game("Pokemon Blue", 1998, "Game Boy", false,
                true, 0, 100);

        Game game3 = new Game("Pokemon Yellow", 1998, "Game Boy", false,
                true, 0, 300);

        //create a linked list to hold game objects
        List<Game> list= new LinkedList<Game>();

        //Adds games to list
        list.add(game1);
        list.add(game2);
        list.add(game3);

        //sort list by main extras length
        list.sort(getCompByMainExtrasLength());

        //get position of games in the list
        int indexPokemonRed= list.indexOf(game1);
        int indexPokemonBlue= list.indexOf(game2);
        int indexPokemonYellow= list.indexOf(game3);

        //Test passes if position of games match the expected positions after the sort
        Assert.assertTrue(indexPokemonRed==2 && indexPokemonBlue==0 &&
                indexPokemonYellow==1);


    }

    /**
     * Test getMainExtrasLengthHours()
     */
    @Test
    public void testGetMainExtrasLengthHours()
    {
        System.out.println("Run test getMainExtrasLengthHours");

        //create game object
        Game game1 = new Game("Pokemon Red", 1998, "Game Boy", false,
                true, 0, 10000);

        //Test passes if mainExtrasLengthHours returns a 2 because 10,000 seconds/3600= 2.77
        Assert.assertTrue(game1.getMainExtrasLengthHours()==2);
    }

    /**
     * Tests getMainExtrasLengthMinutes()
     */
    @Test
    public void testGetMainExtrasLengthMinutes()
    {
        System.out.println("Run test getMainExtrasLengthMinutes");

        //create game object
        Game game1 = new Game("Pokemon Red", 1998, "Game Boy", false,
                true, 0, 10000);

        //Test passes if mainExtrasLengthMinutes returns 46 because the remaining time after
        //hours are subtracted is 10000-2*3600=2800 and 2800/60= 46
        Assert.assertTrue(game1.getMainExtrasLengthMinutes()==46);
    }

    /**
     * Tests getMainExtrasLengthSeconds()
     */
    @Test
    public void testGetMainExtrasLengthSeconds()
    {
        System.out.println("Run test getMainExtrasLengthSeconds");

        //create game object
        Game game1 = new Game("Pokemon Red", 1998, "Game Boy", false,
                true, 0, 10000);

        //Test passes if mainExtrasLengthSeconds returns 40 because the remaining time after
        //hours are and minutes are subtracted is 10000-2*3600=2800 - 46*60= 40
        Assert.assertTrue(game1.getMainExtrasLengthSeconds()==40);
    }

    /**
     * Tests getMainLengthHours()
     */
    @Test
    public void testGetMainLengthHours()
    {
        System.out.println("Run test getMainLengthHours");

        //create game object
        Game game1 = new Game("Pokemon Red", 1998, "Game Boy", false,
                true, 10000, 0);

        //Test passes if mainLengthHours returns a 2 because 10,000 seconds/3600= 2.77
        Assert.assertTrue(game1.getMainLengthHours()==2);
    }

    /**
     * Tests getMainLengthMinutes()
     */
    @Test
    public void testGetMainLengthMinutes()
    {
        System.out.println("Run test getMainLengthMinutes");

        //create game object
        Game game1 = new Game("Pokemon Red", 1998, "Game Boy", false,
                true, 10000, 0);

        //Test passes if mainLengthMinutes returns 46 because the remaining time after
        //hours are subtracted is 10000-2*3600=2800 and 2800/60= 46
        Assert.assertTrue(game1.getMainLengthMinutes()==46);
    }
}

