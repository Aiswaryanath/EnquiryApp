package com.student.admin.enquiryapp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/30/2019.
 */
public class Enquiryhelper extends SQLiteOpenHelper {
    public static final String Dbname = "MyE.db";
    public static final String TableName = "Enquiry";
    public static final String col1 = "id";
    public static final String col2 = "name";
    public static final String col3 = "emailid";
    public static final String col4 = "mobileno";
    public static final String col5 = "place";
    public static final String col6 = "message";
    public static final String col7 = "purpose";
    public Enquiryhelper(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table " + TableName + "(" + col1 + " integer primary key autoincrement," + col2 + " text," + col3 + " text," + col4 + " text," + col5 + " text," + col6 + " text,"+col7+" text)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table if exists " + TableName;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }

    public boolean insertData(String name, String emailid, String mobileno, String place, String message,String purpose) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, name);
        contentValues.put(col3, emailid);
        contentValues.put(col4, mobileno);
        contentValues.put(col5, place);
        contentValues.put(col6, message);
        contentValues.put(col7, purpose);
        long status = sqLiteDatabase.insert(TableName, null, contentValues);
        if (status == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor SearchData(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TableName+"WHERE"+col2+"='"+name+"'",null);
        return cursor;
    }

}