package com.example.matte.minibet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TableControllerBet extends DatabaseHandler {

    public TableControllerBet(Context context) {
        super(context);
    }

    public boolean create(ObjectBet objectBet) {

        ContentValues values = new ContentValues();

        values.put("country", objectBet.betCountry);
        values.put("amount", objectBet.betAmount);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("bets", null, values) > 0;
        db.close();

        return createSuccessful;
    }

    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM bets";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();
        return recordCount;
    }

    public List<ObjectBet> read() {

        List<ObjectBet> recordsList = new ArrayList<ObjectBet>();

        String sql = "SELECT * FROM bets ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String betCountry = cursor.getString(cursor.getColumnIndex("country"));
                int betAmount = Integer.parseInt(cursor.getString(cursor.getColumnIndex("amount")));

                ObjectBet objectBet = new ObjectBet();
                objectBet.id = id;
                objectBet.betCountry = betCountry;
                objectBet.betAmount = betAmount;

                recordsList.add(objectBet);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }




}