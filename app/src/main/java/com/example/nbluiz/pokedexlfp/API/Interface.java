package com.example.nbluiz.pokedexlfp.API;

/**
 * Created by nbLuiz on 18/12/2017.
 */

import com.example.nbluiz.pokedexlfp.models.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Interface {

    @GET("api/v2/pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") int id);
}
