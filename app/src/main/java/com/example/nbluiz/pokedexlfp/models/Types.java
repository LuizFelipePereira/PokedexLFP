package com.example.nbluiz.pokedexlfp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nbLuiz on 18/12/2017.
 */

public class Types {

    @SerializedName("type")
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
