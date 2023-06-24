package OOD_project.gamestats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Displays a graph of game 100% time in order of magnitude
 */
public class View100Graph extends AppCompatActivity {

    /**
     * create copy of game list object
     */

    private GameList copiedGameList;

    /**
     * the global glamelist that is updated by other classes
     */
    private GlobalGameList globalGameList;

    //objects from bar graph library
    //to generate graph
    BarChart chart ;
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    BarDataSet Bardataset ;
    BarData BARDATA ;

    /**
     * Method that creates and displays the layout
     * for the view 100 graph activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_graph);

        //object to sort and order the game list
        Order order = new Order();

        chart =  findViewById(R.id.bargraph);

        //setting x-axis label to bottom of chart
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);


        //initialize GlobalGameList object
        globalGameList= (GlobalGameList)getApplication();

        //create GameList object and copy the GameList in the global game list
        copiedGameList= new GameList();
        copiedGameList= globalGameList.getGameList();

        copiedGameList = order.byMainExtrasLength(copiedGameList);

        //init BARENTRY object
        BARENTRY = new ArrayList<>();

        //init BarEntryLabels object
        BarEntryLabels = new ArrayList<String>();


        //methods to go through game list and add data
        //to the bargraph
        AddValuesToBARENTRY();
        AddValuesToBarEntryLabels();

        //create bar graph
        Bardataset = new BarDataSet(BARENTRY, "Games");
        BARDATA = new BarData(BarEntryLabels, Bardataset);
        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);


        //format graph data
        BARDATA.setValueFormatter(new MyValueFormatter());

        //put data into bar graph
        chart.setData(BARDATA);
        //animation time for data to appear on graph
        chart.animateY(3000);

    }
    /**
     * Method to add values to Y axis
     */
    public void AddValuesToBARENTRY(){


        for (int i= 0; i< copiedGameList.getListSize(); i++)
        {
            //adds rounded main length of game at index i to bar graph
            BARENTRY.add((new BarEntry(
                    Math.round(copiedGameList.getGame(i).getMainExtrasLengthInHours()), i)));
        }

    }



    /**
     * Method to add values to X axis
     */
    public void AddValuesToBarEntryLabels(){

        for (int i= 0; i< copiedGameList.getListSize(); i++)
        {
            //adds name for game at index i
            BarEntryLabels.add(copiedGameList.getGame(i).getName());
        }
    }

}
