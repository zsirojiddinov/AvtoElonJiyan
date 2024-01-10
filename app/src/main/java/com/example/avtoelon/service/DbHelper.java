package com.example.avtoelon.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.avtoelon.model.AutoModel;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mydb";

    private static final String TABLE_NAME = "autocar";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String YEAR = "year";
    private static final String REGION = "region";
    private static final String ODOMETER = "odometer";
    private static final String PRICE = "price";
    private static final String PUBLISHEDDATE = "publishedDate";
    private static final String SHOW_COUNT = "show_count";
    private static final String IMAGELIST = "imageList";
    private static final String ISLIKE = "isLike";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME + " TEXT, "
                + YEAR + " TEXT, "
                + REGION + "TEXT,"
                + ODOMETER + " TEXT,"
                + PRICE + " INTEGER,"
                + PUBLISHEDDATE + "TEXT,"
                + SHOW_COUNT + "INTEGER,"
                + IMAGELIST + "TEXT,"
                + ISLIKE + "INTEGER)";
        db.execSQL(query);
    }

    public ArrayList<AutoModel> getAutoList() {
        ArrayList<AutoModel> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        Log.d("admin", "" + cursor.getString(1));
        if (cursor.moveToFirst()) {
            do {
                list.add(
                        new AutoModel(
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getInt(5),
                                cursor.getString(6),
                                cursor.getInt(7),
                                cursor.getString(8),
                                cursor.getInt(9)
                        )
                );
            } while (cursor.moveToNext());
        }
        //   db.close();
        return list;
    }

    public long insertAutoModel(AutoModel model) {
        SQLiteDatabase sqLiteOpenHelper = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, model.getId());
        contentValues.put(NAME, model.getName());
        contentValues.put(YEAR, model.getYear());
        contentValues.put(REGION, model.getRegion());
        contentValues.put(ODOMETER, model.getOdometer());
        contentValues.put(PRICE, model.getPrice());
        contentValues.put(PUBLISHEDDATE, model.getPublishedDate());
        contentValues.put(SHOW_COUNT, model.getShow_count());
        contentValues.put(IMAGELIST, model.getImageList());
        contentValues.put(ISLIKE, model.isLike());

        long result = sqLiteOpenHelper.insert(TABLE_NAME, null, contentValues);
        //  sqLiteOpenHelper.close();
        return result;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
