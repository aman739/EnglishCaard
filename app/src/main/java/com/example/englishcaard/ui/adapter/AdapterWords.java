package com.example.englishcaard.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.englishcaard.databinding.ItemWordsBinding;
import com.example.englishcaard.network.model.Hits;

import java.util.ArrayList;
import java.util.List;

public class AdapterWords extends RecyclerView.Adapter<AdapterWords.HolderWords> {

    List<Hits> list = new ArrayList<>();


    @NonNull
    @Override
    public HolderWords onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderWords(ItemWordsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterWords.HolderWords holder, int position) {
        holder.onBind(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Hits> list) {
        this.list = list;
    }

    public class HolderWords extends RecyclerView.ViewHolder {
        ItemWordsBinding binding;

        public HolderWords(@NonNull ItemWordsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void onBind(Hits hits) {
            Glide.with(binding.ivWords).load(hits.getLargeImageURL()).into(binding.ivWords);
        }
    }
}
