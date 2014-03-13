package com.brazil2014;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class UserDetailsDB {
	
	public static final String KEY_ROWID = "_id";
	public static final String KEY_USERNAME = "name";
	public static final String KEY_COUNTRY = "country";
	public static final String KEY_WINNER = "winner";
	
	public static final String DATABASE_NAME = "User";
	public static final String DATABASE_TABLE = "Details";
	public static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = 
			"create table Details (_id integer primary key autoincrement, " + 
									"name text not null, " + 
									"country text, " + 
									"winner text not null);";
	
	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public UserDetailsDB (Context ctx)
	{
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper (Context context)
		{
			super (context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		
		@Override
		public void onCreate (SQLiteDatabase db)
		{
			db.execSQL(DATABASE_CREATE);
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
			//db structure change
		}
		
	}
	public UserDetailsDB open() throws SQLException
	{
		db = DBHelper.getWritableDatabase();
		return this;
	}
	
	public void close()
	{
		DBHelper.close();
	}
	
	public long insertDetails(String name, String country, String winner)
	{
		ContentValues initialValues = new ContentValues();
		
		initialValues.put(KEY_USERNAME, name);
		initialValues.put(KEY_COUNTRY, country);
		initialValues.put(KEY_WINNER, winner);
		return db.insert(DATABASE_TABLE, null, initialValues);
		
	}
	
	public boolean deletePerson (long rowId)
	{
		return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
		
	}
	
	public Cursor getAllPeople()
	{
		return db.query(DATABASE_TABLE, new String[]
				{
					KEY_ROWID,
					KEY_USERNAME,
					KEY_COUNTRY,
					KEY_WINNER
				},
		null, null, null, null, null);
	}
	public Cursor getPerson(long rowId) throws SQLException
	{
		Cursor mCursor = 
				db.query(true, DATABASE_TABLE, new String[]
						{
							KEY_ROWID,
							KEY_USERNAME,
							KEY_COUNTRY,
							KEY_WINNER
						},
						KEY_ROWID + "=" + rowId, null, null, null, null, null);
		if (mCursor != null)
		{
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	public boolean updatePerson(long rowId, String name, String country, int winner )
	{
		ContentValues args = new ContentValues();
		args.put(KEY_USERNAME, name);
		args.put(KEY_COUNTRY, country);
		args.put(KEY_WINNER, winner);
		return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
	}

}
