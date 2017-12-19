package com.example.nbluiz.pokedexlfp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView tvName, tvTypes, tvAttack, tvDefense, tvSpeed;
    private ImageView ivPokemon;
    private int idPokemon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail,
                container, false);
        getActivity().setTitle("Detail Pokemon");

        tvName = (TextView) rootView.findViewById(R.id.tv_namePokemon);

        Bundle args = getArguments();
        idPokemon = args.getInt("idPokemon");

        List(idPokemon);

        return rootView;
    }

    private void List(int id) {
        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<Pokemon> call = apiService.getPokemon(id);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon pokemon;

                if(response.isSuccessful()) {
                    pokemon = response.body();

                    tvName.setText(pokemon.getName());
                    tvTypes.setText(pokemon.pokeTypesToString());
                    tvAttack.setText(pokemon.getWeight().toString());
                    tvDefense.setText(pokemon.getHeight().toString());
                    tvSpeed.setText(pokemon.getHeight().toString());


                    Sprite sprite = pokemon.getSprites();
                    String spriteUrl = sprite.getFront_default();

                    Call<Sprite> call2 = apiService.getSprite(spriteUrl);
                    String image = spriteUrl;

                    Picasso.with(ivPokemon.getContext())
                            .load(image)
                            .resize(128,128)
                            .into(ivPokemon);
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });
    }

}
