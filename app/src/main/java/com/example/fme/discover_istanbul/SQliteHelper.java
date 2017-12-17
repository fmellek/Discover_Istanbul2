package com.example.fme.discover_istanbul;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FME on 17.12.2017.
 */

public class SQliteHelper extends SQLiteOpenHelper {
    private static final int database_VERSION =1;
    private static final String database_NAME = "SportDB";
    private static final String table_SPORTS = "sporlar";
    private static final String sport_ID = "id";
    private static final String sport_TITLE = "baslik";
    private static final String sport_KATEGORI = "kategori";
    private static final String sport_AUTHOR = "yazar";
    private static final String[] COLUMNS = {sport_ID, sport_TITLE, sport_AUTHOR,sport_KATEGORI};
    private static final String CREATE_SPORT_TABLE = "CREATE TABLE "
            + table_SPORTS+ " ("
            + sport_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + sport_TITLE+ " TEXT, "
            + sport_AUTHOR+ " TEXT,"
            + sport_KATEGORI + " TEXT ) ";

    public SQliteHelper(Context context) {

        super(context, database_NAME, null, database_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_SPORT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_SPORTS);
        this.onCreate(sqLiteDatabase);

    }
    public void KitapEkle(Sport sport){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues degerler = new ContentValues();
        degerler.put(sport_TITLE, sport.getBaslik());
        degerler.put(sport_AUTHOR, sport.getYazar());
        degerler.put(sport_KATEGORI,sport.getKategori());
        sqLiteDatabase.insert(table_SPORTS,null,degerler);
        sqLiteDatabase.close();

    }
    public List<Sport> sporlariGetir(){
        List<Sport> sporlar = new ArrayList<>();
        String query = "SELECT * FROM "+table_SPORTS;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        Sport sport = null;
        if (cursor.moveToFirst()){
            do {
                sport = new Sport();
                sport.setId(Integer.parseInt(cursor.getString(0)));
                sport.setBaslik(cursor.getString(1));
                sport.setYazar(cursor.getString(2));
                sport.setKategori(cursor.getString(3));
                sporlar.add(sport);

            }while (cursor.moveToNext());
        }
        return sporlar;
    }

    public  Sport sporOku(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(table_SPORTS,COLUMNS," id = ?",new String[]{String.valueOf(id)},null,
                null,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
            Sport sport = new Sport();
            sport.setId(Integer.parseInt(cursor.getString(0)));
            sport.setBaslik(cursor.getString(1));
            sport.setYazar(cursor.getString(2));
            return sport;


    }
    public void sportSil(Sport sport){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(table_SPORTS,sport_ID + " = ?",new String[]{String.valueOf(sport.getId())});
        sqLiteDatabase.close();
    }

    public List<Sport> futbolGetir(){
        List<Sport> sporlar = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(table_SPORTS,COLUMNS,sport_KATEGORI + " = 'Futbol'",null,null,null,null);
        Sport sport = null;
        if (cursor.moveToFirst()){
            do {
                sport = new Sport();
                sport.setId(Integer.parseInt(cursor.getString(0)));
                sport.setBaslik(cursor.getString(1));
                sport.setYazar(cursor.getString(2));
                sport.setKategori(cursor.getString(3));
                sporlar.add(sport);

            }while (cursor.moveToNext());
        }
        return sporlar;
    }


}

