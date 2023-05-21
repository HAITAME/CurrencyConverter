package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    Button b1;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.txtamount);
        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        b1 = findViewById(R.id.btn1);
        tvResult = findViewById(R.id.tvResult);


        String[] from = {"USD","MAD","EUR"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        String[] to = {"MAD","USD","EUR"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, to);
        sp2.setAdapter(ad1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double tot;
                Double montant = Double.parseDouble(ed1.getText().toString());

                if (sp1.getSelectedItem().toString().equals("USD") && sp2.getSelectedItem().toString().equals("MAD")) {
                    tot = montant * 10.2084;
                    /*Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();*/
                    tvResult.setText(String.valueOf(tot));
                }

                if (sp1.getSelectedItem().toString().equals("MAD") && sp2.getSelectedItem().toString().equals("USD")) {
                    tot = montant / 10.2084;
                    /*Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();*/
                    tvResult.setText(String.valueOf(tot));
                }
                if (sp1.getSelectedItem().toString().equals("USD") && sp2.getSelectedItem().toString().equals("EUR")) {
                    tot = montant * 0.9256;
                    /*Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();*/
                    tvResult.setText(String.valueOf(tot));
                }

                if (sp1.getSelectedItem().toString().equals("EUD") && sp2.getSelectedItem().toString().equals("USD")) {
                    tot = montant / 0.9256;
                    /*Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();*/
                    tvResult.setText(String.valueOf(tot));
                }

                if (sp1.getSelectedItem().toString().equals("EUR") && sp2.getSelectedItem().toString().equals("MAD")) {
                    tot = montant * 11.0304;
                    /*Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();*/
                    tvResult.setText(String.valueOf(tot));
                }

                if (sp1.getSelectedItem().toString().equals("MAD") && sp2.getSelectedItem().toString().equals("EUR")) {
                    tot = montant / 11.0304;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                    tvResult.setText(String.valueOf(tot));
                }

                if (sp1.getSelectedItem().toString() == sp2.getSelectedItem().toString()) {
                    tot = montant ;
                    /*Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();*/
                    tvResult.setText(String.valueOf(tot));
                }
            }
        });


    }
}