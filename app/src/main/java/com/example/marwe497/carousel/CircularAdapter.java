package com.example.marwe497.carousel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CircularAdapter extends RecyclerView.Adapter<CircularAdapter.ItemViewHolder> {


    private ArrayList<ListItem> itemList;
    private Context context;

    public CircularAdapter(ArrayList<ListItem> list, Context context) {
        itemList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View ItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        ItemViewHolder viewHolder = new ItemViewHolder(ItemView);

        return viewHolder;
    }


    public ListItem getItem(int position){
        return itemList.get(position%itemList.size());
    }

    @Override
    public void onBindViewHolder(@Nullable ItemViewHolder viewHolder, int position) {
        viewHolder.imageView.setImageResource(getItem(position).getImgDrawable());
        viewHolder.txtview.setText(getItem(position).getText());
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtview;

        public ItemViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.imageView_image);
            txtview=view.findViewById(R.id.textView);
        }
    }
}
