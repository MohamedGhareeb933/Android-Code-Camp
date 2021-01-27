package com.example.bottomsheet;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class MainActivity extends AppCompatActivity implements BottomSheetDialog.BottomSheetListener {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView_Clicked);

        Button OpenSheet = (Button) findViewById(R.id.button_sheet);
        OpenSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheet = new BottomSheetDialog();
                bottomSheet.show(getSupportFragmentManager(), "example Bottom Sheet ");
            }
        });
    }

    @Override
    public void onButtonClick(String Text) {
        mTextView.setText(Text);
    }
}
