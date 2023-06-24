package com.example.project2;

import java.sql.Time;
import java.util.*;

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
    private int listSize= list.size();

    /**
     * Constructor. Creates a new linked list of Game objects
     */
    public GameList()
    {
        list= new LinkedList<Game>();
    }

    /**
     * Adds a game to the list.
     * @param name Name of the game to add to the list
     * @param year The year the game was released
     * @param console The platform the game is played on
     * @param inProgress True if the game is currently being played. False otherwise.
     * @param completed True if the game was finished by the user. False otherwise.
     * @param mainLength The amount of time it takes to beat the main game.
     * @param mainExtrasLength The amount of time it takes to beat the main game + extras.
     */
    public void addGame(String name, int year, String console, boolean inProgress, boolean completed,
                        Time mainLength, Time mainExtrasLength)
    {

        //create a Game object
        Game newGame= new Game(name, year, console, inProgress, completed,
                mainLength, mainExtrasLength);


        //adds Game object to the list
        list.add(newGame);

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
        if (index!=-1)
            list.remove(index); //removes the game from the list
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
                         Time newMainLength, Time newMainExtrasLength)
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
        //initializes a game object, which will hold the current game being accessed in the list
        Game currentGame;


        //the index of the list. index 0 is the 1st element of the list
        int index;

        //Scans list for Game object that matches the name provided
        for (int i=0; i<list.size(); i++)
        {

            index=i; //index set to current game being accessed in list
            currentGame= list.get(i); //stores game at current index of list into currentGame

            //If the name of currentGame matches the name provided, proceed
            if (currentGame.getName().equals(name))
            {
                //System.out.println("Game that was found: " + currentGame);

                return index; //returns index where game was found
            }
        }

        return -1; //returns -1 if game not found
    }

    /**
     * Getter
     * @return The game list
     */
    public List<Game> getGameList()
    {
        List<Game> copiedList= new LinkedList<Game>();
        for (int i=0; i< list.size(); i++)
        {
            copiedList.add(list.get(i));
        }
        return copiedList;
    }

    /**
     * Getter
     * @param index The position in the last. Starts at 0.
     * @return a Game object at the position index
     */
    public Game getGame(int index)
    {
        //Creates a copy of the list
        List<Game> copiedList= this.getGameList();

        //stores the game object at position index ito copyGame
        Game copyGame= copiedList.get(index);

        //returns the Game object
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
}