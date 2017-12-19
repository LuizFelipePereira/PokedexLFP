package com.example.nbluiz.pokedexlfp.models;

/**
 * Created by nbLuiz on 19/12/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



/**
 * Created by nbLuiz on 18/12/2017.
 */

public class Moves {

    @SerializedName("move")
    @Expose
    private Move move;

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}
