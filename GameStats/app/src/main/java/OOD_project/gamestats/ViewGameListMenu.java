package OOD_project.gamestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Displays the games in the gamelist that the user has added
 */
public class ViewGameListMenu extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;

    /**
     * a copy of the global gameList at its current state
     */
    private GameList copiedGameList;

    /**
     * the global glamelist that is updated by other classes
     */
    private GlobalGameList globalGameList;


    /**
     * Method that creates layout and activity
     * functions when this activity is created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

        //initialize GlobalGameList object
        globalGameList= (GlobalGameList)getApplication();

        //create GameList object and copy the GameList in the global game list
        copiedGameList= new GameList();
        copiedGameList= globalGameList.getGameList();

        // data to populate the RecyclerView with
        ArrayList<String> gameNames = new ArrayList<>();
        //creates array of game names
        for (int i= 0; i< copiedGameList.getListSize(); i++)
        {
            //adds name for game at index i
            gameNames.add(copiedGameList.getGame(i).getName());
        }

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvGames);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, gameNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    /**
     *
     * @param view
     * @param position
     * Method to respond to user click events on list
     * objects. Only contains test code.
     */
    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(ViewGameListMenu.this, "hello", Toast.LENGTH_LONG).show();
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        //Intent intent = new Intent(this, GameViewer.class);
        //startActivity(intent);
    }


    /**
     * onResume, updates game list when
     * user returns to this activity
     */
    @Override
    protected void onResume()
    {
        super.onResume();

        //copy contents of global gamelist into copiedGameList
        copiedGameList= globalGameList.getGameList();

        //data to populate the RecyclerView with
        ArrayList<String> gameNames = new ArrayList<>();
        //creates array of game names
        for (int i= 0; i< copiedGameList.getListSize(); i++)
        {
            //adds name for game at index i
            gameNames.add(copiedGameList.getGame(i).getName());
        }
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvGames);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, gameNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

}

