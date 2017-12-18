package com.example.nbluiz.pokedexlfp.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nbLuiz on 18/12/2017.
 */

public class Stats {

    @SerializedName("base_stat")
    private String status;

    @SerializedName("effort")
    private String effort;

    @SerializedName("stat")
    private List<Stat> abilities = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEffort() {
        return effort;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }

    public List<Stat> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Stat> abilities) {
        this.abilities = abilities;
    }
}
