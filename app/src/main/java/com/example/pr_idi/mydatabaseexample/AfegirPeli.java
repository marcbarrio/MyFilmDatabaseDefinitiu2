package com.example.pr_idi.mydatabaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AfegirPeli extends AppBasicActivity {

    FilmData filmData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afegir_peli);
        setTitle("Crear Peli");

        filmData = new FilmData(this);
        filmData.open();
        //filmData = new
    }
    public void onClick(View view){
        Film film = new Film();
        TextView textView;
        switch(view.getId()){
            case R.id.crear:
                textView = (EditText) findViewById(R.id.titolCreate);
                String title = textView.getText().toString();
                textView = (EditText) findViewById(R.id.directorCreate);
                String director = textView.getText().toString();
                textView = (EditText) findViewById(R.id.anyCreate);
                String anyText = textView.getText().toString();
                int any = Integer.parseInt(anyText);
                textView = (EditText) findViewById(R.id.paisCreate);
                String pais = textView.getText().toString();
                textView = (EditText) findViewById(R.id.protaCreate);
                String protagonista = textView.getText().toString();
                textView = (EditText) findViewById(R.id.notaCreate);
                String notaPeli = textView.getText().toString();
                int nota = Integer.parseInt(notaPeli);
                if(nota < 0 || nota > 10){
                    CharSequence notaText = "La nota de la peli ha d'estar entre 0 i 10";
                    int duration = Toast.LENGTH_SHORT;
                    Toast t = Toast.makeText(getApplicationContext(),notaText,duration);
                    t.show();
                }
                else {
                    film.setTitle(title);
                    film.setDirector(director);
                    film.setYear(any);
                    film.setCountry(pais);
                    film.setProtagonist(protagonista);
                    film.setCritics_rate(nota);
                    filmData.createFilm(film);
                    CharSequence notaCreada = "Pel·lícula creada";
                    int duration = Toast.LENGTH_SHORT;
                    Toast t = Toast.makeText(getApplicationContext(),notaCreada,duration);
                    t.show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                break;
            case R.id.cancel_create:
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                break;


        }
    }
}
