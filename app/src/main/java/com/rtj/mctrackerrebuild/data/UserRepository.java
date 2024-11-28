package com.rtj.mctrackerrebuild.data;

import android.app.Application;

import com.rtj.mctrackerrebuild.dao.UserDao;
import com.rtj.mctrackerrebuild.entities.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRepository {
    private UserDao userDao;
    private ExecutorService executorService;

    public UserRepository(Application application) {
        ClientDBBuilder db = ClientDBBuilder.getDatabase(application);
        userDao = db.userDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(User user) {
        executorService.execute(() -> userDao.insert(user));
    }
    public void update(User user) {
        executorService.execute(() -> userDao.update(user));
    }
    public User getUser(String username, String password) {
        return userDao.getUser(username, password);
    }
    public User getUserByUserame(String username) {
        return userDao.getUserByName(username); }
}
