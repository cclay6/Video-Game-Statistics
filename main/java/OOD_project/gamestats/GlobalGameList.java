package OOD_project.gamestats;

import android.app.Application;


public class GlobalGameList extends Application {
    private GameList globalGameList= new GameList();

    public GameList getGameList(){
        return globalGameList.getGameList();
    }

    public void replaceGlobalGameList(GameList newGameList)
    {
        this.globalGameList= newGameList.getGameList();

    }

    public void addGameTest()
    {
        long mainlength= 3600;
        globalGameList.addGame("example game", 2000, "super game box",
                false, false, mainlength, mainlength);
    }
}
