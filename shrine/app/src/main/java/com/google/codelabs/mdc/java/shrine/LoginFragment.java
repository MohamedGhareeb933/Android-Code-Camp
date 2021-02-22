package com.google.codelabs.mdc.java.shrine;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Fragment representing the login screen for Shrine.
 */
public class LoginFragment extends Fragment {

    private TextInputLayout passwordLayout;
    private TextInputEditText passwordEditText;
    private MaterialButton nextButton;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.shr_login_fragment, container, false);

        // Snippet from "Navigate to the next Fragment" section goes here.
        passwordLayout = view.findViewById(R.id.password_textinput_layout);
        passwordEditText = view.findViewById(R.id.passowrd_textinput_edittext);
        nextButton = view.findViewById(R.id.next_buuton);

        nextButtonClickListener();
        passowrdEditTextKeyListener();

        return view;
    }

    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
    private boolean isPasswordValid(@Nullable Editable text) {
        return text != null && text.length() >= 8;
    }

    private void nextButtonClickListener() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPasswordValid(passwordEditText.getText())){
                    passwordLayout.setError(getString(R.string.shr_error_password));
                }else {
                    passwordLayout.setError(null);
                    // false mean dont add this fragment to the back stack means once the user logged in cant back to login fragment again.
                    ((NavigationHost) getActivity()).navigateTo(new ProductGridFragment(), false);
                }
            }
        });
    }

    private void passowrdEditTextKeyListener() {
        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // Clear the error once more than 8 characters are typed.
                if(isPasswordValid(passwordEditText.getText())) {
                    passwordLayout.setError(null);
                }
                return false;
            }
        });
    }

}
