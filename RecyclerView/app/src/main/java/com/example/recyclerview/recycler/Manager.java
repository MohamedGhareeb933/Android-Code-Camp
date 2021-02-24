package com.example.recyclerview.recycler;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.R;

import java.util.ArrayList;

public class Manager {

    private ArrayList<ViewClass> viewList;
    private RecyclerView recyclerView;
    private ViewAdabter adapter;
    private RecyclerView.LayoutManager layoutManager;

    // get main activity
    private Activity activity;

    private Button insertButton;
    private Button removeButton;
    private EditText insertEditText;
    private EditText removeEditText;

    public Manager(Activity activity) {
        this.activity = activity;
    }

    public void RecyclerManager() {

        RecyclerViewManager();

        RecyclerViewInsertAndRemove();

    }

    private void RecyclerViewInsertAndRemove() {

        insertButton = activity.findViewById(R.id.Button_insert);
        removeButton = activity.findViewById(R.id.Button_remove);
        insertEditText = activity.findViewById(R.id.EditText_insert);
        removeEditText = activity.findViewById(R.id.EditText_remove);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get text from EdiText and map it to integer
                // and pass it as position argument in insert item method
                insertItem(Integer.parseInt(insertEditText.getText().toString()));
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(Integer.parseInt(removeEditText.getText().toString()));
            }
        });
    }


    public void RecyclerViewManager() {
        // pre define the elements of the list
        viewList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            viewList.add(new ViewClass(R.drawable.ic_baseline_cake_24, "line" + i, "line" + i));
        }

        // set adapter, find view and initialise
        recyclerView = (RecyclerView) activity.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(activity);
        adapter = new ViewAdabter(viewList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // implements the OnItemClickListener interface and override its methods
        adapter.setOnItemClickListener(new ViewAdabter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                viewList.get(position).changeText("Clicked");
                adapter.notifyItemChanged(position);
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }

        });
    }

    // insert item at specific location
    public void insertItem(int position) {
        if (position <= viewList.size() && position >= 0) {
            viewList.add(position ,new ViewClass(R.drawable.ic_baseline_cake_24, "line" + position, "line" + position));
            adapter.notifyItemInserted(position);
        }else {
            Toast.makeText(activity, "invalid Position", Toast.LENGTH_SHORT).show();
        }

    }

    // remove item at specific location
    public void removeItem(int position) {
        if (position <= viewList.size()) {
            viewList.remove(position);
            adapter.notifyItemRemoved(position);
        }else {
            Toast.makeText(activity, "invalid Position", Toast.LENGTH_SHORT).show();
        }
    }

}
