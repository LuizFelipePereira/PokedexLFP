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

    @SerializedName("base_experience")
    private String experience;

    @SerializedName("height")
    private String height;

    @SerializedName("weight")
    private String weight;

    @SerializedName("abilities")
    private List<Abilities> abilities = new ArrayList<>();

    @SerializedName("forms")
    private List<Forms> forms = new ArrayList<>();

    @SerializedName("moves")
    private List<Moves> moves = new ArrayList<>();

    @SerializedName("species")
    private List<Species> species = new ArrayList<>();

    @SerializedName("stats")
    private List<Stats> stats = new ArrayList<>();

    @SerializedName("types")
    private List<Types> pokeTypes = new ArrayList<>();

    @SerializedName("sprites")
    private List<Sprites> sprites = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public List<Forms> getForms() {
        return forms;
    }

    public void setForms(List<Forms> forms) {
        this.forms = forms;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public List<Species> getSpecies() {
        return species;
    }

    public void setSpecies(List<Species> species) {
        this.species = species;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }

    public List<Types> getPokeTypes() {
        return pokeTypes;
    }

    public void setPokeTypes(List<Types> pokeTypes) {
        this.pokeTypes = pokeTypes;
    }

    public List<Sprites> getSprites() {
        return sprites;
    }

    public void setSprites(List<Sprites> sprites) {
        this.sprites = sprites;
    }

    public String pokeTypesToString() {
        String types = "";
        for (int i = 0; i < pokeTypes.size(); i++) {
            if(i > 0)
                types += ", ";
            types += pokeTypes.get(1).getType().getName();
        }

        return types;
    }
}
