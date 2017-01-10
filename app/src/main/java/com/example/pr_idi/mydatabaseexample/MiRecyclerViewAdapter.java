package com.example.pr_idi.mydatabaseexample;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Marc PC on 07/01/2017.
 */

public class MiRecyclerViewAdapter extends RecyclerView.Adapter<MiRecyclerViewAdapter.CustomViewHolder> {

    private List<Film> films;
    //private Context miContext;
    private View v;


    public MiRecyclerViewAdapter(List<Film> films){
        this.films = films;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.film_row, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i){
        Film film = films.get(i);
        customViewHolder.HolderTitle.setText(film.getTitle());
        customViewHolder.HolderDirector.setText(film.getDirector());
        customViewHolder.HolderAny.setText(String.valueOf(film.getYear()));
        Log.d("onBindBiewHolder", film.getTitle());
    }

    @Override
    public int getItemCount(){
        return films.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder
            /*implements View.OnClickListener, View.OnLongClickListener*/ {
        private Film HolderFilm;
        public TextView HolderTitle, HolderDirector, HolderAny;
        //tvDirector, tvProtagonist;

        public CustomViewHolder (View view) {
            super(view);
            //faltar posar-ho al xml
            this.HolderTitle = (TextView) view.findViewById(R.id.titleTextView);
            this.HolderDirector = (TextView) view.findViewById(R.id.directorTextView);
            this.HolderAny = (TextView) view.findViewById(R.id.anyTextView);

           /* view.setOnClickListener(this);
            view.setOnLongClickListener(this);*/
        }

        /*public void lligarFilm(Film film){
            HolderFilm = film;
            HolderTitle.setText(HolderFilm.getTitle());
            HolderDirector.setText(HolderFilm.getDirector());
            HolderAny.setText(HolderFilm.getYear());

        }*/
    }
}
