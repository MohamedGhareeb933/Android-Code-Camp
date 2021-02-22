package com.example.recyclerview.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class ViewAdabter extends RecyclerView.Adapter<ViewAdabter.viewHolder> {

    private ArrayList<ViewClass> viewList;

    public static class viewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView text1;
        public TextView text2;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageview);
            text1 = itemView.findViewById(R.id.textview1);
            text2 = itemView.findViewById(R.id.textview2);
        }
    }

    public ViewAdabter(ArrayList<ViewClass> viewList) {
        this.viewList = viewList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent);

        viewHolder holder = new viewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ViewClass viewClass = viewList.get(position);

        holder.image.setImageResource(viewClass.getImageRes());
        holder.text1.setText(viewClass.getText1());
        holder.text2.setText(viewClass.getText2());
    }

    @Override
    public int getItemCount() {
        return viewList.size();
    }
}
