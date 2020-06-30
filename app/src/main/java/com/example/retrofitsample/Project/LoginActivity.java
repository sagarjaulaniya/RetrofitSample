package com.example.retrofitsample.Project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.retrofitsample.R;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPassword;
    Button btnSubmit;
    ApiUtils apiUtils;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        apiUtils = NetworkHandle.getInstance().create(ApiUtils.class);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();
                login();
            }
        });
    }

    private void login() {
        Call<Response> responseCall = apiUtils.login(email, password);
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    Log.d("pass", "onResponse: " + response.body());
                    Response response1 = response.body();
                    Data data = response1.getData();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("fail", "onFailure: " + t.getMessage());
            }
        });
    }
}
