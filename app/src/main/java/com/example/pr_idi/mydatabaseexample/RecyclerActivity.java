package com.example.pr_idi.mydatabaseexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.List;

public class RecyclerActivity extends AppBasicActivity {
    private FilmData filmData;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvManager;
    private List<Film> films;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.main, null, false);
        drawer.addView(contentView,0);*/
        setContentView(R.layout.activity_recycler);
        setTitle("Recycler");
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

}
