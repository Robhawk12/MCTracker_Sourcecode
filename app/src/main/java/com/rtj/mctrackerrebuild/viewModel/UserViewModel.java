package com.rtj.mctrackerrebuild.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.rtj.mctrackerrebuild.data.Repository;
import com.rtj.mctrackerrebuild.data.UserRepository;
import com.rtj.mctrackerrebuild.entities.User;

public class UserViewModel extends ViewModelProvider.AndroidViewModelFactory {
    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application){
        super(application);
        userRepository = new UserRepository(application);
    }
    public void insert(User user){
        userRepository.insert(user);
    }
    public void update(User user){
      userRepository.update(user);
    }
    public User getUser(String username,String password){
        return userRepository.getUser(username,password);
    }
    public User getSingleUser() {
        return userRepository.getSingleUser(); }
}
