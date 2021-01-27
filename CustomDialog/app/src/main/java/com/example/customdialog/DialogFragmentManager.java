package com.example.customdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogFragmentManager extends AppCompatDialogFragment {
    private RelativeLayout relativeDialog;
    private EditText usernameEditText;
    private EditText passwordEditText;

    dialogListener dListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //relativeDialog = getActivity().findViewById(R.id.LinearLayout_dialogInfo);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater =  getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);
        builder.setView(view)
                .setTitle("LOGIN")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String username = usernameEditText.getText().toString();
                        String password = passwordEditText.getText().toString();
                        dListener.applyText(username, password); // pass variables to instance which is also to activity.
                    }
                });

        usernameEditText = view.findViewById(R.id.EditText_username);
        passwordEditText = view.findViewById(R.id.EditText_password);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) { // context is Activity instance.
        super.onAttach(context);

        try {
            dListener = (dialogListener) context; // dialog interface is equal to activity instance
        } catch (ClassCastException e) {
            // in case dialogListener didnt implemented
            throw new ClassCastException(context.toString() + "must Implement dialogListener interface to MainActivity First");
        }
    }

    public interface dialogListener{
        void applyText(String username, String password);
    }


}
