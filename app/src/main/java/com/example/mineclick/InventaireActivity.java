package com.example.mineclick;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InventaireActivity extends AppCompatActivity {

    private int money = 0;
    private int lastpage = 0;
    private int nbpotion1 = 0;
    private int nbpotion2 = 0;
    private int nbpotion3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventaire);

        Context context = InventaireActivity.this;
        SharedPreferences sharedPref = InventaireActivity.this.getSharedPreferences("SaveData", Context.MODE_PRIVATE);
        int defaultValue = getResources().getInteger(R.integer.default_money);
        money = sharedPref.getInt(getString(R.string.saved_money), defaultValue);
        lastpage = sharedPref.getInt(getString(R.string.saved_page), defaultValue);
        nbpotion1 = sharedPref.getInt(getString(R.string.saved_potion1), defaultValue);
        nbpotion2 = sharedPref.getInt(getString(R.string.saved_potion2), defaultValue);
        nbpotion3 = sharedPref.getInt(getString(R.string.saved_potion3), defaultValue);
    }

    public void onClickRetour(View view) {
        if(lastpage == 2){
            Intent intent = new Intent(this, JouerActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }


    public void onClickPotion1(View view) {
        ((TextView) findViewById(R.id.description)).setText("Cette potion te permets de cliquer 4 fois plus vite durant 1 minute !");
        findViewById(R.id.utiliser1).setVisibility(View.VISIBLE);
        findViewById(R.id.nbpotion).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.nbpotion)).setText("x" + nbpotion1);
    }

    public void onClickPotion2(View view) {
        ((TextView) findViewById(R.id.description)).setText("Cette potion te permet d'infliger entre 300 et 600 clics d'un coup !");
        findViewById(R.id.utiliser2).setVisibility(View.VISIBLE);
        findViewById(R.id.nbpotion).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.nbpotion)).setText("x" + nbpotion2);
    }

    public void onClickPotion3(View view) {
        ((TextView) findViewById(R.id.description)).setText("Cette potion te permet d'utiliser l'autoclick pendant 30 secondes");
        findViewById(R.id.utiliser3).setVisibility(View.VISIBLE);
        findViewById(R.id.nbpotion).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.nbpotion)).setText("x" + nbpotion3);
    }
}
