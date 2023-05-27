package com.example.samsungfinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Arrays;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Названия таблицы и столбцов Cats
    public static final String TABLE_CATS = "cats";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_IMAGE_PATH = "image_path";

    // Константы с информацией о таблице player_data
    private static final String TABLE_PLAYER_DATA = "player_data";
    private static final String COLUMN_COINS = "coins";
    private static final String COLUMN_DIAMONDS = "diamonds";
    private static final String COLUMN_FUR = "fur";
    private static final String COLUMN_WOOL_ITEMS = "wool_items";
    private static final String COLUMN_CATS = "cats";;

    // Создание таблицы Cats
    private static final String CREATE_TABLE_CATS = "CREATE TABLE " + TABLE_CATS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_GENDER + " TEXT,"
            + COLUMN_IMAGE_PATH + " TEXT"
            + ")";

    // Создание таблицы PlayerData
    private static final String CREATE_TABLE_PLAYER_DATA = "CREATE TABLE " + TABLE_PLAYER_DATA + "("
            + COLUMN_COINS + " INTEGER, "
            + COLUMN_DIAMONDS + " INTEGER, "
            + COLUMN_FUR + " INTEGER, "
            + COLUMN_WOOL_ITEMS + " INTEGER, "
            + COLUMN_CATS + " INTEGER"
            + ")";

    public MyDatabaseHelper(Context context, Player player) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.player = player;
    }

    private Player player;

    private static String[] CAT_NAMES = {
            "Whiskers",
            "Luna",
            "Kiwi"
    };

    private static String[] CAT_GENDERS = {
            "Male",
            "Female",
            "Female"
    };

    private static String[] CAT_IMAGE_PATHS = {
            "@drawable/tile000.png",
            "@drawable/tile001.png",
            "@drawable/tile002.png"
    };

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CATS);
        db.execSQL(CREATE_TABLE_PLAYER_DATA);

        addCat(db);

        // Установка начального баланса монет
        ContentValues values = new ContentValues();
        values.put(COLUMN_COINS, 100); // Начальное значение баланса монет
        db.insert(TABLE_PLAYER_DATA, null, values);


    }

    private void addCat(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, CAT_NAMES[0]);
        values.put(COLUMN_GENDER, CAT_GENDERS[0]);
        values.put(COLUMN_IMAGE_PATH, CAT_IMAGE_PATHS[0]);
        db.insert(TABLE_CATS, null, values);

        // Увеличение счетчика в классе Player
        player.incrementOwnedCatCount();

        //убираем первый элемент
        for(int i = 0; i < CAT_NAMES.length - 1; i++) {
            CAT_NAMES[i] = CAT_NAMES[i + 1];
            CAT_GENDERS[i] = CAT_GENDERS[i + 1];
            CAT_IMAGE_PATHS[i] = CAT_IMAGE_PATHS[i + 1];
        }
        CAT_NAMES = Arrays.copyOf(CAT_NAMES, CAT_NAMES.length - 1);
        CAT_GENDERS = Arrays.copyOf(CAT_GENDERS, CAT_NAMES.length - 1);
        CAT_GENDERS = Arrays.copyOf(CAT_GENDERS, CAT_NAMES.length - 1);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER_DATA);
        onCreate(db);
    }

    // Метод для добавления информации о котике в базу данных
//    public void addCat(String name, String gender, String imagePath) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NAME, name);
//        values.put(COLUMN_GENDER, gender);
//        values.put(COLUMN_IMAGE_PATH, imagePath);
//        long catId = db.insert(TABLE_CATS, null, values);
//        if (catId != -1) {
//            addCatToPlayer(catId);
//        }
//        db.close();
//    }

//    private void addCatToPlayer(long catId) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_CATS, catId);
//        db.update(TABLE_PLAYER_DATA, values, null, null);
//        db.close();
//    }

    // Метод для получения количества монет из базы данных
    public int getCoinCount() {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {
                COLUMN_COINS
        };

        Cursor cursor = db.query(
                TABLE_PLAYER_DATA,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        int coinCount = 0;

        if (cursor.moveToFirst()) {
            coinCount = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_COINS));
        }

        cursor.close();
        db.close();

        return coinCount;
    }


}