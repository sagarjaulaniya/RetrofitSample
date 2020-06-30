package com.example.retrofitsample.androidPattern;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    Context context;
    User user;

    public UserViewModelFactory(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new UserViewModel(user, context);
    }


}
