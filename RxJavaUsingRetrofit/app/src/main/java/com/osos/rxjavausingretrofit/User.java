package com.osos.rxjavausingretrofit;

import com.google.gson.annotations.SerializedName;

public class User {
String userid;
String id;
String title;
String completed;

    public User(String userid, String id, String title, String completed) {
        this.userid = userid;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }



    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }
}



