package com.rtj.mctrackerrebuild.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {


    @PrimaryKey(autoGenerate = true)
    private int id;
    private String username;
    private String password;

    public User(String name, String passWord) {
        this.id = 0;
        this.username = "Admin";
        this.password = "password";
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}