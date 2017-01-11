package com.example.pr_idi.mydatabaseexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class About extends AppBasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView tv = (TextView) findViewById(R.id.titol_about);
        tv.setText("Who?");
        tv = (TextView) findViewById(R.id.nom_alumne1);
        tv.setText("Marc Barrio");
        tv = (TextView) findViewById(R.id.nom_alumne2);
        tv.setText("Òscar Fernàndez");
        tv = (TextView) findViewById(R.id.desc);
        tv.setText("Computer Engineer Students at 'Facultat d'Informàtica de Barcelona'.");
        tv = (TextView) findViewById(R.id.why);
        tv.setText("Why?");
        tv = (TextView) findViewById(R.id.why_desc);
        tv.setText("We did it because of an assigment for the subject IDI.");
    }

}
