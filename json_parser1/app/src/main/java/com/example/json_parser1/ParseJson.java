package com.example.json_parser1;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJson {

Context c;
String json;
    public static String[] id;
    public static String[] name;
    public static String[] email;
    public static String[] password;
    public static String[] mobile;

    ParseJson(String data){
        json=data;
    }
     public void parse() throws JSONException {
         JSONObject obj=new JSONObject(json);
         JSONArray obj1=obj.getJSONArray("contacts");
         id=new String[obj1.length()];
         name=new String[obj1.length()];
         email=new String[obj1.length()];
         password=new String[obj1.length()];
         mobile=new String[obj1.length()];
         for(int i=0;i<obj1.length();i++){
          JSONObject obj2= (JSONObject) obj1.get(i);
        id[i]=obj2.getString("id");
          name[i]=obj2.getString("name");
          email[i]=obj2.getString("email");
          password[i]=obj2.getString("address");
          JSONObject obj3=obj2.getJSONObject("phone");
          mobile[i]=obj3.getString("mobile");




         }



     }


}
