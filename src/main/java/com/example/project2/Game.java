package com.example.project2;

import java.sql.Time;

/**
 * A game object that manages game information
 */
public class Game {
    /**
     * Name of the game
     */
    private String name;

    /**
     * Year the game was released
     */
    private int year;

    /**
     * The platform the game runs on
     */
    private String console;

    /**
     * True if the user is currently playing the game. False otherwise.
     */
    private boolean inProgress;

    /**
     * True if the user has completed the game. False otherwise.
     */
    private boolean completed;

    /**
     * The time it takes to beat the main game.
     */
    private Time mainLength;

    /**
     * The time it takes to beat the main game + extras.
     */
    private Time mainExtrasLength;

    /**
     * Constructor. Creates a game object.
     * @param name The name of the game.
     * @param year The year the game was released.
     * @param console The platform the game runs on.
     * @param inProgress True if the game is currently being played by the user. False otherwise.
     * @param completed True if the user has completed the game. False otherwise.
     * @param mainLength The length of time it takea to beat the main game.
     * @param mainExtrasLength The length of time it takes to beat the main game + extras.
     */
    public Game(String name, int year, String console, boolean inProgress, boolean completed,
                Time mainLength, Time mainExtrasLength)
    {

        //Sets parameters of the game object to the values the user has entered
        this.name= name;
        this.year= year;
        this.console= console;
        this.inProgress= inProgress;
        this.completed= completed;
        this.mainLength= mainLength;
        this.mainExtrasLength= mainExtrasLength;

    }

    /**
     * Getter.
     * @return The name of the game.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Getter.
     * @return The year the game was released.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Getter.
     * @return The platform the game runs on.
     */
    public String getConsole()
    {
        return console;
    }

    /**
     * Getter.
     * @return Whether or not the game is in progress (yes or no)
     */
    public String getInProgress()
    {
        //converts boolean to yes or no instead of true or false
        if (this.inProgress)
            return "yes";
        return "no";
    }

    /**
     * Getter.
     * @return Whether or not the game has been completed (yes or no)
     */
    public String getCompleted()
    {
        //converts boolean to yes or no instead of true or false
        if (this.completed)
            return "yes";
        return "no";
    }

    /**
     * Getter.
     * @return The length of time it takes to beat the main game.
     */
    public Time getMainLength()
    {
        return mainLength;
    }

    /**
     * Getter.
     * @return The length of time is takes to beat the main game + extras.
     */
    public Time getMainExtrasLength()
    {
        return mainExtrasLength;
    }

    /**
     * Mutator.
     * @param newName The name the user wants to change the name of the game to
     */
    public void changeName(String newName)
    {
        this.name= newName;
    }

    /**
     * Mutator.
     * @param newYear The new year of release the user wants to change the game to
     */
    public void changeYear( int newYear)
    {
        this.year= newYear;
    }

    /**
     * Mutator.
     * @param newConsole The console the user wants to change the game to
     */
    public void changeConsole(String newConsole)
    {
        this.console= newConsole;
    }

    /**
     * Mutator.
     * @param inProgress The updated inProgress state the user wants to set the game to
     */
    void changeInProgress(boolean inProgress)
    {
        this.inProgress= inProgress;
    }

    /**
     * Mutator.
     * @param completed The updated completed state the user wants to set the game to
     */
    void changeGetCompleted(boolean completed)
    {
        this.completed= completed;
    }

    /**
     * Mutator.
     * @param newMainLength The new main length time the user wants to set the game to
     */
    void changeMainLength(Time newMainLength)
    {
        this.mainLength= newMainLength;
    }

    /**
     * Mutator. The new main length + extras time the user wants to set the game to
     * @param newMainExtrasLength
     */
    void changeMainExtrasLength(Time newMainExtrasLength)
    {
        this.mainExtrasLength= newMainExtrasLength;
    }

    /**
     * Converts the contents of the game into a string.
     * @return The game information in the form of a string
     */
    public String toString()
    {
        //Creates the string of game information
        String info= "Name: " + this.getName() + "\n"
                + "Year: " + this.getYear() + "\n"
                + "Console: " + this.getConsole() + "\n"
                + "In progress: " + this.getInProgress() + "\n"
                + "Completed: " + this.getCompleted() + "\n"
                + "Main length: " + this.getMainLength() + "\n"
                + "Main + extras length: " + this.getMainExtrasLength();

        return info; //returns the game information
    }
}