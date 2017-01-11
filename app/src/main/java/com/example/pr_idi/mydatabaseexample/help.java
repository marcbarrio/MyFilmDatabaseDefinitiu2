package com.example.pr_idi.mydatabaseexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class help extends AppBasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        TextView tv = (TextView) findViewById(R.id.titol_help);
        tv.setText("Ajuda");
        tv = (TextView) findViewById(R.id.explicacio_help);
        tv.setText("On the left menu we have different options: 1st-Home: We can click the different films we" +
                " have and we will have a detailed information about the film plus we'll be able to delete" +
                " it from the database. 2nd-Show the diferent films we have in the database right now" +
                " in a beautiful way ordered by year of release (using a recycler view). 3rd-Shows " +
                "a screen to add a new film. 4th- We can search a film by actor");

    }


}
