package com.example.recyclerview.recycler;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.R;

import java.util.ArrayList;

public class Manager {

    private ArrayList<ViewClass> viewList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    Context context;

    public Manager(Context context) {
        this.context = context;
    }

    public void RecyclerManager() {
        viewList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            viewList.add(new ViewClass(R.drawable.ic_baseline_cake_24, "line" + i, "line" + i));
        }

        recyclerView.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        adapter = new ViewAdabter(viewList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
