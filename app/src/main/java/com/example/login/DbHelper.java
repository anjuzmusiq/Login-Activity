package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "Registerdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table login(email TEXT primary key,password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table  if EXISTS login");
    }
    public Boolean insertdata(String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result= db.insert("login",null,contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public  Boolean checkemail(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from login where email=?",new String[]{email});
        if(cursor.getCount()>0)
            return true;
        else return false;
    }
    public  Boolean checkemailpassword(String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from login where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0)
            return true;
        else return false;
    }
}
