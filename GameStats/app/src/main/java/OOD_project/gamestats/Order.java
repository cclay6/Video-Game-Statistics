package OOD_project.gamestats;

import java.util.LinkedList;
import java.util.List;

import static OOD_project.gamestats.Game.getCompByMainExtrasLength;
import static OOD_project.gamestats.Game.getCompByMainLength;

/**
 * Sorts a GameList object
 */
public class Order {
    /**
     * Orders the contents of a GameList by its mainLength from smallest to largest
     * @param gameList The GameList object to be ordered
     * @return A sorted GameList object by its mainLength
     */
    public GameList byMainLength(GameList gameList)
    {
        //Creates a linked list
        List<Game> list= new LinkedList<Game>();

        //saves the list of gameList into list
        list= gameList.getList();

        //sorts the list using a comparator object that is returned by the getCompByMainLength
        //method of the Game object. It effectively sorts the list from smallest to largest
        //according to the mainLength of each Game in the list.
        list.sort(getCompByMainLength());

        //creates a new GameList object to save the sorted GameList
        GameList sortedGameList= new GameList();

        //creates the variables for the Game objects in the GameList
        String name;
        int year;
        String console;
        boolean inProgress;
        boolean completed;
        long mainLength;
        long mainExtrasLength;

        //copies the games from the sorted list into the sortedGameList
        for (int i=0; i< list.size(); i++)
        {
            //Saves a copy of the game returned by the list at index i
            Game gameCopy= list.get(i);

            //copies each variable within the gameCopy object
            name= gameCopy.getName();
            year= gameCopy.getYear();
            console= gameCopy.getConsole();
            inProgress= gameCopy.getInProgress();
            completed= gameCopy.getCompleted();
            mainLength= gameCopy.getMainLength();
            mainExtrasLength= gameCopy.getMainExtrasLength();

            //Adds the game to the list with identical values as the games in the sorted list
            sortedGameList.addGame(name, year, console, inProgress, completed, mainLength,
                    mainExtrasLength);

        }

        //returns the sorted GameList
        return sortedGameList;
    }

    /**
     * Orders the contents of a GameList by its mainExtrasLength from smallest to largest
     * @param gameList The GameList object to be ordered
     * @return A sorted GameList object by its mainExtrasLength
     */
    public GameList byMainExtrasLength(GameList gameList)
    {
        //Creates a linked list
        List<Game> list= new LinkedList<Game>();

        //saves the list of gameList into list
        list= gameList.getList();

        //sorts the list using a comparator object that is returned by the getCompByMainExtrasLength
        //method of the Game object. It effectively sorts the list from smallest to largest
        //according to the mainExtrasLength of each Game in the list.
        list.sort(getCompByMainExtrasLength());

        //creates a new GameList object to save the sorted GameList
        GameList sortedGameList= new GameList();

        //creates the variables for the Game objects in the GameList
        String name;
        int year;
        String console;
        boolean inProgress;
        boolean completed;
        long mainLength;
        long mainExtrasLength;

        //copies the games from the sorted list into the sortedGameList
        for (int i=0; i< list.size(); i++)
        {
            //Saves a copy of the game returned by the list at index i
            Game gameCopy= list.get(i);

            //copies each variable within the gameCopy object
            name= gameCopy.getName();
            year= gameCopy.getYear();
            console= gameCopy.getConsole();
            inProgress= gameCopy.getInProgress();
            completed= gameCopy.getCompleted();
            mainLength= gameCopy.getMainLength();
            mainExtrasLength= gameCopy.getMainExtrasLength();

            //Adds the game to the list with identical values as the games in the sorted list
            sortedGameList.addGame(name, year, console, inProgress, completed, mainLength,
                    mainExtrasLength);

        }

        //returns the sorted GameList
        return sortedGameList;
    }
}
