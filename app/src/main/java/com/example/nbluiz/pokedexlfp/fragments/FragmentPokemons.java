package com.example.nbluiz.pokedexlfp.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
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
import com.example.nbluiz.pokedexlfp.models.ListPokemon;
import com.example.nbluiz.pokedexlfp.models.Pokemon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


public class FragmentPokemons extends Fragment {

    private ArrayList<Pokemon> pokeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;

    private int offset;
    private boolean apto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pokemons,
                container, false);
        getActivity().setTitle("Pokemons");

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_pokemons);

        pokemonAdapter = new PokemonAdapter(getActivity());

        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setHasFixedSize(true);

        //final GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                startDetail(pokeList.get(position).getId());
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItens = layoutManager.findFirstVisibleItemPosition();

                    if (apto) {
                        if ((visibleItemCount + pastVisibleItens) >= totalItemCount) {
                            Log.i(TAG, "Fim");

                            apto = false;
                            offset += 20;
                            insertPokemon(offset);
                        }

                    }
                }
            }
        });




        apto = true;
        offset = 0;
       insertPokemon(offset);

        return rootView;
    }


    private void insertPokemon(int offset) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

            Call<ListPokemon> call = apiService.getPokemonList(20,offset);
            call.enqueue(new Callback<ListPokemon>() {
                @Override
                public void onResponse(Call<ListPokemon> call, Response<ListPokemon> response) {
                    apto = true;
                    if(response.isSuccessful()) {
                        ListPokemon listPokemon = response.body();
                        ArrayList<Pokemon> listaPokemons = listPokemon.getResults();

                        pokemonAdapter.adicionar(listaPokemons);
                        pokeList.add(listPokemon);
                        pokemonAdapter.notifyDataSetChanged();
                    }
                    else {
                        Log.e(TAG,"ON FAILURE" + response.errorBody());

                    }

                }
                @Override
                public void onFailure(Call<ListPokemon> call, Throwable t) {
                    apto = true;
                    Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

    }

    private void startDetail(int id) {
        Intent i = new Intent(getActivity(), Detail.class);
        i.putExtra("ID", id);
        startActivity(i);
    }





}
