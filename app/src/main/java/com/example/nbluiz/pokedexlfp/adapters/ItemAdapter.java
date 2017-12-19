package com.example.nbluiz.pokedexlfp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nbluiz.pokedexlfp.API.ApiClient;
import com.example.nbluiz.pokedexlfp.API.ApiInterface;
import com.example.nbluiz.pokedexlfp.R;
import com.example.nbluiz.pokedexlfp.models.Item;
import com.example.nbluiz.pokedexlfp.models.Pokemon;
import com.example.nbluiz.pokedexlfp.models.Sprite;
import com.example.nbluiz.pokedexlfp.models.SpriteItem;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;

/**
 * Created by nbLuiz on 19/12/2017.
 */

public class ItemAdapter  extends RecyclerView.Adapter<ItemAdapter.PokeViewHolder> {

    private List<Item> itemList;

    public class PokeViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView ivItem;

        public PokeViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_name_item);
            ivItem = (ImageView) itemView.findViewById(R.id.tv_imagem_item);
        }
    }

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public ItemAdapter.PokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.itemrow, parent, false);

        return new ItemAdapter.PokeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PokeViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.name.setText(item.getName());

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        SpriteItem sprite = item.getSprites();
        String spriteUrl = sprite.getFront_default();

        Call<Sprite> call = apiService.getSprite(spriteUrl);
        String image = spriteUrl;

        Picasso.with(holder.ivItem.getContext())
                .load(image)
                .resize(64, 64)
                .into(holder.ivItem);

    }


}
