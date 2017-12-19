package com.example.nbluiz.pokedexlfp.models;

/**
 * Created by nbLuiz on 17/12/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Pokemon {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("height")
    private Integer height;

    @SerializedName("weight")
    private Integer weight;

    @SerializedName("abilities")
    private List<Abilities> abilities = new ArrayList<>();

    @SerializedName("moves")
    @Expose
    private List<Moves> moves = null;

    @SerializedName("sprites")
    private Sprite sprites;

    @SerializedName("types")
    private List<Types> pokeTypes = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    public List<Types> getPokeTypes() {
        return pokeTypes;
    }

    public void setPokeTypes(List<Types> pokeTypes) {
        this.pokeTypes = pokeTypes;
    }

    public String pokeTypesToString() {
        String types = "";
        for (int i = 0; i < pokeTypes.size(); i++) {
            if(i > 0)
                types += ", ";
            types += pokeTypes.get(i).getType().getName();
        }

        return types;
    }

    public String abilitiesToString() {
        String ability = "";
        for (int i = 0; i < abilities.size(); i++) {
            if (i > 0)
                ability += ", ";
            ability += abilities.get(i).getAbility().getName();
        }
        return ability;
    }
    public String movimentsToString() {
        String move = "";
        for (int i = 0; i < moves.size(); i++) {
            if (i > 0)
                move += ", ";
            move += moves.get(i).getMove().getName();
        }
        return move;
    }

}
