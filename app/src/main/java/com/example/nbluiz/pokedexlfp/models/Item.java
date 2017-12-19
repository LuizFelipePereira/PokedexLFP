package com.example.nbluiz.pokedexlfp.models;

/**
 * Created by nbLuiz on 19/12/2017.
 */


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Item {

    @SerializedName("name")
    private String name;

    @SerializedName("sprites")
    private SpriteItem sprites;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpriteItem getSprites() {
        return sprites;
    }

    public void setSprites(SpriteItem sprites) {
        this.sprites = sprites;
    }
}
