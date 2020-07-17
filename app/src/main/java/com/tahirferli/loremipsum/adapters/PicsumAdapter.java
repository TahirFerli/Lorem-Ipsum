package com.tahirferli.loremipsum.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tahirferli.loremipsum.databinding.ListItemPicsumBinding;
import com.tahirferli.loremipsum.model.Picsum;

public class PicsumAdapter extends ListAdapter<Picsum, PicsumAdapter.ViewHolder> {

    public PicsumAdapter(@NonNull DiffUtil.ItemCallback<Picsum> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ViewHolder.from(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picsum picsum = getItem(position);
        holder.bind(picsum);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ListItemPicsumBinding binding;

        public ViewHolder(ListItemPicsumBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        static ViewHolder from(ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ListItemPicsumBinding binding = ListItemPicsumBinding
                    .inflate(inflater, parent, false);
            return new ViewHolder(binding);
        }

        void bind(Picsum picsum) {
            binding.setPicsum(picsum);
        }
    }
}
