package com.osos.rxjavausingretrofit;

public class User {
String status;
EmbeddedData data;

    public User(String status, EmbeddedData data) {
        this.status = status;
        this.data = data;
    }

    public User() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmbeddedData getData() {
        return data;
    }

    public void setData(EmbeddedData data) {
        this.data = data;
    }
}



class EmbeddedData{

    String id;
    String Name;
    String salary;
    String age;
    String ProfileImage;


    public EmbeddedData(String id, String name, String salary, String age, String profileImage) {
        this.id = id;
        Name = name;
        this.salary = salary;
        this.age = age;
        ProfileImage = profileImage;
    }

    public EmbeddedData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(String profileImage) {
        ProfileImage = profileImage;
    }
}
