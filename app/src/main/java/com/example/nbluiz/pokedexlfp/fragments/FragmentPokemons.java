package com.example.nbluiz.pokedexlfp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nbluiz.pokedexlfp.API.Client;
import com.example.nbluiz.pokedexlfp.API.Interface;
import com.example.nbluiz.pokedexlfp.R;
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

        recyclerView.setAdapter(pokemonAdapter);

        return rootView;
    }



}
