package com.example.project2;

import java.sql.Time;
import java.util.*;

public class Statistics {
    private Time averageMainLength;
    private Time averageMainExtras;
    private Time totalMainLength;
    private Time totalMainExtrasLength;

    public Statistics()
    {
        averageMainLength.setHours(0);
        averageMainLength.setMinutes(0);
        averageMainLength.setSeconds(0);

        averageMainExtras= averageMainLength;

        totalMainLength=averageMainLength;
        totalMainExtrasLength=totalMainLength;


    }
    Time calculateAverageMainLength(GameList gameList)
    {
        List<Game> listContents= new LinkedList<Game>();
        listContents= gameList.getGameList();
        for (int i=0; i< listContents.size(); i++)
        {

        }
        return averageMainLength;
    }

    Time calculateAverageMainExtrasLength(GameList gameList)
    {
        return averageMainExtras;
    }

    Time calculateTotalMainLength(GameList gameList)
    {
        return totalMainLength;
    }

    Time calculateTotalMainExtrasLength(GameList gameList)
    {
        return totalMainExtrasLength;
    }
}
