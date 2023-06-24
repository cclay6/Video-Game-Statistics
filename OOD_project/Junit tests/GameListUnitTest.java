package OOD_project.gamestats;
import org.junit.*;




/**
 * Performs Junit test on GameList class
 */
public class GameListUnitTest {


    /**
     * Tests addGame() of GameList. Also tests toString()
     */
    @Test
    public void testaddGame()
    {
        System.out.println("Run test addGame. Tests toString as well.");

        //Creates game data variables
        String name= "Chrono Trigger";
        int year= 1990;
        String console= "SNES";
        boolean inProgress = false;
        boolean completed = true;
        int hours = 23;
        int minutes = 0;
        int seconds = 0;
        int extrasHours= 26;
        int extrasMinutes= 0;
        int extrasSeconds= 0;
        long mainLength= hours*3600+minutes*60+seconds;
        long mainExtrasLength= extrasHours*3600+extrasMinutes*60+extrasSeconds;

        //creates game list
        GameList gameList= new GameList();

        //adds game to the list
        gameList.addGame(name, year, console, inProgress, completed,
                mainLength, mainExtrasLength);

        //creates a string for comparison
        String equivalentString= "[Name: " + "Chrono Trigger" + "\n"
                + "Year: " + "1990" + "\n"
                + "Console: " + "SNES" + "\n"
                + "In progress: " + "no" + "\n"
                + "Completed: " + "yes" + "\n"
                + "Main length: " + "23h 0m 0s" + "\n"
                + "Main + extras length: " + "26h 0m 0s" + "\n"+ "]";


        //tests if the string that is returned by the toString() method
        //is equivalent to the manually entered string, which also shows
        //if the addGame() method works
        Assert.assertTrue(gameList.toString().equals(equivalentString));


    }
    /**
     * Tests deleteGame() method
     */
    @Test
    public void testDeleteGame()
    {
        System.out.println("Run test deleteGame");

        //Creates game data variables
        String name1= "game1";
        String name2= "game2";
        String name3= "game3";
        int year= 1111;
        String console= "SNES";
        boolean inProgress = false;
        boolean completed = true;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        long mainLength = hours*3600+minutes*60+seconds;
        int extrasHours= 0;
        int extrasMinutes= 0;
        int extrasSeconds= 0;
        long mainExtrasLength= extrasHours*3600+extrasMinutes*60+extrasSeconds;

        //creates game list
        GameList gameList= new GameList();

        //adds games to the list
        gameList.addGame(name1, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList.addGame(name2, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList.addGame(name3, year, console, inProgress, completed,
                mainLength, mainExtrasLength);

        //deletes game with name 2
        gameList.deleteGame(name2);

        //create Game objects for comparison
        Game game1= new Game(name1, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        Game game3= new Game(name3, year, console, inProgress, completed,
                mainLength, mainExtrasLength);

        //creates equivalent string as what the list should return
        String equivalentString= "[" + game1.toString() + ", " + game3.toString() + "]";

        //tests if string of list matches the expected returned string
        Assert.assertTrue(gameList.toString().equals(equivalentString));


    }

    /**
     * Tests editGame() method
     */
    @Test
    public void testEditGame()
    {
        System.out.println("Run test editGame");

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
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        long mainLength = hours*3600+minutes*60+seconds;
        long mainExtrasLength = hours*3600+minutes*60+seconds;

        //adds games to list
        gameList.addGame(name1, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList.addGame(name2, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList.addGame(name3, year, console, inProgress, completed,
                mainLength, mainExtrasLength);


        //initalizes new variables for game edit
        String newName= "Metal Gear Solid IV: Guns of the Patriots";
        //Sets the variables of three games
        int newYear = 2008;
        String newConsole = "PS3";
        boolean newInProgress = true;
        boolean newCompleted = false;
        int newHours = 1;
        int newMinutes = 1;
        int newSeconds = 1;
        long newMainLength = newHours*3600+newMinutes*60+newSeconds;
        long newMainExtrasLength = newHours*3600+newMinutes*60+newSeconds;

        //edit game with name2 with new info
        gameList.editGame(name2, newName, newYear, newConsole, newInProgress, newCompleted,
                newMainLength, newMainExtrasLength);

        //create a new gamelist for comparison
        GameList gameList2= new GameList();

        //add game to the new list with same info as the edited game
        gameList2.addGame(name1, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList2.addGame(newName, newYear, newConsole, newInProgress, newCompleted,
                newMainLength, newMainExtrasLength);
        //add game with name3 so it has the same games in list2
        gameList2.addGame(name3, year, console, inProgress, completed,
                mainLength, mainExtrasLength);

        //compares the list using the edit game method, and what should be an equivalent list
        Assert.assertTrue(gameList.toString().equals(gameList2.toString()));

    }

    /**
     * Tests getGameList()
     */
    @Test
    public void testGetGameList()
    {
        System.out.println("Run test getGameList");

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
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        long mainLength = hours*3600+minutes*60+seconds;
        long mainExtrasLength = hours*3600+minutes*60+seconds;

        //adds games to game list
        gameList.addGame(name1, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList.addGame(name2, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList.addGame(name3, year, console, inProgress, completed,
                mainLength, mainExtrasLength);


        //create a list object that will receive the contents of the game list
        GameList copyGameList= new GameList();

        //copies the contents of the game list into copyGameList
        copyGameList= gameList.getGameList();

        //Checks to see that the strings produced by both the copyGameList and gameList
        //are the same, and so the contents are the same
        boolean contentsCopied= copyGameList.toString().equals(gameList.toString());

        //adds an additional game to copyGameList
        copyGameList.addGame("Final Fantasy 7", 1997, "PS1",
                false, false, mainLength, mainExtrasLength);

        //Checks for a deep copy. If the added game to the copyGameList does not affect the gameList,
        //then the copy is deep copy. Is true for a deep copy. False for a shallow copy.
        boolean deepCopy= !(copyGameList.toString().equals(gameList.toString()));

        //resets the copyGameList to the same contents of getGameList
        copyGameList= gameList.getGameList();

        //deletes a game from gameList
        gameList.deleteGame(name3);

        //another deep copy test. The deletion of a game in the gameList should not affect
        //the copyGameList. Is true for a deepy copy. False if a shallow copy.
        boolean deepCopy2= !(copyGameList.toString().equals(gameList.toString()));


        //Test passed if getGameList() is able to copy the contents of a GameList and is not a
        //shallow copy in two different cases
        Assert.assertTrue(contentsCopied&&deepCopy&&deepCopy2);
    }

    /**
     * Tests searchList
     */
    @Test
    public void testSearchList()
    {
        System.out.println("Run test searchList");

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
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        long mainLength = hours*3600+minutes*60+seconds;
        long mainExtrasLength = hours*3600+minutes*60+seconds;

        //adds games to game list
        gameList.addGame(name1, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList.addGame(name2, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList.addGame(name3, year, console, inProgress, completed,
                mainLength, mainExtrasLength);

        //Test passes if the idex of the game with name2 is at index 1, the second position in the
        //list
        Assert.assertTrue(gameList.searchList(name2)==1);
    }

    /**
     * Tests getGame
     */
    @Test
    public void testGetGame()
    {
        System.out.println("Run test getGame");

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
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        long mainLength = hours*3600+minutes*60+seconds;
        long mainExtrasLength = hours*3600+minutes*60+seconds;

        //adds games to game list
        gameList.addGame(name1, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList.addGame(name2, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList.addGame(name3, year, console, inProgress, completed,
                mainLength, mainExtrasLength);

        //copies contents of the gameList at index 1, which is name2
        Game copyName2= gameList.getGame(1);

        //verifies that the contents were copied if copyName and the game at index 1 in the list
        //produces the same string
        boolean contentsSame= copyName2.toString().equals(gameList.getGame(1).toString());

        gameList.editGame(name2, "Metal Gear Solid IV", year, console,
                inProgress, completed, mainLength, mainExtrasLength);

        //verifies if a deep copy is made. The edit of game name2 should not affect copyName2
        boolean deepCopy= !(copyName2.toString().equals(gameList.getGame(1).toString()));

        //the test passes if the contents are the same of the copy and name2 game, and a deep copy
        //was made
        Assert.assertTrue(contentsSame&&deepCopy);
    }

    /**
     * Tests getListSize
     */
    @Test
    public void testGetListSize()
    {
        System.out.println("Run test getListSize");

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
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        long mainLength = hours*3600+minutes*60+seconds;
        long mainExtrasLength = hours*3600+minutes*60+seconds;

        //adds games to game list
        gameList.addGame(name1, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList.addGame(name2, year, console, inProgress, completed,
                mainLength, mainExtrasLength);
        gameList.addGame(name3, year, console, inProgress, completed,
                mainLength, mainExtrasLength);

        //Test passes if getListSize() returns 3
        Assert.assertTrue(gameList.getListSize()==3);
    }
}




