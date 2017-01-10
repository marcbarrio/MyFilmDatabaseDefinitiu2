package com.example.pr_idi.mydatabaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Marc PC on 10/01/2017.
 */

public class Inici extends AppBasicActivity {
    private FilmData filmData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inici);
        setTitle("Inici");
        filmData = new FilmData(this);
        filmData.open();
        List<Film> values = filmData.getAllFilms();
        List<String> res = new LinkedList<>();
        Collections.sort(values, new Comparator<Film>() {
            @Override
            public int compare(Film film1, Film film2) {
                return film1.getTitle().compareTo(film2.getTitle());
            }
        });

        for (Film f : values){
            res.add(f.getTitle());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, res);

        final ListView lv = (ListView) findViewById(R.id.titlelist);
        lv.setAdapter(adapter);


        // use the SimpleCursorAdapter to show the
        // elements in a ListView

        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = adapterView.getAdapter().getItem(i).toString();
                Intent intent = new Intent(getApplicationContext(),PeliRateDelete.class);
                intent.putExtra("id",s);
                startActivity(intent);
            }
        });*/
    }

    @Override
    protected void onResume() {
        filmData.open();
        List<Film> values = filmData.getAllFilms();
        List<String> res = new LinkedList<>();
        Collections.sort(values, new Comparator<Film>() {
            @Override
            public int compare(Film f1, Film f2) {
                return f1.getTitle().compareTo(f2.getTitle());
            }
        });

        for (Film f : values){
            res.add(f.getTitle());
        }

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, res);

        final ListView lv = (ListView) findViewById(R.id.titlelist);
        lv.setAdapter(adapter);
        super.onResume();
    }
}
