package com.example.json_parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParserJSON {

    public static String[] name;
    public static String[] email;
    public static String[] username;
    public static String[] password;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_FIRST = "name";
    public static final String KEY_LAST = "email";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASS = "password";


    private JSONArray users = null;

    private String json;

    public ParserJSON(String json) {
        this.json = json;
    }

    protected void parseJSON() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            name = new String[users.length()];
            email = new String[users.length()];
            username = new String[users.length()];
            password = new String[users.length()];

            for (int i = 0; i < users.length(); i++) {
                JSONObject jo = users.getJSONObject(i);
                name[i] = jo.getString(KEY_FIRST);
                email[i] = jo.getString(KEY_LAST);
                username[i] = jo.getString(KEY_USERNAME);
                password[i] = jo.getString(KEY_PASS);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
