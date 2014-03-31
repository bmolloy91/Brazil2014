package com.brazil2014;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TeamInfoDb {
	
	public static final String KEY_ROWID = "_id";
	public static final String KEY_COUNTRY = "country";
	public static final String KEY_RANK = "rank";
	public static final String KEY_PREVIOUS = "previous";
	public static final String KEY_COACH = "coach";
	public static final String KEY_CAPTAIN = "captain";
	
	public static final String DATABASE_NAME = "Team";
	public static final String DATABASE_TABLE = "TeamDetails";
	public static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = 
			"create table TeamDetails (_id integer primary key autoincrement, " + 
									"country text not null, " + 
									"rank text not null, " + 
									"previous text not null, " +
									"coach text not null, " +
									"captain text not null);";
	
	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	public TeamInfoDb (Context ctx)
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
	
	public TeamInfoDb open() throws SQLException
	{
		db = DBHelper.getWritableDatabase();
		return this;
	}
	
	public void close()
	{
		DBHelper.close();
	}
	
	public long insertInfo(String country, String rank, String previous, String coach, String captain)
	{
		ContentValues initialValues = new ContentValues();
		
		
		initialValues.put(KEY_COUNTRY, country);
		initialValues.put(KEY_RANK, rank);
		initialValues.put(KEY_PREVIOUS, previous);
		initialValues.put(KEY_COACH, coach);
		initialValues.put(KEY_CAPTAIN, captain);
		return db.insert(DATABASE_TABLE, null, initialValues);
		
	}
	
	public Cursor getTeam(long rowId) throws SQLException
	{
		Cursor mCursor = 
				db.query(true, DATABASE_TABLE, new String[]
						{
							KEY_ROWID,
							KEY_COUNTRY,
							KEY_RANK,
							KEY_PREVIOUS,
							KEY_COACH,
							KEY_CAPTAIN
							
						},
						KEY_ROWID + "=" + rowId, null, null, null, null, null);
		if (mCursor != null)
		{
			mCursor.moveToFirst();
		}
		return mCursor;
	}
	
}
