package com.example.nbluiz.pokedexlfp.models;

import java.util.ArrayList;

/**
 * Created by nbLuiz on 19/12/2017.
 */

public class ListPokemon extends Pokemon {
    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
