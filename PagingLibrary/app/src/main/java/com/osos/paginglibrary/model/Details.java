package com.osos.paginglibrary.model;

public class Details {

    String userid;
    int id;
    String title;
    String completed;

    public Details(String userid, int id, String title, String completed) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
