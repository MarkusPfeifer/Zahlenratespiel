package at.pfeifer.zahlenratespiel;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewSchritte;
    private EditText editTextNumber;
    private EditText editTextBereich;
    private Button btnPrüf;
    private int rndNumb;
    private int Bereich;
    private double anzSchritte;
    private int verbSchritte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        editTextBereich = (EditText) findViewById((R.id.editTextBereich));
        btnPrüf = (Button) findViewById(R.id.pruefBtn);

        textViewSchritte = (TextView) findViewById(R.id.textViewSchritte);

        Bereich = Integer.valueOf(editTextBereich.getText().toString());

        Random r = new Random();
        rndNumb = r.nextInt(Bereich);

        anzSchritte = (Math.log(Bereich) / Math.log(2));

        verbSchritte = (int) (anzSchritte + 0.5);

        //String rndNumber = String.valueOf(rndNumb);

        //Toast.makeText(MainActivity.this,rndNumber, Toast.LENGTH_LONG).show();

        textViewSchritte.setText("Schritte für optimale Lösung: " + verbSchritte );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickPruefen(View view){

        verbSchritte = verbSchritte - 1;

        textViewSchritte.setText("Schritte für optimale Lösung: " + verbSchritte);

        int playerNumb = Integer.valueOf(editTextNumber.getText().toString());

        if(playerNumb != rndNumb){

            if(playerNumb < rndNumb){

                Toast.makeText(MainActivity.this,"Die gesuchte Zahl ist größer", Toast.LENGTH_LONG).show();
            }
            else{

                Toast.makeText(MainActivity.this,"DIe gesuchte Zahl ist kleiner", Toast.LENGTH_LONG).show();
            }
        }
        else{

            Toast.makeText(MainActivity.this,"Herzliche Gratulation!, Sie haben die richtige Zahl erraten", Toast.LENGTH_LONG).show();
        }
    }
}
