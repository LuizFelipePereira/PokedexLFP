package com.example.nbluiz.pokedexlfp.models;

/**
 * Created by nbLuiz on 18/12/2017.
 */
import com.google.gson.annotations.SerializedName;

public class Sprites {

    @SerializedName("front_default")
    private String front_default;

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }
}