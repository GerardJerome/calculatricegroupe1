package com.example.calculatriceg1java;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCalcul extends AppCompatActivity {
    private Button bouton0;
    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;
    private Button bouton8;
    private Button bouton9;
    private Button boutonPlus;
    private Button boutonMoins;
    private Button boutonFois;
    private Button boutonDivise;
    private TextView textViewCalcul;
    private TextView textViewResultat;
    private Integer premierTerme = 0;
    private Integer deuxiemeTerme = 0;
    private Integer resultat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcul);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bouton0 = findViewById(R.id.button0);
        bouton1 = findViewById(R.id.button1);
        bouton2 = findViewById(R.id.button2);
        bouton3 = findViewById(R.id.button3);
        bouton4 = findViewById(R.id.button4);
        bouton5 = findViewById(R.id.button5);
        bouton6 = findViewById(R.id.button6);
        bouton7 = findViewById(R.id.button7);
        bouton8 = findViewById(R.id.button8);
        bouton9 = findViewById(R.id.button9);
        boutonPlus = findViewById(R.id.buttonPlus);
        boutonMoins = findViewById(R.id.buttonMoins);
        boutonFois = findViewById(R.id.buttonFois);
        boutonDivise = findViewById(R.id.buttonDivise);
        textViewCalcul = findViewById(R.id.textview_calcul);
        textViewResultat = findViewById(R.id.textview_resultat);

        // TODO FAIRE EN SORTE QUE QUAND JE CLIQUE CA APPELLE AJOUTERCARACTERE

        bouton0.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton1.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton2.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton3.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton4.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton5.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton6.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton7.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton8.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton9.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        boutonPlus.setOnClickListener(view -> appuieBoutonOperation((Button) view));
        boutonMoins.setOnClickListener(view -> appuieBoutonOperation((Button) view));
        boutonFois.setOnClickListener(view -> appuieBoutonOperation((Button) view));
        boutonDivise.setOnClickListener(view -> appuieBoutonOperation((Button) view));

    }

    private TypeOperation typeOperation;

    private void appuieBoutonOperation(Button bouton){
        if (typeOperation == null){
            ajouterCaractere(bouton);
            modifieOperation(bouton.getText().toString());

        } else {
            Toast.makeText(this, getString(R.string.ERROR_TYPE_OPERATION), Toast.LENGTH_SHORT).show();
        }
    }

    private void modifieOperation(String symbole){
        switch (symbole){
            case "+":
                typeOperation = TypeOperation.ADD;
                break;
            case "-":
                typeOperation = TypeOperation.SUBSTRACT;
                break;
            case "*":
                typeOperation = TypeOperation.MULTIPLY;
                break;
            case "/":
                typeOperation = TypeOperation.DIVIDE;
                break;
        }
    }

    private void appuieBoutonChiffre(Button bouton){
        ajouterCaractere(bouton);
        modifierTerme(Integer.parseInt(bouton.getText().toString()));
    }

    private void modifierTerme(Integer aAjouter){
        if(typeOperation == null){
            premierTerme = 10 * premierTerme + aAjouter;
        } else {
            deuxiemeTerme = 10 * deuxiemeTerme + aAjouter;
        }
    }

    private void ajouterCaractere(Button bouton) {
        // TODO AJOUTER LE CARACTERE DANS LE TEXTVIEW
        textViewCalcul.setText(String.format("%s%s", textViewCalcul.getText().toString(), bouton.getText().toString()));
    }

    // FAIRE EN SORTE QUE LE BOUTON CALCULER DANS LE MENU MODIFIE MA
    // TEXTVIEWRESULTAT
    // AVEC LE RESULAT DE L'OPERATION
    private void faisLeCalcul(int a, int b){
        switch (typeOperation){
            case ADD:
                textViewResultat.setText(String.valueOf(premierTerme + deuxiemeTerme));
                break;
            case SUBSTRACT:
                textViewResultat.setText(String.valueOf(premierTerme - deuxiemeTerme));
                break;
            case MULTIPLY:
                textViewResultat.setText(String.valueOf(premierTerme * deuxiemeTerme));
                break;
            case DIVIDE:
                textViewResultat.setText(String.valueOf(premierTerme / deuxiemeTerme));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.monmenu, menu);
        MenuItem boutonReset = menu.findItem(R.id.bouton_reset);
        MenuItem boutonCalculer = menu.findItem(R.id.bouton_calculer);
        // JE RAJOUTE UN ITEM DANS MON MENU QUI AFFICHE UN TOAST QUAND JE CLIQUE DESSUS
        // IL AURA COMME CONTENU "CALCULER"

        boutonReset.setOnMenuItemClickListener(menuItem -> {
            textViewCalcul.setText("");
            textViewResultat.setText("");
            premierTerme = 0;
            deuxiemeTerme = 0;
            typeOperation = null;
            resultat = 0;
            return true;
        });

        boutonCalculer.setOnMenuItemClickListener(menuItem -> {
            faisLeCalcul(premierTerme, deuxiemeTerme);
            return true;
        });
        return super.onCreateOptionsMenu(menu);
    }
}