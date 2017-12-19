package com.example.nbluiz.pokedexlfp.models;

/**
 * Created by nbLuiz on 17/12/2017.
 */

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Pokemon {

    @SerializedName("name")
    private String name;

    @SerializedName("height")
    private Integer height;

    @SerializedName("weight")
    private Integer weight;

    @SerializedName("sprites")
    private Sprite sprites;

    @SerializedName("types")
    private List<Type> pokeTypes = new ArrayList<>();

    @SerializedName("abilities")
    private List<Abilities> abilities = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    public List<Type> getPokeTypes() {
        return pokeTypes;
    }

    public void setPokeTypes(List<Type> pokeTypes) {
        this.pokeTypes = pokeTypes;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public String pokeTypesToString() {
        String types = "";
        for (int i = 0; i < pokeTypes.size(); i++) {
            if(i > 0)
                types += ", ";
            types += pokeTypes.get(i).getName();
        }

        return types;
    }
}
