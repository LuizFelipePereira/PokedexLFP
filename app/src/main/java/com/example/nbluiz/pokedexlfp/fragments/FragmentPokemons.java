package com.example.nbluiz.pokedexlfp.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.nbluiz.pokedexlfp.API.ApiClient;
import com.example.nbluiz.pokedexlfp.API.ApiInterface;
import com.example.nbluiz.pokedexlfp.R;
import com.example.nbluiz.pokedexlfp.Recycler.RecyclerTouchListener;
import com.example.nbluiz.pokedexlfp.activity.Detail;
import com.example.nbluiz.pokedexlfp.adapters.PokemonAdapter;
import com.example.nbluiz.pokedexlfp.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentPokemons extends Fragment {

    private List<Pokemon> pokeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pokemons,
                container, false);
        getActivity().setTitle("Pokemons");

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_pokemons);

        pokemonAdapter = new PokemonAdapter(pokeList);

        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(pokemonAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                startDetail(pokeList.get(position).getId());
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

       insertPokemon();

        return rootView;
    }

    private void insertPokemon() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        for(int i = 1; i <= 30; i++) {
            Call<Pokemon> call = apiService.getPokemon(i);
            call.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    if(response.isSuccessful()) {
                        Pokemon pokemon = response.body();

                        pokeList.add(pokemon);
                        pokemonAdapter.notifyDataSetChanged();

                        Log.i("POKEMON", "Name: " + pokemon.getName());
                        Log.i("POKEMON", "Height: " + pokemon.getHeight());
                        Log.i("POKEMON", "Weight: " + pokemon.getWeight());

                    }
                }
                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void startDetail(int id) {
        Intent i = new Intent(getActivity(), Detail.class);
        i.putExtra("ID", id);
        startActivity(i);
    }





}
