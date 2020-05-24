package com.osos.roomimplementation.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "persons")
public class Person {



@PrimaryKey(autoGenerate = true)
@NonNull
int id;


String Topic;
String Note;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person(int id , String Topic, String Note) {
        this.id=id;
        this.Topic=Topic;
        this.Note=Note;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
