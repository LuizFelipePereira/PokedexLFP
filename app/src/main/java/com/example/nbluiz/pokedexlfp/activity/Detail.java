package com.example.nbluiz.pokedexlfp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nbluiz.pokedexlfp.API.ApiClient;
import com.example.nbluiz.pokedexlfp.API.ApiInterface;
import com.example.nbluiz.pokedexlfp.R;
import com.example.nbluiz.pokedexlfp.models.Pokemon;
import com.example.nbluiz.pokedexlfp.models.Sprite;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail extends AppCompatActivity {

    private TextView tvName, tvTypes, tvWeight, tvHeight, tvAbilities, tvMoviments;
    private ImageView ivPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = (TextView) findViewById(R.id.tv_detail_name);
        tvTypes = (TextView) findViewById(R.id.tv_detail_types);
        tvWeight = (TextView) findViewById(R.id.tv_detail_weight);
        tvHeight = (TextView) findViewById(R.id.tv_detail_Height);
        tvAbilities = (TextView) findViewById(R.id.tv_detail_abilities);
        tvMoviments = (TextView) findViewById(R.id.tv_detail_moviments);
        ivPokemon = (ImageView) findViewById(R.id.iv_detail_pokemon);

        int ID = getIntent().getIntExtra("ID", 0);
        carrega(ID);
    }

    private void carrega(int id) {
        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<Pokemon> call = apiService.getPokemon(id);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon pokemon;

                if(response.isSuccessful()) {
                    pokemon = response.body();

                    tvName.setText(pokemon.getName().toUpperCase());
                    tvTypes.setText("Type: " + pokemon.pokeTypesToString());
                    tvWeight.setText("Weight: " +pokemon.getWeight().toString());
                    tvHeight.setText("Height: " +pokemon.getHeight().toString());
                    tvAbilities.setText("abilities: " + pokemon.abilitiesToString());
                    tvMoviments.setText("Moviments: " + pokemon.movimentsToString());

                    Sprite sprite = pokemon.getSprites();
                    Picasso.with(ivPokemon.getContext())
                            .load(sprite.getFrontDefault())
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
