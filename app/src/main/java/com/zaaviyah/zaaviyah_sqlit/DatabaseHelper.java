package com.zaaviyah.zaaviyah_sqlit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pakistan laptop on 9/22/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private  static  final String DATABASE_NAME = "shah.db" ;
    private  static  final String TABLE_NAME = "shah" ;

    /// yeh create databse objc ky bad hatdya hay : String name, SQLiteDatabase.CursorFactory factory, int version

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        // after yeh likhty hain work me
        SQLiteDatabase  sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     // here write query db here know

        sqLiteDatabase.execSQL("CREATE TABLE " +TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT , NAME TEXT , MOBILE_NUMBER INTEGER ,EMAIL TEXT)"  );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // jb create ho ga tw yeh kam kry gy
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    /// knows start CODE ADD CONTENTE KNOW INSERTED DATA HERE SHOW AS================================
     public boolean insertContact(String name, int phone, String email)
     {

         SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

         ContentValues contentValues = new ContentValues();
         contentValues.put("NAME", name);
         contentValues.put("MOBILE_NUMBER", phone);
         contentValues.put("EMAIL", email);

        long result =sqLiteDatabase.insert("shah", null, contentValues);

     if (result == -1)
        return false ;
         else
         return  true ;

     }


     /// KNOW GET DATA VIEW AND DATA BASE SHOW ALL SEARCH KNOW HERE===========================
     public Cursor getData(String phone)
     {
         SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String query ="SELECT * FROM shah WHERE MOBILE_NUMBER ='" + phone +"' ";
        // Cursor res =  sqLiteDatabase.rawQuery( query, null );
         Cursor res =  sqLiteDatabase.rawQuery( query, null );
         return res;
     }
      //know DELETE DATA BASE RECORD SHOIW AS THAT==================
     public void deleteData (String phone)
     {
         SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

         sqLiteDatabase.delete(TABLE_NAME,"MOBILE_NUMBER ='" + phone +"'  ",null);
         sqLiteDatabase.close();
     }


     // know UPDATE VALUES SHOW AS THAT ========================================
     public void updateData (String name, String phone, String email)
     {
         SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

         ContentValues contentValues = new ContentValues();

         contentValues.put("NAME", name);
         contentValues.put("EMAIL", email);

         sqLiteDatabase.update(TABLE_NAME,contentValues,"MOBILE_NUMBER ='" + phone +"'  ",null);
         sqLiteDatabase.close();

     }

}
