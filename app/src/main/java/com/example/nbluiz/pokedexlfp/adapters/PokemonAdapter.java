package com.example.nbluiz.pokedexlfp.adapters;

import android.support.v7.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    private List<Pokemon> pokeList;

    public class PokeViewHolder extends RecyclerView.ViewHolder {
        public TextView name, type;
        public ImageView ivPokemon;

        public PokeViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name);
            ivPokemon = (ImageView) itemView.findViewById(R.id.iv_pokemon);
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
    public void onBindViewHolder(final PokeViewHolder holder, int position) {
        Pokemon pokemon = pokeList.get(position);
        holder.name.setText(pokemon.getName());

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Sprite sprite = pokemon.getSprites();
        String spriteUrl = sprite.getFrontDefault();

        Call<Sprite> call = apiService.getSprite(spriteUrl);
        String image = spriteUrl;

        Picasso.with(holder.ivPokemon.getContext())
                .load(image)
                .resize(64, 64)
                .into(holder.ivPokemon);

    }
}
