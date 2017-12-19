package com.example.nbluiz.pokedexlfp.fragments;


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
import com.example.nbluiz.pokedexlfp.adapters.ItemAdapter;
import com.example.nbluiz.pokedexlfp.adapters.PokemonAdapter;
import com.example.nbluiz.pokedexlfp.models.Item;
import com.example.nbluiz.pokedexlfp.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentItens extends Fragment {

    private List<Item> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_itens,
                container, false);
        getActivity().setTitle("Itens");

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_itens);

        itemAdapter = new ItemAdapter(itemList);

        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(itemAdapter);

        insertItem();

        return rootView;
    }

    private void insertItem() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        for(int i = 1; i <= 30; i++) {
            Call<Item> call = apiService.getItem(i);
            call.enqueue(new Callback<Item>() {
                @Override
                public void onResponse(Call<Item> call, Response<Item> response) {
                    if(response.isSuccessful()) {
                        Item item = response.body();

                        itemList.add(item);
                        itemAdapter.notifyDataSetChanged();

                        Log.i("POKEMON", "Name: " + item.getName());
                    }
                }
                @Override
                public void onFailure(Call<Item> call, Throwable t) {
                    Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


}
