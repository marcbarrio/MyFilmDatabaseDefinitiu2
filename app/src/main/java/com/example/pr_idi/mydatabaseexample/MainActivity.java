package com.example.pr_idi.mydatabaseexample;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppBasicActivity {

    FilmData filmData;
    String ordre = MySQLiteHelper.COLUMN_YEAR_RELEASE;
   @Override
    public void onResume(){
       super.onResume();
       filmData.open();

        List<Film> values = filmData.getAllFilmsOrder(ordre);
        final ArrayAdapter<Film> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, values);
        ListView listView = (ListView) findViewById(R.id.list_main_activity);
        listView.setAdapter(adapter);

        Log.d("Main", "onResume");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle("Pel·licules");

        filmData = new FilmData(this);
        filmData.open();

        List<Film> values = filmData.getAllFilmsOrder(ordre);
        /*Collections.sort(values,new Comparator<Film>(){
            @Override
            public int compare(Film f1, Film f2){
                return f1.getTitle().compareTo(f2.getTitle());
            }
        });*/
        final ArrayAdapter<Film> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, values);
        ListView listView = (ListView) findViewById(R.id.list_main_activity);
        listView.setAdapter(adapter);
        Log.d("Main","onCreate");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String titol = adapterView.getAdapter().getItem(i).toString();
                Intent intent = new Intent(getApplicationContext(), DetailFilm.class);
                intent.putExtra("titol",titol);
                startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
        //@SuppressWarnings("unchecked")
        //ArrayAdapter<Film> adapter = (ArrayAdapter<Film>) getListAdapter();
        //Film film;
        switch (view.getId()) {
            case R.id.order_nota:
                ordre = MySQLiteHelper.COLUMN_CRITICS_RATE;
                Log.d("Ordre: ",ordre);
                onResume();
                //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                break;
            case R.id.order_title:
                ordre = MySQLiteHelper.COLUMN_TITLE;
                Log.d("Ordre: ",ordre);
                onResume();
                //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;
            case R.id.order_year:
                ordre = MySQLiteHelper.COLUMN_YEAR_RELEASE;
                Log.d("Ordre: ",ordre);
                onResume();
                //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;
        }
        /*Log.d("Main","typeoforder " + String.valueOf(typeofOrder));
        ordre = MySQLiteHelper.COLUMN_TITLE;
        List<Film> values = filmData.getAllFilmsOrder(ordre);
        for(int i = 0; i < values.size(); ++i){
            Log.d("Film ordered"+"i ",values.get(i).getTitle());
        }*/
    }

    // Will be called via the onClick attribute
    // of the buttons in main.xml
  /*  public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Film> adapter = (ArrayAdapter<Film>) getListAdapter();
        Film film;
        switch (view.getId()) {
            case R.id.add:
                String[] newFilm = new String[] { "Blade Runner", "Ridley Scott", "Rocky Horror Picture Show", "Jim Sharman", "The Godfather", "Francis Ford Coppola", "Toy Story", "John Lasseter" };
                int nextInt = new Random().nextInt(4);
                // save the new film to the database
                film = filmData.createFilm(newFilm[nextInt*2], newFilm[nextInt*2 + 1]);
                adapter.add(film);
                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    film = (Film) getListAdapter().getItem(0);
                    filmData.deleteFilm(film);
                    adapter.remove(film);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }
/*
    @Override
    protected void onResume() {
        filmData.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        filmData.close();
        super.onPause();
    }
*/
}