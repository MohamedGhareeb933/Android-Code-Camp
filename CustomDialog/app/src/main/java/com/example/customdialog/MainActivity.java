package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements DialogFragmentManager.dialogListener {

    private Button dialogButton;
    private TextView usernameTextView;
    private TextView passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameTextView = findViewById(R.id.TextView_username);
        passwordTextView = findViewById(R.id.TextView_password);

        dialogButton = findViewById(R.id.Button_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExmapleDialog();
            }
        });
    }

    void ExmapleDialog() {
        DialogFragmentManager dialogManager = new DialogFragmentManager();
        dialogManager.show(getSupportFragmentManager(), "manager");
    }

    @Override
    public void applyText(String username, String password) {
        usernameTextView.setText(username);
        passwordTextView.setText(password);
    }
}
