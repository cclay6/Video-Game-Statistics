package OOD_project.gamestats;


import java.util.*;

/**
 * Calculates the statistics in the list
 */
public class Statistics {
    /**
     * The average time it takes to beat the main quest among the games in the list
     */
    private long averageMainLength;
    /**
     * The average time it takes to beat the main quest + extras among the games in the list
     */
    private long averageMainExtrasLength;
    /**
     * The total time it takes to beat all of the games in the list according to main quest
     */
    private long totalMainLength;
    /**
     * The total time it takes to beat all of the games in the list according to main quest + extras
     */
    private long totalMainExtrasLength;

    /**
     * Constructor.
     */
    public Statistics()
    {
        //initialize all values to zero
        averageMainLength=0;
        averageMainExtrasLength=0;
        totalMainLength=0;
        totalMainExtrasLength=0;




    }

    /**
     * Calculates the average time it takes to beat the main quest among the games in the list
     * @param gameList The game list used to calculate the average main length time
     * @return the average main length
     */
    long calculateAverageMainLength(GameList gameList)
    {
        //get list size
        int size= gameList.getListSize();
        //if size is 0, list is empty and so average is 0. Else, proceed.
        if (size== 0)
        {
            return 0;
        }
        else
        {
            //get the total
            totalMainLength= this.calculateTotalMainLength(gameList);

            //calculate the average by dividing the total by the number of games
            averageMainLength= totalMainLength/size;


            //return the average
            return averageMainLength;
        }

    }

    /**
     * Calculates the average time it takes to beat the main quest + extras
     * among the games in the list
     * @param gameList The game list used to calculate the average main length + extras time
     * @return the average main length + extras time
     */
    long calculateAverageMainExtrasLength(GameList gameList)
    {

        //get list size
        int size= gameList.getListSize();
        //if size is 0, list is empty and so average is 0. Else, proceed.
        if (size== 0)
        {
            return 0;
        }
        else
        {
            //get the total
            totalMainExtrasLength= this.calculateTotalMainExtrasLength(gameList);

            //calculate the average by dividing the total by the number of games
            averageMainExtrasLength= totalMainExtrasLength/size;;

            //return the average
            return averageMainExtrasLength;
        }

    }

    /**
     * Calculates the total time it takes to beat the main quest in the games in the list
     * @param gameList The game list used to calculate the total main length time
     * @return the total main length
     */
    long calculateTotalMainLength(GameList gameList)
    {
        //default is 0 before calculating the total
        totalMainLength= 0;

        //set the size to the size of the list
        int size= gameList.getListSize();

        //add up the mainLength of each game object in the GameList to the total
        for (int i=0; i< size; i++)
        {
            totalMainLength+=gameList.getGame(i).getMainLength();
        }

        //return the totalMainLength
        return totalMainLength;
    }

    /**
     * Calculates the total time it takes to beat the main quest + extras in the games in the list
     * @param gameList The game list used to calculate the total main length extras time
     * @return the total main extras length
     */
    long calculateTotalMainExtrasLength(GameList gameList)
    {
        //default is 0 before calculating the total
        totalMainExtrasLength= 0;

        //set the size to the size of the list
        int size= gameList.getListSize();

        //add up the mainExtrasLength of each game object in the GameList to the total
        for (int i=0; i< size; i++)
        {
            totalMainExtrasLength+=gameList.getGame(i).getMainExtrasLength();
        }

        //return the totalMainExtrasLength
        return totalMainExtrasLength;
    }
}
