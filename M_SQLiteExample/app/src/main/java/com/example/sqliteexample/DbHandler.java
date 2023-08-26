package com.example.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DbHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "ContactInfo";
    private static final int DB_VERSION=1;
    private static final String TABLE_NAME = "MyContact";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NUMBER = "number";

    public DbHandler(Context context) {
        super(context, DB_NAME, null,  DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + " TEXT, " + KEY_NUMBER + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUserNumber(String uName,String cNumber){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put(KEY_NAME,uName);
        value.put(KEY_NUMBER,cNumber);

        db.insert(TABLE_NAME,null,value);
    }

    public ArrayList<ContactDetails> getDetails(){

        ArrayList<ContactDetails> contactDetailsArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);

        while (cursor.moveToNext()){
            ContactDetails cd = new ContactDetails();

            cd.id = cursor.getInt(0);
            cd.name = cursor.getString(1);
            cd.number = cursor.getString(2);

            contactDetailsArrayList.add(cd);
        }

        return contactDetailsArrayList;
    }

    public void deleteUser(int userId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + " = ?", new String[]{String.valueOf(userId)});
        db.close();
    }

    public int updateUserDetails(String newName, String newNumber, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(KEY_NAME, newName);
        cVals.put(KEY_NUMBER, newNumber);
        int count = db.update(TABLE_NAME, cVals, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
        return count;
    }

}
