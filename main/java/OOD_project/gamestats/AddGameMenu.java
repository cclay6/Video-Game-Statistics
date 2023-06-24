package OOD_project.gamestats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.widget.CheckBox;
import android.widget.EditText;
import android.view.View;

import java.sql.Time;


public class AddGameMenu extends AppCompatActivity {
    private GlobalGameList globalGameList;
    private GameList gameList;

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

    public void add_game_button(View button) {

        //getting strings
        EditText et_game_name= findViewById(R.id.Name);
        String name = et_game_name.getText().toString();

        EditText et_console = findViewById(R.id.Console);
        String console = et_console.getText().toString();

        //getting check box info
        CheckBox completed_check = (CheckBox) findViewById(R.id.Completed);
        boolean completed = completed_check.isChecked();

        CheckBox inProgress_check = (CheckBox) findViewById(R.id.inProgress);
        boolean inProgress = inProgress_check.isChecked();

        //getting main time numbers
        EditText num = (EditText) findViewById(R.id.mHours) ;
        long mainHours = Long.parseLong(num.getText().toString());

        num = (EditText) findViewById(R.id.mMinutes) ;
        long mainMinutes = Long.parseLong(num.getText().toString());

        num = (EditText) findViewById(R.id.mSeconds) ;
        long mainSeconds = Long.parseLong(num.getText().toString());


        //getting 100% time numbers
        num = (EditText) findViewById(R.id.tHours) ;
        long mainExtrasHours = Long.parseLong(num.getText().toString());

        num = (EditText) findViewById(R.id.tMinutes) ;
        long mainExtrasMinutes = Long.parseLong(num.getText().toString());

        num = (EditText) findViewById(R.id.tSeconds) ;
        long mainExtrasSeconds = Long.parseLong(num.getText().toString());

        num = (EditText) findViewById(R.id.Year) ;
        int year = Integer.parseInt(num.getText().toString());

        long mainLength= mainHours*3600+ mainMinutes*60+ mainSeconds;
        long mainExtrasLength= mainExtrasHours*3600+ mainExtrasMinutes*60+ mainExtrasSeconds;


        //add game to the list
        gameList.addGame(name, year, console, inProgress, completed, mainLength,
                mainExtrasLength);

        //replaces the global gamelist with a copy of this gamelist
        globalGameList.replaceGlobalGameList(gameList.getGameList());

        //Exit and go to main menu
        Intent startNewActivity= new Intent(this, MainActivity.class);
        startActivity(startNewActivity);

    }
}

