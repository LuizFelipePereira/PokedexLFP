package com.example.nbluiz.pokedexlfp.API;

/**
 * Created by nbLuiz on 18/12/2017.
 */


import com.example.nbluiz.pokedexlfp.models.Item;
import com.example.nbluiz.pokedexlfp.models.ListPokemon;
import com.example.nbluiz.pokedexlfp.models.Pokemon;
import com.example.nbluiz.pokedexlfp.models.Sprite;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/v2/pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") int id);

    @GET("{front_default}")
    Call<Sprite> getSprite(@Path("front_default") String front_default);

    @GET("api/v2/item/{id}")
    Call<Item> getItem(@Path("id") int id);

    @GET("api/v2/pokemon/")
    Call<ListPokemon> getPokemonList(@Query("limit")int limit, @Query("offset")int offset);


}
