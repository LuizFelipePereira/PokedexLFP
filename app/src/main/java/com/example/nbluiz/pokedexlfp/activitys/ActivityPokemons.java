package com.example.nbluiz.pokedexlfp.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nbluiz.pokedexlfp.R;
import com.example.nbluiz.pokedexlfp.adapters.PokemonAdapter;
import com.example.nbluiz.pokedexlfp.models.Pokemon;

import java.util.List;
import java.util.ArrayList;

public class ActivityPokemons extends AppCompatActivity {

    private List<Pokemon> pokeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemons);

        recyclerView = (RecyclerView) findViewById(R.id.rv_pokemons);

        pokemonAdapter = new PokemonAdapter(pokeList);

        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(pokemonAdapter);

        addData();
    }
    private void addData() {
        Pokemon poke;

        poke = new Pokemon("Bulbasaur", "Grama");
        pokeList.add(poke);

        poke = new Pokemon("Charmander", "Fogo");
        pokeList.add(poke);

        poke = new Pokemon("Squirtle", "Água");
        pokeList.add(poke);

        pokemonAdapter.notifyDataSetChanged();
    }
}
