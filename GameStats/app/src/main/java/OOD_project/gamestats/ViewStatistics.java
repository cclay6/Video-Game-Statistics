package OOD_project.gamestats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Displays Statistics to the user
 */
public class ViewStatistics extends AppCompatActivity {

    /**
     * The global gamelist that is updated by other classes
     */
    private GlobalGameList globalGameList;

    /**
     * A copy of the global gameList at its most recent state
     */
    private GameList copiedGameList;

    /**
     * Method that creates and displays the layout
     * for the view statistics activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_statistics);

        //initialize GlobalGameList object
        globalGameList= (GlobalGameList)getApplication();

        //create GameList object and copy the GameList in the global game list
        copiedGameList= new GameList();
        copiedGameList= globalGameList.getGameList();

        //create a Statistics object
        Statistics statistics= new Statistics();

        //create message string
        String tMainTimeMessage, aMainTimeMessage, tTotalTimeMessage, aTotalTimeMessage;

        //format floats to two decimals
        DecimalFormat numberFormat = new DecimalFormat("#.00");

        //initialize hours, mins, and seconds components
        long totalMainTimeHours = 0;
        long totalMainTimeMins = 0;
        long totalMainTimeSecs = 0;
        long totalMainExtrasTimeHours = 0;
        long totalMainExtrasTimeMins = 0;
        long totalMainExtrasTimeSecs = 0;

        long averageMainExtrasTimeHours = 0;
        long averageMainExtrasTimeMins = 0;
        long averageMainExtrasTimeSecs = 0;

        long averageMainTimeHours = 0;
        long averageMainTimeMins = 0;
        long averageMainTimeSecs = 0;





        //get total values in seconds
        long totalMainExtrasLength= statistics.calculateTotalMainExtrasLength(copiedGameList);
        long totalMainlength= statistics.calculateTotalMainLength(copiedGameList);

        //get average values in seconds
        long averageMainExtrasLength= statistics.calculateAverageMainExtrasLength(copiedGameList);
        long averageMainLength= statistics.calculateAverageMainLength(copiedGameList);

        //initialize total inProgress and total completed progress
        int tInProgress = 0;
        int tCompleted = 0;

        //initialize percent inProgress and completed to 0
        float aInProgress = 0;
        float aCompleted = 0;

        //getting total values
        for (int i= 0; i< copiedGameList.getListSize(); i++)  {

            //getting number of games completed or in progress
            if(copiedGameList.getGame(i).getInProgress()) {
                tInProgress++;
            }

            if(copiedGameList.getGame(i).getCompleted()) {
                tCompleted++;
            }
        }

        //if the total completed is more than 0, find percentage
        if(tCompleted > 0){
            aCompleted = (((float)tCompleted / copiedGameList.getListSize()) * 100);
        }

        if(tInProgress > 0){
            aInProgress = (((float)tInProgress / copiedGameList.getListSize()) * 100);
        }


        //totalMainExtrasLength components
        totalMainExtrasTimeHours= totalMainExtrasLength/ 3600;
        totalMainExtrasTimeMins= (totalMainExtrasLength-totalMainExtrasTimeHours*3600)/60;
        totalMainExtrasTimeSecs= (totalMainExtrasLength- totalMainExtrasTimeHours*3600-
                totalMainExtrasTimeMins*60);


        //totalMainLength components
        totalMainTimeHours= totalMainlength/3600;
        totalMainTimeMins= (totalMainlength- totalMainTimeHours*3600)/60;
        totalMainTimeSecs= (totalMainlength- totalMainTimeHours*3600-
                totalMainTimeMins*60);


        //averageMainExtrasLength components
        averageMainExtrasTimeHours = averageMainExtrasLength/ 3600;
        averageMainExtrasTimeMins= (averageMainExtrasLength - averageMainExtrasTimeHours*3600)/60;
        averageMainExtrasTimeSecs= (averageMainExtrasLength - averageMainExtrasTimeHours*3600-
                averageMainExtrasTimeMins*60);

        //averageMainsLength components
        averageMainTimeHours = averageMainLength/ 3600;
        averageMainTimeMins = (averageMainLength - averageMainTimeHours*3600)/60;
        averageMainTimeSecs = (averageMainLength - averageMainTimeHours*3600-
                averageMainTimeMins*60);



        //Formats total main time and total totaltime(aka main+extras time) in hours, mins, secs format
        tMainTimeMessage = totalMainTimeHours + "h " + totalMainTimeMins + "m " + totalMainTimeSecs +"s";
        tTotalTimeMessage = totalMainExtrasTimeHours + "h " + totalMainExtrasTimeMins + "m " + totalMainExtrasTimeSecs +"s";

        //Formats average main time and average total time (aka main+extras time) in hours, mins, secs format
        aMainTimeMessage = averageMainTimeHours + "h " + averageMainTimeMins + "m "
                + averageMainTimeSecs + "s";
        aTotalTimeMessage = averageMainExtrasTimeHours + "h " +averageMainExtrasTimeMins  + "m "
                + averageMainExtrasTimeSecs +"s";

        //Displays the data to the user to the locations specified in thr XML file
        TextView aMainTime = findViewById(R.id.Year);
        aMainTime.setText(aMainTimeMessage);
        TextView t100Time = findViewById(R.id.Time100);
        t100Time.setText(tTotalTimeMessage);
        TextView a100Time = findViewById(R.id.Console);
        a100Time.setText(aTotalTimeMessage);
        TextView tMainTime = findViewById(R.id.MainTime);
        tMainTime.setText(tMainTimeMessage);
        TextView pCompleted = findViewById(R.id.Completed);
        pCompleted.setText(""+ numberFormat.format(aCompleted) +"%" );
        TextView pInProgress = findViewById(R.id.InProgress);
        pInProgress.setText(""+ numberFormat.format(aInProgress) + "%");



    }

    @Override
    protected void onResume()
    {
        super.onResume();


    }

}
