package com.nguyendinhdoan.mvpmandroid.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nguyendinhdoan.mvpmandroid.R;
import com.nguyendinhdoan.mvpmandroid.presenter.UserPresenter;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        addEvents();
    }

    private void initViews() {
        userPresenter = new UserPresenter();

        userNameEditText = findViewById(R.id.user_name_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.login_button);
    }

    private void addEvents() {
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_button) {
            handleLogin();
        }
    }

    private void handleLogin() {
        String userName = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        boolean isLoginSuccess = userPresenter.login(userName, password);
        if (isLoginSuccess) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

}
