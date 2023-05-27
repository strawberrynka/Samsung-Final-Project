package com.example.samsungfinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Player {
    private int coins;
    private int diamonds;
    public int fur;
    private int woolItems;
    private int cats;

    private SQLiteDatabase database;
    private MyDatabaseHelper dbHelper;
    private Context context;



    public Player(Context context) {
        dbHelper = new MyDatabaseHelper(context, this);
        database = dbHelper.getWritableDatabase();
        //loadPlayerData();
    }

    public int getCoins() {
        return coins;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public int getFur() {
        return fur;
    }

    public int getWoolItems() {
        return woolItems;
    }

    public int getCats() {
        return cats;
    }

    public void addCoins(int amount) {
        coins += amount;
        savePlayerData();
    }


    public void addDiamonds(int amount) {
        diamonds += amount;
        savePlayerData();
    }

    public void addFur(int amount) {
        fur += amount;
        savePlayerData();
    }

    public void addWoolItems(int amount) {
        woolItems += amount;
        savePlayerData();
    }

    public void addCat(int amount) {
        cats += amount;
        savePlayerData();
    }

    private int ownedCatCount;

//    public int getOwnedCatCount() {
//        return ownedCatCount;
//    }

    public void incrementOwnedCatCount() {
        ownedCatCount++;
    }

//    @SuppressLint("Range")
//    private void loadPlayerData() {
//        // Загрузка данных из базы данных
//        Cursor cursor = database.query("player_data", null, null, null, null, null, null);
//
//        if (cursor.moveToFirst()) {
//            coins = cursor.getInt(cursor.getColumnIndex("coins"));
//            diamonds = cursor.getInt(cursor.getColumnIndex("diamonds"));
//            fur = cursor.getInt(cursor.getColumnIndex("fur"));
//            woolItems = cursor.getInt(cursor.getColumnIndex("woolItems"));
//            cats = cursor.getInt(cursor.getColumnIndex("cats"));
//        } else {
//            // Если записей в таблице нет, установите начальные значения
//            coins = 500; // Начальное значение баланса монет
//            diamonds = 4;
//            fur = 0;
//            woolItems = 0;
//            cats = 1;
//            savePlayerData(); // Сохранение начальных значений в базу данных
//        }
//        cursor.close();
//    }

    private void savePlayerData() {
        // Сохранение данных в базу данных
        ContentValues values = new ContentValues();
        values.put("coins", coins);
        values.put("diamonds", diamonds);
        values.put("fur", fur);
        values.put("woolItems", woolItems);
        values.put("cats", cats);
        database.update("player_data", values, null, null);
    }

}
