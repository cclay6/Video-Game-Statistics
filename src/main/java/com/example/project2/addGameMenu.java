package OOD_project.gamestats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.CheckBox;
import android.widget.EditText;
import android.view.View;

import java.sql.Time;


public class addGameMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game_menu);

    }

    public void add_game_button(View button) {

        //getting strings
        EditText et_game_name= findViewById(R.id.Name);
        String game_name = et_game_name.getText().toString();

        EditText et_console = findViewById(R.id.Console);
        String Console = et_console.getText().toString();

        //getting check box info
        CheckBox completed_check = (CheckBox) findViewById(R.id.Completed);
        boolean bCompleted = completed_check.isChecked();

        CheckBox inProgress_check = (CheckBox) findViewById(R.id.inProgress);
        boolean binProgress = inProgress_check.isChecked();

        //getting main time numbers
        EditText num = (EditText) findViewById(R.id.mHours) ;
        int main_hours = Integer.parseInt(num.getText().toString());

        num = (EditText) findViewById(R.id.mMinutes) ;
        int main_minutes = Integer.parseInt(num.getText().toString());

        num = (EditText) findViewById(R.id.mSeconds) ;
        int main_Seconds = Integer.parseInt(num.getText().toString());

        Time main_length = new Time(main_hours, main_minutes, main_Seconds);


        //getting 100% time numbers
        num = (EditText) findViewById(R.id.tHours) ;
        int total_hours = Integer.parseInt(num.getText().toString());

        num = (EditText) findViewById(R.id.tMinutes) ;
        int total_minutes = Integer.parseInt(num.getText().toString());

        num = (EditText) findViewById(R.id.tSeconds) ;
        int total_Seconds = Integer.parseInt(num.getText().toString());

        Time total_length = new Time(main_hours, main_minutes, main_Seconds);


        num = (EditText) findViewById(R.id.Year) ;
        int year = Integer.parseInt(num.getText().toString());

        //GameList.addGame(game_name, year, Console, binProgress, bCompleted,
          //      main_length, total_length);

    }

}

