package com.travelblog.http;

import android.content.Context;
import android.content.SharedPreferences;

public class BlogSharedPreferences {
    private static final String KEY_STATE_LOGIN = "KEY_STATE_LOGIN";
    private final SharedPreferences preferences;

    public BlogSharedPreferences(Context context) {
        preferences = context.getSharedPreferences("travel-blog",Context.MODE_PRIVATE);
    }

    public boolean isLoggedIn() {
        return preferences.getBoolean(KEY_STATE_LOGIN,false);
    }

    public void setLoggedIn(boolean loggedIn) {
        preferences.edit().putBoolean(KEY_STATE_LOGIN,loggedIn).apply();
    }
}
