package com.example.pr_idi.mydatabaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class DetailFilm extends AppBasicActivity {

    private FilmData filmData;
    private Film film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);
        setTitle("Detalls");

        filmData = new FilmData(this);
        filmData.open();

        List<Film> values = filmData.getAllFilms();

        //agafem el intent que ens han enviat amb el titol de la peli
        Intent intent = getIntent();
        String title = intent.getExtras().getString("titol");

        //separem el titol de la peli
        String[] separated = title.split("-");
        title = separated[0];
        title = title.replaceAll("\\s+$", ""); //eliminar espai final en blanc

        //busquem la pelicula en questio
        for (Film movie : values) {
            if (movie.getTitle().equals(title)){
                film = movie;
            }
        }

        TextView tv = (TextView) findViewById(R.id.titolDetail);
        tv.setText(film.getTitle());
        tv = (TextView) findViewById(R.id.directorDetail);
        tv.setText("Directed By: " + film.getDirector());
        tv = (TextView) findViewById(R.id.protaDetail);
        tv.setText("Main Actor: " + film.getProtagonist());
        tv = (TextView) findViewById(R.id.yearDetail);
        tv.setText("Release Year: " + String.valueOf(film.getYear()));
        tv = (TextView) findViewById(R.id.notaDetail);
        tv.setText(String.valueOf(film.getCritics_rate()) + "/10");


    }

    public void onClick(View view) {
        //@SuppressWarnings("unchecked")
        //ArrayAdapter<Film> adapter = (ArrayAdapter<Film>) getListAdapter();
        //Film film;
        switch (view.getId()) {
            case R.id.deleteButton:
                Log.d("Detail","delete1");
                filmData.deleteFilm(film);
                Log.d("Detail","delete2");
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                break;
        }

    }

}
