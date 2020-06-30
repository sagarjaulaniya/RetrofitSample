package com.example.retrofitsample.androidPattern;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.retrofitsample.R;
import com.example.retrofitsample.databinding.ActivityMVVMBinding;


public class TrialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMVVMBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_m_v_v_m);

        UserViewModel userViewModel = ViewModelProviders.of(this, new UserViewModelFactory(this, new User())).get(UserViewModel.class);
        binding.setUsermodel(userViewModel);
    }
}
