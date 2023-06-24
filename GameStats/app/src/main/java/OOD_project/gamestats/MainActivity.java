package OOD_project.gamestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * The class for creating and handling events
 * on the main menu activity
 */
public class MainActivity extends AppCompatActivity {
    /**
     * A copy of the global gamelist
     */
    private GameList gameList;
    /**
     * the global glamelist that is updated by other classes
     */
    private GlobalGameList globalGameList;


    @Override
    /**
     * Method that creates and displays the layout
     * for the main activity
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameList= new GameList();
        globalGameList=(GlobalGameList)getApplication();
        gameList= globalGameList.getGameList();
    }

    /**
     * method called to change activity on button press
     * @param view The add game button
     */
    public void addGame(View view){
        Intent intent = new Intent(this, AddGameMenu.class);
       startActivity(intent);
    }

    /**
     * method called to change activity on button press
     * @param view The view gamelist button
     */
    public void view_game_list(View view) {
        Intent intent = new Intent(this, ViewGameListMenu.class);
        startActivity(intent);
    }

    /**
     * method called to change activity on button press
     * @param view The view graph button
     */
    public void view_graph(View view) {
        Intent intent = new Intent(this, GraphSelect.class);
        startActivity(intent);
    }

    /**
     * method called to change activity on button press
     * @param view The delete game button
     */
    public void delete_game(View view) {

        //error handling if the list object is empty
        if (gameList.getListSize()!=0)
        {
            Intent intent = new Intent(this, DeleteGameMenu.class);
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Error. Empty list.", Toast.LENGTH_SHORT).show();
    }

    /**
     * method called to change activity on button press
     * @param view The view stats button
     */
    public void view_stats(View view) {

            Intent intent = new Intent(this, ViewStatistics.class);
            startActivity(intent);
    }

}



