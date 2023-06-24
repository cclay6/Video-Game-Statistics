package OOD_project.gamestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        }

        public void addGame(View view){
            Intent intent = new Intent(this, addGameMenu.class);
           startActivity(intent);
        }

        public void view_game_list(View view){
            Intent intent = new Intent(this, game_list.class);
            startActivity(intent);
    }

    }

