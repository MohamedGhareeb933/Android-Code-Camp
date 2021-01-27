package com.example.undo;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {


    //Stack<Integer> undo ;
    Stack<Integer> undoNumber;
    Stack<Integer> undoKey;

    public static int text1Int = 0;
    public static int text2Int = 0;
    TextView text1;
    TextView text2;
    TextView text3;

    Button button1Increase;
    Button button1Decrease;
    Button Button2Increase;
    Button Button2Decrease;
    Button buttonUndo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //undo = new Stack<Integer>();
        undoNumber = new Stack<Integer>();
        undoKey = new Stack<Integer>();

          text1 = (TextView) findViewById(R.id.textView_1);
          text2 = (TextView) findViewById(R.id.textView_2);
          text3 = (TextView) findViewById(R.id.textView_undo);

        button1Increase = (Button) findViewById(R.id.button1_increase);
        button1Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                undoNumber.push(text1Int);
                undoKey.push(1);

                text1Int++;
                text1.setText("" + text1Int);
            }
        });

        button1Decrease = (Button) findViewById(R.id.button1_decrease);
        button1Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                undoNumber.push(text1Int); // push var  into the stack
                undoKey.push(1); // push key into the stack

                if(text1Int == 0) {
                    return;
                }else { text1Int--; }
                text1.setText("" + text1Int);



            }
        });

        Button2Increase = (Button) findViewById(R.id.button2_increase);
        Button2Increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                undoNumber.push(text2Int);
                undoKey.push(2);

                text2Int++;
                text2.setText("" + text2Int);
            }
        });

        Button2Decrease = (Button) findViewById(R.id.button2_decrease);
        Button2Decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                undoNumber.push(text2Int);
                undoKey.push(2);

                if(text2Int == 0) {
                    return;
                }else { text2Int --; }
                text2.setText("" + text2Int);
            }
        });


        buttonUndo = (Button) findViewById(R.id.button_undo);
        buttonUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!undoNumber.isEmpty()) {
                    if (undoKey.peek() == 1) { // checks if the undoKey first elements is equal to 1 without removing the key
                        undoKey.pop(); // remove the key
                        text1Int = (int) undoNumber.pop(); // set integer to the last stack elemet
                        text1.setText("" + text1Int); // change the text
                    } else if (undoKey.peek() == 2) {
                        undoKey.pop();
                        text2Int = (int) undoNumber.pop();
                        text2.setText("" + text2Int);
                    }
                }
            }
        });


    }



/**
    public int  undoManager () { // CALL THE METHOD ON EVERY CLICK. MOVE TO ONCLICK

        int getStack = 0;
        undo.push(undoManager.peek());

        if(!undoManager.isEmpty()) {
            getStack = (int) undoManager.peek();
        }
        //for(int index = 0; index < undo.size(); index++)

        return getStack;
    }

    public int undo() {

        int getStack = undoManager();

        return 0;

    }

    public int redo() { // CALL THE METHOD ON EVERY CLICK. MOVE TO ONCLICK

        return 0;
    }

    /**
     * @param command  define the order of Clicked
     * @param history define the information
     * @param key the key of the varaible
     * @param seen is Variables is being modeifyed.
    public int undo(int command, int history, int key, boolean seen) {

        int gethistory;

        switch (command) {
            case 1:
                if (key == 1) {
                    if (seen == true) {

                    }
                }
                break;
        }


        return 0;
    }*/


}
