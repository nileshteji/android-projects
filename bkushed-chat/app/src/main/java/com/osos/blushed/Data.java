package com.osos.blushed;

import com.osos.blushed.Model.Message;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
ArrayList<Message> data=new ArrayList<>(Arrays.asList(new Message("Me","Hi",0),
        new Message("They","Hi Bitch",0),
        new Message("Me","Please na then stop Watching the movies",0),
        new Message("They","What about the rest",0),
        new Message("Me","Hi",0),
        new Message("Center","First Day Over",0),
        new Message("Me","Hi",0),
        new Message("They","Hi Bitch",0),
        new Message("Me","Please na then stop Watching the movies",0),
        new Message("They","What about the rest",0),
        new Message("Me","Hi",0),
        new Message("Me","Hi",0),
        new Message("They","Hi Bitch",0),
        new Message("Me","Please na then stop Watching the movies",0),
        new Message("They","What about the rest",0),
        new Message("Me","Hi",0),
        new Message("Me","This is the image below",0),
        new Message("Me","Hi Bitch",1),
        new Message("Me","Please na then stop Watching the movies",0),
        new Message("Me","Hi",0),
        new Message("They","Hi Bitch",0),
        new Message("Me","Please na then stop Watching the movies",0),
        new Message("They","What about the rest",0),
        new Message("Me","Hi",0),
        new Message("Center","First Day Over",0),
        new Message("Me","Hi",0),
        new Message("They","Hi Bitch",0),
        new Message("Me","Please na then stop Watching the movies",0),
        new Message("They","What about the rest",0),
        new Message("Me","Hi",0),
        new Message("Me","Hi",0),
        new Message("They","Hi Bitch",0),
        new Message("Me","Please na then stop Watching the movies",0),
        new Message("They","What about the rest",0),
        new Message("Me","Hi",0),
        new Message("Me","Hi",0),
        new Message("Me","Hi Bitch",1),
        new Message("Me","Please na then stop Watching the movies",0)));



public int getSize(){
    return data.size();
}


    public Message getData(int index) {
      return data.get(index);
}



public ArrayList<Message> getList(){
    return data;
}
}
