package com.example.recyclerview.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;

import java.util.ArrayList;


public class ViewAdabter extends RecyclerView.Adapter<ViewAdabter.viewHolder> {

    private ArrayList<ViewClass> viewList;

    // interface to keep the position of each element
    private OnItemClickListener clickListener;


    public interface OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    // view holder have the data of each item inside the Recycler view
    public static class viewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView text1;
        public TextView text2;
        public ImageView delete;

        // view holder constructor that have view and click listener interface
        public viewHolder(@NonNull View itemView, OnItemClickListener clickListener) {
            super(itemView);

            image = itemView.findViewById(R.id.imageview);
            text1 = itemView.findViewById(R.id.textview1);
            text2 = itemView.findViewById(R.id.textview2);
            delete = itemView.findViewById(R.id.Image_delete);

            // on click on each view/list-element get its position and pass it into the interface
            // Note : the adapter reference in the Manager have implementation to interface and override methods
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

    // inflating the layout and passing view into view holder param
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);

        viewHolder holder = new viewHolder(view, clickListener);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        // getting viewclass ref by its position
        ViewClass viewClass = viewList.get(position);

        // and get views and set the contents by viewclass ref we get from the list
        holder.image.setImageResource(viewClass.getImageRes());
        holder.text1.setText(viewClass.getText1());
        holder.text2.setText(viewClass.getText2());
    }

    // how many items in the recycler which is the number of elements in the list
    @Override
    public int getItemCount() {
        return viewList.size();
    }
}
