package com.example.nbluiz.pokedexlfp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nbLuiz on 18/12/2017.
 */

public class Type {
    @SerializedName("name")
    private String name;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
