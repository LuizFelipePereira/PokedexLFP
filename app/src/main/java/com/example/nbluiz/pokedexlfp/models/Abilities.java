package com.example.nbluiz.pokedexlfp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nbLuiz on 18/12/2017.
 */

public class Abilities {
    @SerializedName("is_hidden")
    @Expose
    private String is_hidden;

    @SerializedName("slot")
    @Expose
    private Integer slot;

    @SerializedName("ability")
    @Expose
    private Ability ability;

    public Abilities(String is_hidden, Ability abilities) {
        this.is_hidden = is_hidden;
        this.ability =  abilities;
    }

    public String getIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(String is_hidden) {
        this.is_hidden = is_hidden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Ability getAbility() {

        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }



}
