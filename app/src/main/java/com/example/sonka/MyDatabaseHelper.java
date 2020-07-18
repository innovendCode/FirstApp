package com.example.sonka;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public  static final String DATABASE_NAME = "village_banking";
    public  static final String TABLE_NAME = "members";
    public  static final String COL_1 = "id";
    public  static final String COL_2 = "name";
    public  static final String COL_3 = "role";
    public  static final String COL_4 = "pre_share";
    public  static final String COL_5 = "pre_loan";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME +" (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, role TEXT, pre_share TEXT, pre_loan TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertMember(String name, String role){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, role);
        long result = sqLiteDatabase.insert(TABLE_NAME,null, contentValues);

        if (result == -1){
            return false;
        }else {
            return true;
        }
    }
}
