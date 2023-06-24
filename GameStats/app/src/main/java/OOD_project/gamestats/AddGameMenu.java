package OOD_project.gamestats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

/**
 * Creates a menu for the user to enter a game's information and add it to the list
 */
public class AddGameMenu extends AppCompatActivity {
    /**
     * the global glamelist that is updated by other classes
     */
    private GlobalGameList globalGameList;

    /**
     * A copy of the global gamelist
     */
    private GameList gameList;

    /**
     *  Method that creates and displays the layout
     *  for the add game menu activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game_menu);

        //create a game list
        gameList= new GameList();

        //assign global game list with global variable
        globalGameList= (GlobalGameList) getApplication();

        //copy global gamelist into game list
        gameList= globalGameList.getGameList();


    }

    /**
     * Method to get all user data
     * and add to the game list
     * once button is clicked
     * @param button The add game button
     */
    public void add_game_button(View button) {

        //getting strings


        EditText et_game_name= findViewById(R.id.delete_name);

        //if ( ( et_game_name.getText().toString().trim().equals("")) ) {
           // Toast.makeText(getApplicationContext(), "Game Name is empty", Toast.LENGTH_SHORT).show();
       // }else {
            String name = et_game_name.getText().toString();
       // }


        EditText et_console = findViewById(R.id.Console);
        String console = et_console.getText().toString();

        //getting check box info
        CheckBox completed_check = (CheckBox) findViewById(R.id.Completed);
        boolean completed = completed_check.isChecked();

        CheckBox inProgress_check = (CheckBox) findViewById(R.id.inProgress);
        boolean inProgress = inProgress_check.isChecked();

        //Code to check if data is in fields
        //and cause an error message if data is not filled
        //otherwise data is gathered


        //getting main time numbers
        long mainHours = 0;
        EditText nmHours = (EditText) findViewById(R.id.mHours) ;
        if (TextUtils.isEmpty(nmHours.getText())) {
            Toast.makeText(getApplicationContext(), "Please add main hours", Toast.LENGTH_SHORT).show();

        }else {
            mainHours = Long.parseLong(nmHours.getText().toString());
        }

        long mainMinutes = 0;
        EditText nmMinutes = (EditText) findViewById(R.id.mMinutes) ;
        if (TextUtils.isEmpty(nmMinutes.getText())){
            Toast.makeText(getApplicationContext(), "Please add main minutes", Toast.LENGTH_SHORT).show();

        }else {
            mainMinutes = Long.parseLong(nmMinutes.getText().toString());
        }

        long mainSeconds = 0;
        EditText nmSeconds = (EditText) findViewById(R.id.mSeconds) ;
        if (TextUtils.isEmpty(nmSeconds.getText())) {
            Toast.makeText(getApplicationContext(), "Please add main seconds", Toast.LENGTH_SHORT).show();

        } else {
            mainSeconds = Long.parseLong(nmSeconds.getText().toString());
        }

        //getting 100% time numbers
        long mainExtrasHours = 0;
        EditText ntHours = (EditText) findViewById(R.id.tHours);

        if (TextUtils.isEmpty(ntHours.getText())) {
            Toast.makeText(getApplicationContext(), "Please add 100% hours", Toast.LENGTH_SHORT).show();

        }else{
            mainExtrasHours = Long.parseLong(ntHours.getText().toString());
        }

        long mainExtrasMinutes = 0;
        EditText ntMinutes = (EditText) findViewById(R.id.tMinutes);
        if (TextUtils.isEmpty(ntMinutes.getText())) {
            Toast.makeText(getApplicationContext(), "Please add 100% minutes", Toast.LENGTH_SHORT).show();

        }else{
            mainExtrasMinutes = Long.parseLong(ntMinutes.getText().toString());
        }

        long mainExtrasSeconds = 0;
        EditText ntSeconds  = (EditText) findViewById(R.id.tSeconds) ;
        if (TextUtils.isEmpty(ntSeconds.getText())) {
            Toast.makeText(getApplicationContext(), "Please add 100% seconds", Toast.LENGTH_SHORT).show();

        }else{
            mainExtrasSeconds = Long.parseLong(ntSeconds.getText().toString());
            }

        EditText nYear  = (EditText) findViewById(R.id.Year) ;
        int year = 0;
        if (TextUtils.isEmpty(nYear.getText())) {
            Toast.makeText(getApplicationContext(), "Please add year", Toast.LENGTH_SHORT).show();
        }else{
             year = Integer.parseInt(nYear.getText().toString());
            }


        //error code if field is empty to tell user to enter information
        if ( TextUtils.isEmpty(et_game_name.getText())) {
            Toast.makeText(getApplicationContext(), "Please add game name", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(et_console.getText())){
            Toast.makeText(getApplicationContext(), "Please add console", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(nmHours.getText())){
            Toast.makeText(getApplicationContext(), "Please add main hours", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(nmMinutes.getText())){
            Toast.makeText(getApplicationContext(), "Please add main minutes", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(nmSeconds.getText())){
            Toast.makeText(getApplicationContext(), "Please add main seconds", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(ntHours.getText())){
            Toast.makeText(getApplicationContext(), "Please add 100% hours", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(ntMinutes.getText())){
            Toast.makeText(getApplicationContext(), "Please add 100% minutes", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(ntSeconds.getText())){
            Toast.makeText(getApplicationContext(), "Please add 100% seconds", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(nYear.getText())){
            Toast.makeText(getApplicationContext(), "Please add year", Toast.LENGTH_SHORT).show();
        }

        else {
            long mainLength= mainHours*3600+ mainMinutes*60+ mainSeconds;
            long mainExtrasLength= mainExtrasHours*3600+ mainExtrasMinutes*60+ mainExtrasSeconds;

            //add game to the list
            gameList.addGame(name, year, console, inProgress, completed, mainLength,
                    mainExtrasLength);

            //replaces the global gamelist with a copy of this gamelist
            globalGameList.replaceGlobalGameList(gameList.getGameList());

            //tell user game has been added to list
            Toast.makeText(getApplicationContext(), "Game Added", Toast.LENGTH_LONG).show();
            //Exit and go to main menu
            Intent startNewActivity= new Intent(this, MainActivity.class);
            startActivity(startNewActivity);
        }
    }
}

