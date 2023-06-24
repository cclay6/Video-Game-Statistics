package OOD_project.gamestats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameViewer extends AppCompatActivity {

    private GlobalGameList globalGameList;
    private GameList copiedGameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_viewer);


        //initialize GlobalGameList object
        globalGameList= (GlobalGameList)getApplication();

        //create GameList object and copy the GameList in the global game list
        copiedGameList= new GameList();
        copiedGameList= globalGameList.getGameList();



//        TextView aMainTime = findViewById(R.id.Year);
//        aMainTime.setText(aMainTimeMessage);
//        TextView t100Time = findViewById(R.id.Time100);
//        t100Time.setText(tTotalTimeMessage);
//        TextView a100Time = findViewById(R.id.Console);
//        a100Time.setText(aTotalTimeMessage);
//        TextView tMainTime = findViewById(R.id.MainTime);
//        tMainTime.setText(tMainTimeMessage);
//        TextView pCompleted = findViewById(R.id.Completed);
//        pCompleted.setText(""+ numberFormat.format(aCompleted) +"%" );
//        TextView pInProgress = findViewById(R.id.InProgress);
//        pInProgress.setText(""+ numberFormat.format(aInProgress) + "%");
    }
}
