package com.example.retrofitsample.verificationProcess;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.retrofitsample.R;
import com.example.retrofitsample.databinding.ActivityVerifyBinding;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyActivity extends AppCompatActivity {
    VerifyApi verifyApi;
    private static final String SAFETY_NET_API_SITE_KEY = "6LeJn_UUAAAAAEozlGJ1jjNhmmd6o7iwEE3yocWs";
    private static final String SAFETY_NET_API_SECREAT_KEY = "6LeJn_UUAAAAABPvjdOIC6gDaQ48RVr_oJ_p0TUg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityVerifyBinding verifyBinding = DataBindingUtil.setContentView(this, R.layout.activity_verify);
        verifyApi = VerifyApi.retrofit.create(VerifyApi.class);

        verifyBinding.btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SafetyNet.getClient(VerifyActivity.this).verifyWithRecaptcha(SAFETY_NET_API_SITE_KEY)
                        .addOnSuccessListener(VerifyActivity.this, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                            @Override
                            public void onSuccess(SafetyNetApi.RecaptchaTokenResponse tokenResponse) {
                                String UserResponsetoken = tokenResponse.getTokenResult();
                                if (!UserResponsetoken.isEmpty()) {
                                    getValidate(UserResponsetoken);
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (e instanceof ApiException) {
                            ApiException apiException = (ApiException) e;
                            Log.d("TAG", "Error message: " +
                                    CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()));
                        } else {
                            Log.d("TAG", "Unknown type of error: " + e.getMessage());
                        }
                    }
                });
            }
        });
    }

    private void getValidate(String token) {
        Map<String, String> params = new HashMap<>();
        params.put("recaptcha-response", token);

        Call<String> validate = verifyApi.getVerification(params);
        validate.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Log.d("tagReCaptcha", "onResponse: " + response.code());
                    Log.d("reCaptcha", response.body());
                    Toast.makeText(VerifyActivity.this, "hey" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("Fail", "Error" + t.getMessage());
                Toast.makeText(VerifyActivity.this, "Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
