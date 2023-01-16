package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView menos1_img;
    ImageView mas1_img;
    TextView contador1;
    int contador1_valor;

    ImageView menos2_img;
    ImageView mas2_img;
    TextView contador2;
    int contador2_valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menos1_img = (ImageView) findViewById(R.id.menos1_img);
        mas1_img = (ImageView) findViewById(R.id.mas1_img);
        contador1 = (TextView) findViewById(R.id.contador1);
        contador1_valor = 0;

        menos2_img = (ImageView) findViewById(R.id.menos2_img);
        mas2_img = (ImageView) findViewById(R.id.mas2_img);
        contador2 = (TextView) findViewById(R.id.contador2);
        contador2_valor = 0;

        if (savedInstanceState != null) {
            contador1_valor = savedInstanceState.getInt("contador1_estado");
            contador2_valor = savedInstanceState.getInt("contador2_estado");
            //Set the score text views
            contador1.setText(String.valueOf(contador1_valor));
            contador2.setText(String.valueOf(contador2_valor));
        }


        menos1_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador1_valor = Integer.parseInt((String) contador1.getText());
                contador1_valor--;
                if (contador1_valor >= 0) {
                    contador1.setText(contador1_valor + "");
                }
            }
        });

        mas1_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador1_valor = Integer.parseInt((String) contador1.getText());
                contador1_valor++;
                if (contador1_valor >= 0) {
                    contador1.setText(contador1_valor + "");
                }
            }
        });

        menos2_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador2_valor = Integer.parseInt((String) contador2.getText());
                contador2_valor--;
                if (contador2_valor >= 0) {
                    contador2.setText(contador2_valor + "");
                }
            }
        });

        mas2_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador2_valor = Integer.parseInt((String) contador2.getText());
                contador2_valor++;
                if (contador2_valor >= 0) {
                    contador2.setText(contador2_valor + "");
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        //Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if (item.getItemId() == R.id.night_mode) {
            AppCompatDelegate.getDefaultNightMode();
        }
        //Get the night mode state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        //Set the theme mode for the restarted activity
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        recreate();

        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Save the scores
        outState.putInt("contador1_estado", contador1_valor);
        outState.putInt("contador2_estado", contador2_valor);
        super.onSaveInstanceState(outState);
    }
}