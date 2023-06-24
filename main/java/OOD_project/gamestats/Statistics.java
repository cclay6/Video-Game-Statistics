package OOD_project.gamestats;


import java.util.*;

public class Statistics {
    private long averageMainLength;
    private long averageMainExtras;
    private long totalMainLength;
    private long totalMainExtrasLength;

    public Statistics()
    {
        averageMainLength=0;
        averageMainLength=0;
        averageMainLength=0;

        averageMainExtras= averageMainLength;

        totalMainLength=averageMainLength;
        totalMainExtrasLength=totalMainLength;


    }
    long calculateAverageMainLength(GameList gameList)
    {
        List<Game> listContents= new LinkedList<Game>();
        //listContents= gameList.getGameList();
        for (int i=0; i< listContents.size(); i++)
        {

        }
        return averageMainLength;
    }

    long calculateAverageMainExtrasLength(GameList gameList)
    {
        return averageMainExtras;
    }

    long calculateTotalMainLength(GameList gameList)
    {
        return totalMainLength;
    }

    long calculateTotalMainExtrasLength(GameList gameList)
    {
        return totalMainExtrasLength;
    }
}
