package OOD_project.gamestats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


/**
 * Graph Select is a menu for users to select
 * what graph data to view
 */
public class GraphSelect extends AppCompatActivity {

/**
 * Method that creates layout and activity
 * functions when this activity is created
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_select);
    }

    /**
     * method to call creation of graph that shows main game times
     * @param view The view main graph button
     */
    public void view_main_graph(View view) {
        Intent intent = new Intent(this, ViewMainGraph.class);
        startActivity(intent);
    }

    /**
     * method to call creation of graph that shows main and extra game times
     * @param view The view 100% graph button
     */
    public void view_100_graph(View view) {
        Intent intent = new Intent(this, View100Graph.class);
        startActivity(intent);
    }

}
