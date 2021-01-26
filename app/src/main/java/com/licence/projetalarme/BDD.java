package com.licence.projetalarme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Create by SA E SILVA Eduardo on <DATE-ON-JOUR>
 */
public class BDD extends SQLiteOpenHelper {
    public static final String KEY = "id";
    public static final String CITATION = "citation";
    public static final String AUTEUR = "auteur";

    public static final String METIER_TABLE_NAME = "Citation";
    public static final String METIER_TABLE_CREATE = "CREATE TABLE " + METIER_TABLE_NAME + " (" + KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CITATION + " TEXT, " + AUTEUR + " REAL);";

    public BDD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(METIER_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL();
    }

}