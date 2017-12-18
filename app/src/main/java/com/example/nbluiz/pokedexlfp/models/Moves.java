package com.example.nbluiz.pokedexlfp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nbLuiz on 18/12/2017.
 */

public class Moves {

    @SerializedName("is_hidden")
    private String is_hidden;

    @SerializedName("move")
    private List<Move> move = new ArrayList<>();

    public String getIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(String is_hidden) {
        this.is_hidden = is_hidden;
    }

    public List<Move> getMove() {
        return move;
    }

    public void setMove(List<Move> move) {
        this.move = move;
    }
}
