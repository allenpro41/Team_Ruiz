package com.example.user.testttt;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by User on 12/20/2017.
 */

public class DATABASE extends SQLiteOpenHelper {
    public DATABASE(Context context){
        super(context, "Student.db", null, 1);
    }





    public void AddStudent(String year, String name, String course){

        ArrayList<studs> studs = this.selectStudent();
        int i = 0;
        if(studs.size() < 1 ){
            i = i + 1;

        }else{
            i = studs.size() + 1;
        }

        SQLiteDatabase db = getWritableDatabase();
        ContentValues conts = new ContentValues();
        conts.put("ID", i);
        conts.put("YEAR", year);
        conts.put("NAME", name);
        conts.put("COURSE", course);
        db.insert("tbl_student", null, conts);
    }
    public void UpdateStudent(int id, String year,String name,String course) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues conts = new ContentValues();

        conts.put("YEAR", year);
        conts.put("NAME", name);
        conts.put("COURSE", course);

        db.update("tbl_student",conts,"ID = '"+ id + "'",null);

    }
    public void DeleteStudent(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("tbl_student","ID ='"+ id + "'",null);
    }
    public ArrayList<studs> selectStudent(){
        ArrayList<studs> result = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM tbl_student", null);
        c.moveToFirst();

        while (c.isAfterLast() == false){
            int id = c.getInt(c.getColumnIndex("ID"));
            String year = c.getString(c.getColumnIndex("YEAR"));
            String name = c.getString(c.getColumnIndex("NAME"));
            String course = c.getString(c.getColumnIndex("COURSE"));
            studs studs = new studs(id,year, name, course);
            result.add(studs);
            c.moveToNext();
        }

        return result;
    }

    public DATABASE(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public String getDatabaseName() {
        return super.getDatabaseName();
    }

    @Override
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        super.setWriteAheadLoggingEnabled(enabled);
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override
    public synchronized void close() {
        super.close();
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tbl_student (ID INTEGER PRIMARY KEY AUTOINCREMENT, YEAR VARCHAR, NAME VARCHAR, COURSE VARCHAR)");
        db.execSQL("CREATE TABLE tbl_Works (ID INTEGER PRIMARY KEY AUTOINCREMENT,  WORKINTERVALS INTEGER, COMPLETED INTEGER,SKIPPED INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
