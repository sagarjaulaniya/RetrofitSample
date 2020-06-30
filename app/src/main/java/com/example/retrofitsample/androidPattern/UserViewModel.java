package com.example.retrofitsample.androidPattern;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.widget.Toast;

public class UserViewModel extends ViewModel {
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    User user;
    Context context;

    public UserViewModel(User user, Context trialActivity) {
        this.user = user;
        this.context = trialActivity;
    }

    public void onSubmitClick() {
        user.setEmail(email.getValue());
        user.setPassword(password.getValue());

        Toast.makeText(context, "" + user.getEmail(), Toast.LENGTH_SHORT).show();
    }

}
