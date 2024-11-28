package com.rtj.mctrackerrebuild.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.rtj.mctrackerrebuild.entities.User;

    @Dao
    public interface UserDao {
    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Query("SELECT * FROM user_table WHERE username = :username AND password = :password LIMIT 1")
    User getUser(String username, String password);

    @Query("SELECT * FROM user_table WHERE username =:username LIMIT 1")
    User getUserByName(String username);


    }
