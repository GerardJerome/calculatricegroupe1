package com.example.calculatriceg1java;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.calculatriceg1java.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button buttonCalcul;
    private TextView monTextView;

    private Button boutonHistorique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCalcul = findViewById(R.id.button_calcul);
        monTextView = findViewById(R.id.textView);
        boutonHistorique = findViewById(R.id.bouton_historique);
        /*buttonCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        boutonHistorique.setOnClickListener(view -> {
            Intent intent = new Intent(this, HistoriqueActivity.class);
            startActivity(intent);
        });
        buttonCalcul.setOnClickListener(view -> {
            Toast.makeText(this, "j'affiche un toast", Toast.LENGTH_SHORT).show();
            monTextView.setText(getString(R.string.text_mon_textview));
            Intent intent = new Intent(this, ActivityCalcul.class);
            startActivity(intent);

        });
    }


}