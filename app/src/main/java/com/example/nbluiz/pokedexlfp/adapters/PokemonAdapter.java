package com.example.nbluiz.pokedexlfp.adapters;

import android.support.v7.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nbluiz.pokedexlfp.R;
import com.example.nbluiz.pokedexlfp.models.Pokemon;


/**
 * Created by nbLuiz on 17/12/2017.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokeViewHolder> {

    private List<Pokemon> pokeList;

    public class PokeViewHolder extends RecyclerView.ViewHolder {
        public TextView name, type;

        public PokeViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.pokemon_name);
            type = (TextView) itemView.findViewById(R.id.pokemon_type);
        }
    }

    public PokemonAdapter(List<Pokemon> pokemonList) {
        this.pokeList = pokemonList;
    }


    @Override
    public int getItemCount() {
        return pokeList.size();
    }

    @Override
    public PokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.pokemonrow, parent, false);

        return new PokeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PokeViewHolder holder, int position) {
        Pokemon pokemon = pokeList.get(position);
        holder.name.setText(pokemon.getName());
        holder.type.setText(pokemon.pokeTypesToString());
    }
}
