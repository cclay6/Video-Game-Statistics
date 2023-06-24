package OOD_project.gamestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.sql.Time;


public class MainActivity extends AppCompatActivity {
    private GameList gameList;
    private GlobalGameList globalGameList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


        public void addGame(View view){
            Intent intent = new Intent(this, AddGameMenu.class);
           startActivity(intent);
        }

        public void view_game_list(View view) {
            Intent intent = new Intent(this, ViewGameListMenu.class);
            startActivity(intent);
        }

    public void view_graph(View view) {
        Intent intent = new Intent(this, view_graph.class);
        startActivity(intent);
    }

}



