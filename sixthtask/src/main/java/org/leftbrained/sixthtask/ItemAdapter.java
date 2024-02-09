package org.leftbrained.sixthtask;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.leftbrained.InfoActivity;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> itemsList;

    public ItemAdapter(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public ItemAdapter() {
        itemsList = new ArrayList<>();
    }

    @NonNull
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = itemsList.get(position);
        TextView nameText = holder.nameTextView;
        nameText.setText(item.name);
        RatingBar rating = holder.ratingBar;
        rating.setRating(item.stars);
        holder.itemView.setOnClickListener(
                v -> {
                    Intent intent = new Intent(v.getContext(), InfoActivity.class);
                    intent.putExtra("name", item.name);
                    intent.putExtra("rating", item.stars);
                    intent.putExtra("url", item.link);
                    v.getContext().startActivity(intent);
                }
        );
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public RatingBar ratingBar;


        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.articleName);
            ratingBar = itemView.findViewById(R.id.rating);
        }
    }
}
