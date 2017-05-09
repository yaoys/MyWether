package com.yys.db;

import java.util.ArrayList;
import java.util.List;

import com.yys.bean.City;
import com.yys.bean.County;
import com.yys.bean.Province;
import com.yys.constant.Constant;

import android.R.integer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.util.Log;
import android.widget.ListView;

public class WetherDB {

	private String TAG = "WetherDB";
	public static final String DB_NAME = "CoolWether";
	public static final int VERSION = 1;
	private static WetherDB mWetherDB;
	private SQLiteDatabase db;

	public WetherDB(Context context) {
		WetherDBOpenHelper openHelper = new WetherDBOpenHelper(context,
				DB_NAME, null, VERSION);
		db = openHelper.getWritableDatabase();
	}

	public static WetherDB getInstance(Context context) {
		if (null == mWetherDB) {
			mWetherDB = new WetherDB(context);
		}
		return mWetherDB;
	}
	
	public void saveProvince(Province province) {
		ContentValues values = new ContentValues();
		values.put(Constant.TABLE_PROVINCE_NAME, province.getName());
		values.put(Constant.TABLE_PROVINCE_CODE, province.getCode());
		db.insert(Constant.PROVINCE, null, values);
	}
	
	public void saveCity(City city) {
		ContentValues values = new ContentValues();
		values.put(Constant.TABLE_CITY_NAME, city.getName());
		values.put(Constant.TABLE_CITY_CODE, city.getCode());
		values.put(Constant.TABLE_PROVINCE_ID, city.getProvinceId());
	}
	
	public void saveCounty(County county) {
		ContentValues values = new ContentValues();
		values.put(Constant.TABLE_COUNTY_NAME, county.getName());
		values.put(Constant.TABLE_COUNTY_CODE, county.getCode());
		values.put(Constant.TABLE_CITY_ID, county.getCityId());
	}
	
	public List<Province> getProvinceListFromDB () {
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db.query(Constant.PROVINCE, null, null, null, null, null, null);
		if(null == cursor) {
			Log.d(TAG, "getProvinceListFromDB: cursor is null return");
			return list;
		}
		
		cursor.moveToFirst();
		
		while (cursor.moveToNext()) {
			Province province = new Province();
			province.setId(cursor.getInt(cursor.getColumnIndex("id")));
			province.setName(cursor.getString(cursor.getColumnIndex(Constant.TABLE_COUNTY_NAME)));
			province.setCode(cursor.getString(cursor.getColumnIndex(Constant.TABLE_PROVINCE_CODE)));
			list.add(province);
		}
		
		return list;
	}
	
	public List<City> getCityListFromDB(int provinceId) {
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query(Constant.CITY, null, Constant.TABLE_PROVINCE_ID + " = ?", new String[] {String.valueOf(provinceId)}, null, null, null);
		if(null == cursor) {
			Log.d(TAG, "getCityListFromDB: cursor is null return");
			return list;
		}
		
		cursor.moveToFirst();
		
		while (cursor.moveToNext()) {
			City city = new City();
			city.setProvinceId(provinceId);
			city.setId(cursor.getInt(cursor.getColumnIndex("id")));
			city.setName(cursor.getString(cursor.getColumnIndex(Constant.TABLE_CITY_NAME)));
			city.setCode(cursor.getString(cursor.getColumnIndex(Constant.TABLE_CITY_CODE)));
			list.add(city);
		}
		return list;
	}
	
	public List<County> getCountyListFromDB(int cityId) {
		List<County> list = new ArrayList<County>();
		Cursor cursor = db.query(Constant.COUNTY, null, Constant.TABLE_CITY_ID + " = ?", new String[] {String.valueOf(cityId)}, null, null, null);
		if(null == cursor) {
			Log.d(TAG, "getCountyListFromDB: cursor is null return");
			return list;
		}
		
		cursor.moveToFirst();
		
		while (cursor.moveToNext()) {
			County county = new County();
			county.setCityId(cityId);
			county.setId(cursor.getInt(cursor.getColumnIndex("id")));
			county.setName(cursor.getString(cursor.getColumnIndex(Constant.TABLE_COUNTY_NAME)));
			county.setCode(cursor.getString(cursor.getColumnIndex(Constant.TABLE_COUNTY_CODE)));
			list.add(county);
		}
		return list;
	}
	
}