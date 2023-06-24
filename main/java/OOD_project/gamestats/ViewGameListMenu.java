package OOD_project.gamestats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class ViewGameListMenu extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    private GameList copiedGameList;
    private GlobalGameList globalGameList;

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
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}

