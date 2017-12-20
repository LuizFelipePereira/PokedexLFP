package com.example.nbluiz.pokedexlfp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.nbluiz.pokedexlfp.API.ApiClient;
import com.example.nbluiz.pokedexlfp.API.ApiInterface;
import com.example.nbluiz.pokedexlfp.R;
import com.example.nbluiz.pokedexlfp.models.Pokemon;
import com.example.nbluiz.pokedexlfp.models.Sprite;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by nbLuiz on 17/12/2017.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokeViewHolder> {

    private ArrayList<Pokemon> pokeList;
    private Context context;

    public void adicionar(ArrayList<Pokemon> listaPokemons) {
        pokeList.addAll(listaPokemons);
        notifyDataSetChanged();
    }

    public class PokeViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public ImageView ivPokemon;

        public PokeViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            ivPokemon = (ImageView) itemView.findViewById(R.id.iv_pokemon);
        }
    }

    public PokemonAdapter(Context context) {
        this.context = context;
        this.pokeList = new ArrayList<>();
    }


    @Override
    public int getItemCount() {
        return pokeList.size();
    }

    @Override
    public PokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemonrow,parent,false);

        return new PokeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PokeViewHolder holder, int position) {
        Pokemon pokemon = pokeList.get(position);
        holder.name.setText(pokemon.getName());

        Picasso.with(holder.ivPokemon.getContext())
                .load("http://pokeapi.co/media/sprites/pokemon/"+ pokemon.getId() + ".png")
                .resize(64, 64)
                .into(holder.ivPokemon);


    }
}
