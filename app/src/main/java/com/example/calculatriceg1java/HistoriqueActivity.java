package com.example.calculatriceg1java;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculatriceg1java.database.CalculBaseHelper;
import com.example.calculatriceg1java.database.CalculDao;
import com.example.calculatriceg1java.entities.Calcul;

public class HistoriqueActivity extends AppCompatActivity {
    private TextView textViewDernierCalcul;
    private TextView textViewNombreCalcul;
    private CalculDao calculDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_historique);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewDernierCalcul = findViewById(R.id.textView_dernier_calcul);
        textViewNombreCalcul = findViewById(R.id.textView_nbcalcul);
        calculDao = new CalculDao(new CalculBaseHelper(this,"dbg1",1));
        long nombreCalcul = calculDao.count();
        Calcul dernierCalcul = calculDao.lastOrNull();
        textViewNombreCalcul.setText(String.format(getString(R.string.TEXT_NOMBRE_CALCUL),nombreCalcul));
        if(dernierCalcul!=null){
            String maChaine = dernierCalcul.getPremierElement()+
                    " "+dernierCalcul.getSymbole()
                    +""+ dernierCalcul.getDeuxiemeELement()
                    +" = "+ dernierCalcul.getResultat();
            textViewDernierCalcul.setText(String.format(getString(R.string.TEXT_DERNIER_CALCUL),maChaine));
        }

    }
}