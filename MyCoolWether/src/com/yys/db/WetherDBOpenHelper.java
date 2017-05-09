package com.yys.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class WetherDBOpenHelper extends SQLiteOpenHelper {

	private final String CREAT_PROVINCE = "create table Province "
			+ "(id integer primary key autoincrement, "
			+ "province_name text, " 
			+ "province_code text) ";
	private final String CREAT_CITY = "create table City "
			+ "(id integer primary key autoincrement, "
			+ "city_name text, " 
			+ "city_code text,"
			+ "province_id integer) ";
	private final String CREAT_COUNTY = "create table County "
			+ "(id integer primary key autoincrement, "
			+ "county_name text, " 
			+ "county_code text,"
			+ "city_id integer) ";

	public WetherDBOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREAT_PROVINCE);
		db.execSQL(CREAT_CITY);
		db.execSQL(CREAT_COUNTY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
