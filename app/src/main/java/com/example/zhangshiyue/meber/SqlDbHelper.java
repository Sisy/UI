package com.example.zhangshiyue.meber;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by zhangshiyue on 15-3-10.
 */
public class SqlDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Mber";
    public static final String DATABASE_TABLE = "EventList_NearBy";
    private static final int DATABASE_VERSION = 2;
    public static final String COLUMN1 = "Id";
    public static final String COLUMN2 = "EventName";
    public static final String COLUMN3 = "Location";
    private static final String SCRIPT_CREATE_DATABASE = "create table "
            + DATABASE_TABLE + " (" + COLUMN1
            + " integer primary key autoincrement, " + COLUMN2
            + " text not null, " + COLUMN3 + " text not null);";

    SqlDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(SCRIPT_CREATE_DATABASE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    public long addRecord(String id,String location,String description)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN1, id);
        cv.put(COLUMN2, location);
        cv.put(COLUMN3, description);

        return db.insert(DATABASE_TABLE, null, cv);
    }

    public ArrayList<NearByEvent> getAllNotes()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<NearByEvent> listItems = new ArrayList<NearByEvent>();

        Cursor cursor = db.rawQuery("SELECT * from " + DATABASE_TABLE,new String [] {});

        if (cursor.moveToFirst())
        {
            do {
                NearByEvent event = new NearByEvent();

                event.setId(cursor.getString(cursor.getColumnIndex(COLUMN1)));
                event.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN2)));
                event.setLocation(cursor.getString(cursor.getColumnIndex(COLUMN3)));

                listItems.add(event);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return listItems;
    }

    /*
    * //This method deletes a record from the database.
    */
    public void deleteNote(long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String string = String.valueOf(id);
        db.execSQL("DELETE FROM " + DATABASE_TABLE + " WHERE " + COLUMN1 + "=" + id + "");
    }

}
