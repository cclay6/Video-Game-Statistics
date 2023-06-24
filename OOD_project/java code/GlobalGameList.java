package OOD_project.gamestats;

import android.app.Application;

/**
 * Manages the updating and retreival of the global gamelist
 */
public class GlobalGameList extends Application {
    /**
     * The global gamelist that all objects can refer to
     */
    private GameList globalGameList= new GameList();

    /**
     * Retrieve a copy of the global game list
     * @return
     */
    public GameList getGameList(){
        return globalGameList.getGameList();
    }

    /**
     * replaces the global gamelist with a new/updated gamelist
     * @param newGameList
     */
    public void replaceGlobalGameList(GameList newGameList)
    {
        this.globalGameList= newGameList.getGameList();

    }

    /**
     * Used for testing that a global gamelist is updated without having a user add a game to the
     * list
     */
    public void addGameTest()
    {
        //sets the mainlength as 3600 seconds, used for both the mainLength and mainExtrasLength
        long mainlength= 3600;

        //adds a game, manually, to the global gamelist
        globalGameList.addGame("example game", 2000, "super game box",
                false, false, mainlength, mainlength);
    }
}
