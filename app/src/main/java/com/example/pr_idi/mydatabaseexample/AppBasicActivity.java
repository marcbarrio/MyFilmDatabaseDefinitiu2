package com.example.pr_idi.mydatabaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.List;

public class AppBasicActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //protected DrawerLayout drawer;
    //private NavigationView navigationView;
    //private Toolbar toolbar;
    FilmData filmData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_app_basic);
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        filmData = new FilmData(this);
        filmData.open();
        Log.d("Base Activity","OnCreate");
       /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        setView();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app_basic, menu);
        Log.d("Base","onCreateOptionsMenu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.d("Base","onOptionsItemSelected");
        switch (id){
            case R.id.random_films:
                String ordreAny = MySQLiteHelper.COLUMN_YEAR_RELEASE;
                List<Film> films = filmData.getAllFilms();
                for(Film f : films){
                    filmData.deleteFilm(f);
                }
                Film film = new Film();
                film.setDirector("David Fincher");
                film.setTitle("Fight Club");
                film.setCountry("USA");
                film.setYear(1999);
                film.setProtagonist("Brad Pitt");
                film.setCritics_rate(8);
                filmData.createFilm(film);
                film.setDirector("Francis Ford Coppola");
                film.setTitle("The GodFather");
                film.setCountry("USA");
                film.setYear(1972);
                film.setProtagonist("Marlon Brando");
                film.setCritics_rate(10);
                filmData.createFilm(film);
                film.setDirector("Steven Spielberg");
                film.setTitle("The Schindler's List");
                film.setCountry("USA");
                film.setYear(1993);
                film.setProtagonist("Liam Neeson");
                film.setCritics_rate(9);
                filmData.createFilm(film);
                film.setDirector("Roberto Benigni");
                film.setTitle("La vita è bella");
                film.setCountry("Italia");
                film.setYear(1997);
                film.setProtagonist("Roberto Benigni");
                film.setCritics_rate(8);
                filmData.createFilm(film);
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;


        }

        //noinspection SimplifiableIfStatement
       /* switch(id){
            case R.id.infoApp:
                startActivity(new Intent(getApplicationContext(),info.class));
                break;
        }
*/
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Log.d("ID:",String.valueOf(id));
        Log.d("Base","onNavItemSel");
        switch(id){
            case R.id.iniHome:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;
            case R.id.database:
                Log.d("fdghsdgfds","sdfgwse");
                startActivity(new Intent(getApplicationContext(), RecyclerActivity.class));
                break;

            case R.id.afegir_peli:
                startActivity(new Intent(getApplicationContext(),AfegirPeli.class));
                break;
            case R.id.help:
                startActivity(new Intent(getApplicationContext(), help.class));
                break;
            case R.id.About:
                startActivity(new Intent(getApplicationContext(),About.class));
                break;
            /*case R.id.cercar:
                startActivity(new Intent(getApplicationContext(),Cercar.class));
                break;
*/
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

   @Override
    public void setContentView(int layoutResID) {
        Log.d("Base","setContentView");
        DrawerLayout fullLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_app_basic, null);
        FrameLayout frameLayout = (FrameLayout) fullLayout.findViewById(R.id.frame_layout_drawer);

        getLayoutInflater().inflate(layoutResID, frameLayout, true);

        super.setContentView(fullLayout);
        setView();
    }

    protected void setView() {
        Log.d("Base","setView");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

}