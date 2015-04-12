package com.example.nifras.pias;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nifras on 4/11/15.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PIAS.db";
    public static final String USER_TABLENAME = "user";
    public static final String USER_ID = "id";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "email";
    public static final String USER_NAME = "name";



    public DBHelper(Context context){
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
       "CREATE TABLE IF NOT EXISTS user (\n" +
               "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
               "  username varchar(200) NOT NULL,\n" +
               "  password varchar(200) NOT NULL,\n" +
               "  email varchar(200) NOT NULL,\n" +
               "  name varchar(200) NOT NULL  \n" +
               ")"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS location (\n" +
                "  location_id INTEGER NOT NULL  PRIMARY KEY AUTOINCREMENT,\n" +
                "  description varchar(255) DEFAULT NULL,\n" +
                "  lat float DEFAULT NULL,\n" +
                "  lon float DEFAULT NULL\n" +
                "  )");
        db.execSQL("CREATE TABLE IF NOT EXISTS type (\n" +
                "  type_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "  name varchar(45) NOT NULL\n" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS user");
       db.execSQL("DROP TABLE IF EXISTS location");
       db.execSQL("DROP TABLE IF EXISTS type");
       onCreate(db);

    }

    public boolean insertUser(String username, String password, String email, String name){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email", email);
        contentValues.put("name", name);

        db.insert(USER_TABLENAME, null, contentValues);
        return true;
    }

    public Cursor getUser(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT *FROM user where username = ?", new String[]{username+""});

        return  res;


    }
}
