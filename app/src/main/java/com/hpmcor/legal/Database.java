package com.hpmcor.legal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Database extends SQLiteOpenHelper {


    public static final String Dbname = "data.db";


    public Database(Context context) {
        super(context, Dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table mytable ( id INTEGER PRIMARY KEY AUTOINCREMENT ,NUMBER TEXT,NAME TEXT,ADRESS TEXT,TYPE TEXT,GETFROM TEXT )");

        db.execSQL("create table mytable2 ( ID INTEGER PRIMARY KEY AUTOINCREMENT ,NAME1 TEXT,NAME2 TEXT,NUMBER TEXT,PLACE TEXT,ADVORCENUMBER TEXT,TYPE TEXT,TIME TEXT,DATE TEXT )");



    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS mytable");
        db.execSQL("DROP TABLE IF EXISTS mytable2");
        onCreate(db);


    }


    public boolean insertData(String number, String name, String adress, String type, String from) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cont = new ContentValues();
        cont.put("NUMBER", number);
        cont.put("NAME", name);
        cont.put("ADRESS", adress);
        cont.put("TYPE", type);
        cont.put("GETFROM", from);

        long result = db.insert("mytable", null, cont);

        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllrecord() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();


        String query = "select * from mytable";

        Cursor res = db.rawQuery(query, null);

        return res;

    }


    public  Cursor getRecord(String number){

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor res = db.rawQuery("select * from mytable WHERE NUMBER = ?",new String[]{number});

        return res;


    }



    public boolean updateData(String number, String name, String adress, String type, String from){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cont = new ContentValues();
        cont.put("NUMBER", number);
        cont.put("NAME", name);
        cont.put("ADRESS", adress);
        cont.put("TYPE", type);
        cont.put("GETFROM", from);
        db.update("mytable",cont,"NUMBER= ?",new String[] {number});
        return true;


    }


    public Integer delete(String number){
        SQLiteDatabase db=this.getWritableDatabase();
      return    db.delete("mytable","NUMBER =?",new String[]{number});
     // db.delete(Note.mytable,"?="+Note.id new String[]{String.valueOf(Note.getId())});





    }


    public Cursor searchData(String name){
        SQLiteDatabase db=this.getReadableDatabase();

        String query = "select * from mytable"+"WHERE"+"NAME"+"like '%"+name+"%'";

        Cursor res = db.rawQuery(query, null);


        return res;
    }




    /////////////////////////////////////Table2?????????????????????????????


    public boolean insertData2(String name1,String name2,String number, String place,String advorcenumber,String type,String time,String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cont = new ContentValues();

        cont.put("NAME1", name1);
        cont.put("NAME2", name2);
        cont.put("NUMBER", number);
        cont.put("TYPE", type);
        cont.put("PLACE", place);
        cont.put("ADVORCENUMBER", advorcenumber);
        cont.put("TIME",time);
        cont.put("DATE",date);
        //cont.put("GETFROM", from);


        long result = db.insert("mytable2", null, cont);

        if (result == -1)
            return false;
        else
            return true;
    }





    public boolean updateData2(String name1,String name2,String number, String place,String advorcenumber,String type,String time,String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cont = new ContentValues();
        cont.put("NAME1", name1);
        cont.put("NAME2", name2);
        cont.put("NUMBER", number);
        cont.put("TYPE", type);
        cont.put("PLACE", place);
        cont.put("ADVORCENUMBER", advorcenumber);
        cont.put("TIME",time);
        cont.put("DATE",date);

        db.update("mytable2",cont,"NUMBER= ?",new String[] {number});
        return true;


    }





    public Cursor getAllrecord2() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();


        String query = "select * from mytable2";

        Cursor res2 = db.rawQuery(query, null);

        return res2;

    }



    public Cursor getAllrecord3() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();


        String query = "select * from mytable2 where ID = ?";

        Cursor res2 = db.rawQuery(query, null);

        return res2;

    }




    public Integer delete2(String number){
        SQLiteDatabase db=this.getWritableDatabase();
        return    db.delete("mytable2","NUMBER =?",new String[]{number});
        // db.delete(Note.mytable,"?="+Note.id new String[]{String.valueOf(Note.getId())});





    }



    public Cursor getDate() {
       // SELECT * FROM Table1 ORDER BY datetime("date_column") DESC ;
        SQLiteDatabase db = this.getReadableDatabase();


        String query = "select * from mytable2 ORDER BY DATE  DESC  " ;

        Cursor res = db.rawQuery(query, null);

        return res;

    }


 public Cursor getDateDay() {
       // SELECT * FROM Table1 ORDER BY datetime("date_column") DESC ;
        SQLiteDatabase db = this.getReadableDatabase();


        String query = "SELECT * from mytable2 where DATE = (select max(myDate) from Table1 WHERE myDate < DATE('now') )" ;

        Cursor res = db.rawQuery(query, null);

        return res;

    }


    public  Cursor getRecord2(String number){

        SQLiteDatabase db = this.getReadableDatabase();


      //  Cursor res = db.rawQuery("select * from mytable2 WHERE NUMBER = ?",new String[]{number});

        Cursor res = db.rawQuery("select * from mytable2 WHERE NUMBER = ?",new String[]{number});

        return res;

    }




           // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            //LocalDateTime now = LocalDateTime.now();
            //String date=now.toString();
           // System.out.println(dtf.format(now));

    public  Cursor getRecord5(){


        SQLiteDatabase db = this.getReadableDatabase();

        SimpleDateFormat sdfDate = new SimpleDateFormat("d-M-yyyy", Locale.ENGLISH);
        String currentDateandTime = sdfDate.format(new Date());

        String query="SELECT  * FROM  mytable2 WHERE  DATE ="+ "'" +currentDateandTime + "'";

       // Toast.makeText(Database.this,""+currentDateandTime,Toast.LENGTH_LONG);

       // Log.v("Database","current"+currentDateandTime);
        Cursor res = db.rawQuery(query,null);
        //Log.v("","REHAM"+currentDateandTime);

        return res;


    }







}