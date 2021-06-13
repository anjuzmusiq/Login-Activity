package com.example.login;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SessionManager(Context context){
        sharedPreferences=context.getSharedPreferences("Appkey",0);
        editor=sharedPreferences.edit();
        editor.apply();
    }
    public void setLogin(Boolean login){
        editor.putBoolean("KEY",login);
        editor.commit();
    }
    public boolean getLogin(){
        return sharedPreferences.getBoolean("KEY",false);
    }
    public void setusername(String username){
        editor.putString("KEY",username);
        editor.commit();
    }
    public String getusername(){
        return sharedPreferences.getString("KEY","");
    }
}
