package com.example.pr_idi.mydatabaseexample;


import java.util.List;
import java.util.Random;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

public class MainActivity extends AppBasicActivity {
    private FilmData filmData;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvManager;
    private List<Film> films;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        filmData = new FilmData(this);
        filmData.open();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        rvManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvManager);
        String ordreAny = MySQLiteHelper.COLUMN_YEAR_RELEASE;
        rvAdapter = new MiRecyclerViewAdapter(filmData.getAllFilmsOrder(ordreAny));
        recyclerView.setAdapter(rvAdapter);
        Log.d("Main Activity", "--OnCreate--");
    }

   /* @Override
    public void onResume(){
        super.onResume();

        filmData = new FilmData(this);
        filmData.open();
        //String ordreAny = MySQLiteHelper.COLUMN_YEAR_RELEASE;
        films = this.filmData.getAllFilms();
        rvAdapter = new MiRecyclerViewAdapter(this.films);
        recyclerView.setAdapter(rvAdapter);
        Log.d("Adapter", "Adapter Set");

    }*/
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        filmData = new FilmData(this);
        filmData.open();

        List<Film> values = filmData.getAllFilms();

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Film> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    // Will be called via the onClick attribute
    // of the buttons in main.xml
    public void onClick(View view) {
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