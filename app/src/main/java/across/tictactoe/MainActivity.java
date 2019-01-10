package across.tictactoe;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // xross for 0 ,circlu for 1
    boolean game;
    Button b1;
    LinearLayout li;
    GridLayout grid;

    int Activeplayer =0;

    //2 means unplayed

    int[]gamefil ={2,2,2,2,2,2,2,2,2};

   int [][] getposition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameover =false;


    public void start(View view) {
        b1.setVisibility(View.INVISIBLE);
       grid.setVisibility(View.VISIBLE);
    }
public void drop(View view) {

    ImageView counter = (ImageView) view;
    System.out.println(counter.getTag().toString());
    int tap = Integer.parseInt(counter.getTag().toString());


    if (gamefil[tap] == 2 && !gameover) {

        gamefil[tap] = Activeplayer;

        counter.setTranslationY(-1000f);

        if (Activeplayer == 0) {

            counter.setImageResource(R.drawable.tac);
            Activeplayer = 1;
        } else {
            counter.setImageResource(R.drawable.tic);
            Activeplayer = 0;
        }
        counter.animate().translationYBy(1000f).setDuration(400);

        for (int[] getpositions : getposition) {


            String msg = "";
            if (gamefil[getpositions[0]] == gamefil[getpositions[1]]
                    && gamefil[getpositions[1]] == gamefil[getpositions[2]]
                    && gamefil[getpositions[0]] != 2) {

                if (Activeplayer == 0)
                    msg = "yellow is winer";


                if (Activeplayer == 1)
                    msg = "red is winer";


                //someone has won
                LinearLayout li = (LinearLayout) findViewById(R.id.liner);
                li.setVisibility(View.VISIBLE);

                TextView t1 = (TextView) findViewById(R.id.t1);
                t1.setText(msg);

                gameover = true;

            } else {
                 game =true;

                for (int counters : gamefil){
                    if (counters == 2) game = false;

            }
            if(game){

                LinearLayout li = (LinearLayout) findViewById(R.id.liner);
                li.setVisibility(View.VISIBLE);

                TextView t1 = (TextView) findViewById(R.id.t1);
                t1.setText("It's a drow");

            }

            }
        }

    }
}

    public void playAgain(View view){

        LinearLayout li=(LinearLayout)findViewById(R.id.liner);
        li.setVisibility(View.INVISIBLE);

        gameover =false;
        Activeplayer =0;

        for(int i=0; i< gamefil.length; i++)
            gamefil[i]=2;

        GridLayout grid=(GridLayout)findViewById(R.id.grid);
        for(int i=0; i<grid.getChildCount();i++)
            ((ImageView)grid.getChildAt(i)).setImageResource(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         li =(LinearLayout) findViewById(R.id.liner);
        li.setVisibility(View.INVISIBLE);
        b1= (Button) findViewById(R.id.button2);
        grid= (GridLayout) findViewById(R.id.grid);
    }


}
