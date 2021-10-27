package com.travelblog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputLayout;
import com.travelblog.http.BlogSharedPreferences;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout usernameLayout;
    private TextInputLayout passwordLayout;
    private Button loginButton;
    private ProgressBar progressBar;
    private BlogSharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameLayout = findViewById(R.id.usernameLayout);
        passwordLayout = findViewById(R.id.passwordLayout);
        loginButton = findViewById(R.id.loginButton);
        progressBar = findViewById(R.id.progressBar);
        preferences = new BlogSharedPreferences(this);

        if (preferences.isLoggedIn()) {
            startMainActivity();
            finish();
        }
        loginButton.setOnClickListener(v -> loginValidation());
        usernameLayout.getEditText().addTextChangedListener(createTextWatcher(usernameLayout));
        passwordLayout.getEditText().addTextChangedListener(createTextWatcher(passwordLayout));
    }

    private void loginValidation() {
        String username = usernameLayout.getEditText().getText().toString().trim();
        String password = passwordLayout.getEditText().getText().toString().trim();

        if (username.isEmpty()) {
            usernameLayout.setError("Please Enter Username!");
        } else if (password.isEmpty()) {
            passwordLayout.setError("Please Enter password!");
        } else if (username.equals("admin") && password.equals("admin")) {
            performLogin();
        } else {
            showErrorDialog();
        }
    }

    private void performLogin() {
        preferences.setLoggedIn(true);
        usernameLayout.setEnabled(true);
        passwordLayout.setEnabled(true);
        loginButton.setEnabled(true);
        progressBar.setVisibility(View.VISIBLE);

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startMainActivity();
            finish();
        }, 2000);
    }

    private void showErrorDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Login Failed!")
                .setMessage("Incorrect Login credentials, Enter valid username or password!")
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

    private void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    private TextWatcher createTextWatcher(TextInputLayout textInputLayout) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputLayout.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }
}
