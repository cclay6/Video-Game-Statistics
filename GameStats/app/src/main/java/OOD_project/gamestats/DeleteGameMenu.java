package OOD_project.gamestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Creates a menu for user to enter what game to delete from the list.
 */
public class DeleteGameMenu extends AppCompatActivity {

    /**
     * the global glamelist that is updated by other classes
     */
    private GlobalGameList globalGameList;

    /**
     * a copy of the global gamelist
     */
    private GameList gameList;


    /**
     * Method that creates and displays the layout
     * for the delete game menu activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_game);


        //create a game list
        gameList= new GameList();

        //assign global game list with global variable
        globalGameList= (GlobalGameList) getApplication();

        //copy global gamelist into game list
        gameList= globalGameList.getGameList();
    }

    /**
     * When the button is pressed, deletes a game from the list
     * @param button The delete game button
     */
    public void delete_game_button(View button){

        EditText et_game_name= findViewById(R.id.delete_name);

        //prevent users from trying to delete nothing
        if ( TextUtils.isEmpty(et_game_name.getText())) {
            Toast.makeText(getApplicationContext(), "Please add game name", Toast.LENGTH_SHORT).show();
        } else{
            String name = et_game_name.getText().toString();

            //making sure game is in the game list
            if (gameList.searchList(name) == -1) {
                Toast.makeText(getApplicationContext(), "Game Not Found", Toast.LENGTH_LONG).show();
            } else {
                //deleting game and updating the game list
                gameList.deleteGame(name);
                globalGameList.replaceGlobalGameList(gameList.getGameList());
                Toast.makeText(getApplicationContext(), "Game Deleted", Toast.LENGTH_SHORT).show();

                Intent startNewActivity= new Intent(this, MainActivity.class);
                startActivity(startNewActivity);
            }
        }
    }

}
