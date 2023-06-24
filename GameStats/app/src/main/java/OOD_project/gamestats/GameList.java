package OOD_project.gamestats;


import java.sql.Time;
import java.util.*;

import static OOD_project.gamestats.Game.getCompByMainLength;

/**
 * Manages a list of games
 */
public class GameList {
    /**
     * A list that holds Game objects
     */
    private List<Game> list;


    /**
     * The size of the list
    */

    private int listSize;

    /**
     * Constructor. Creates a new linked list of Game objects
     */

    public GameList()
    {

        list= new LinkedList<Game>();
        listSize= list.size();
    }

    /**
     * Adds a game to the list.
     * @param name Name of the game to add to the list
     * @param year The year the game was released
     * @param console The platform the game is played on
     * @param inProgress True if the game is currently being played. False otherwise.
     * @param completed True if the game was finished by the user. False otherwise.
     * @param mainLength The amount of time it takes to beat the main game in seconds
     * @param mainExtrasLength The amount of time it takes to beat the main game + extras in seconds
     */


    public void addGame(String name, int year, String console, boolean inProgress, boolean completed,
                        long mainLength, long mainExtrasLength)
    {

        //create a Game object
        Game newGame= new Game(name, year, console, inProgress, completed,
                mainLength, mainExtrasLength);


        //adds Game object to the list
        list.add(newGame);
        listSize++;

    }

    /**
     * Deletes a game from the list.
     * @param name The name of the game the user wants to delete.
     */

    public void deleteGame(String name)
    {

        //stores the index of the game in the list with a matching name
        int index= this.searchList(name);

        //If the index returned by searchList() is not -1, the game has been found in list.
        //proceed
        if (index!=-1) {
            list.remove(index); //removes the game from the list
            listSize--;
        }
    }

    /**
     * Edits game information of an entry in the list
     * @param oldName The old name of the game in the list. Used to search its location.
     * @param newName The new name of the game after the edit.
     * @param newYear The new year of the game after the edit.
     * @param newConsole The new console of the game after the edit.
     * @param newInProgress The new in progress state after the edit
     * @param newCompleted The new completed state after the edit
     * @param newMainLength The new main length time of the game after the edit.
     * @param newMainExtrasLength The new main length + extras time of the game after the edit
     */
    public void editGame(String oldName, String newName, int newYear, String newConsole,
                         boolean newInProgress, boolean newCompleted,
                         long newMainLength, long newMainExtrasLength)
    {
        int index= this.searchList(oldName); //sets index to the location of the game of same name

        //if index is not -1, the game is found. Proceed.
        if (index!= -1)
        {
            //creates a Game object with edited information that user provided
            Game editedGame= new Game(newName, newYear, newConsole, newInProgress, newCompleted,
                    newMainLength, newMainExtrasLength);

            list.set(index, editedGame); //replaces old game info with edited info
        }

    }

    /**
     * Converts the game list to a string
     * @return A string with the information contained in the list for every game in the list
     */
    public String toString()
    {
        //Overloads the toString() method as the contents of list
        String output= list.toString();
        return output; //returns the information in the list as a string
    }

    /**
     * Searches the list for game with a matching name
     * @param name The name of the game that is being searched for
     * @return The index of the game in the list, or a -1 if the game was not found
     */
    public int searchList(String name)
    {
        Game currentGame;

        //Scans list for Game object that matches the name provided
        for (int i=0; i<list.size(); i++)
        {

            currentGame= this.getGame(i); //stores game at current index of list into currentGame

            //If the name of currentGame matches the name provided, proceed
            if (currentGame.getName().equals(name))
                return i; //returns index/position where game was found
        }

        return -1; //returns -1 if game not found
    }

    /**
     * Getter
     * @return The game list
     */
    public GameList getGameList()
    {
        //creates a new list, which will be a copy of the original
        GameList copiedGameList= new GameList();

        //gets copies of the Game objects from the original game list
        //and stores them into a new game list
        for (int i=0; i< list.size(); i++)
        {
            //creates game object
            Game game= this.getGame(i);
            copiedGameList.addGame(game.getName(), game.getYear(), game.getConsole(),
                    game.getInProgress(), game.getCompleted(), game.getMainLength(),
                    game.getMainExtrasLength());
        }
        return copiedGameList;
    }

    /**
     * Getter
     * @param index The position in the last. Starts at 0.
     * @return a copy of the Game object at the position index
     */
    public Game getGame(int index)
    {
        //Stores Game object as position index into originalGame
        Game originalGame= list.get(index);

        //Copies the contents of originalGame
        String name= originalGame.getName();
        int year= originalGame.getYear();
        String console= originalGame.getConsole();
        boolean inProgress= originalGame.getInProgress();
        boolean completed= originalGame.getCompleted();
        long mainLength= originalGame.getMainLength();
        long mainExtrasLength= originalGame.getMainExtrasLength();


        //creates a Game object with same contents as original
        Game copyGame= new Game(name, year, console, inProgress, completed, mainLength,
                mainExtrasLength);

        //returns the copy of the original game object
        return copyGame;


    }

    /**
     * Getter
     * @return the size of the list
     */
    public int getListSize()
    {
        return listSize;
    }

    public List<Game> getList()
    {
        String name;
        int year;
        String console;
        boolean inProgress;
        boolean completed;
        long mainLength;
        long mainExtrasLength;
        List<Game> listCopy= new LinkedList<Game>();
        for (int i= 0; i< listSize; i++)
        {
            Game game= list.get(i);
            name= game.getName();
            year= game.getYear();
            console= game.getConsole();
            inProgress= game.getInProgress();
            completed= game.getCompleted();
            mainLength= game.getMainLength();
            mainExtrasLength= game.getMainExtrasLength();
            Game newGame= new Game(name, year, console, inProgress, completed, mainLength,
                    mainExtrasLength);
            listCopy.add(newGame);
        }

        return listCopy;
    }
}
