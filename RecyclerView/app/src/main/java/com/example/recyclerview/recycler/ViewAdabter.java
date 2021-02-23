package com.example.recyclerview.recycler;

import android.media.Image;
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
    private OnItemClickListener clickListener;


    public interface OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView text1;
        public TextView text2;
        public ImageView delete;

        public viewHolder(@NonNull View itemView, OnItemClickListener clickListener) {
            super(itemView);

            image = itemView.findViewById(R.id.imageview);
            text1 = itemView.findViewById(R.id.textview1);
            text2 = itemView.findViewById(R.id.textview2);
            delete = itemView.findViewById(R.id.Image_delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            clickListener.onItemClick(position);
                        }
                    }
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            clickListener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public ViewAdabter(ArrayList<ViewClass> viewList) {
        this.viewList = viewList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);

        viewHolder holder = new viewHolder(v, clickListener);

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
