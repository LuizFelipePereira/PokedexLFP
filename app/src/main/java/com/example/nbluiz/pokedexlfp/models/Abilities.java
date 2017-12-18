package com.example.nbluiz.pokedexlfp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nbLuiz on 18/12/2017.
 */

public class Abilities {

    @SerializedName("is_hidden")
    private String is_hidden;

    @SerializedName("stat")
    private List<Stat> abilities = new ArrayList<>();

    public String getIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(String is_hidden) {
        this.is_hidden = is_hidden;
    }

    public List<Stat> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Stat> abilities) {
        this.abilities = abilities;
    }
}
