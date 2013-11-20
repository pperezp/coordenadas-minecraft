package cl.coor.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BD extends SQLiteOpenHelper{
	//Sentencia SQL para crear la tabla de Usuarios
	String sqlMapa = "CREATE TABLE mapa (" +
						"id INTEGER primary key AUTOINCREMENT," +
						"nombre TEXT" +
					 ")";
	
	String sqlCoordenada = "CREATE TABLE coordenada (" +
								"id INTEGER primary key AUTOINCREMENT," +
								"nombre TEXT," +
								"x INTEGER," +
								"y INTEGER," +
								"z INTEGER," +
								"mapa INTEGER," +
								"foreign key(mapa) references mapa(id)" +
						   ")";
	
	public BD(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}


	/*Se llama este metodo automaticamente cuando la bd no exista. Por ende
	 * aca se crean todas las tablas y todas las cosas de tu BD*/
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sqlMapa);
		db.execSQL(sqlCoordenada);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists mapa");
		db.execSQL("drop table if exists coordenada");
		onCreate(db);
	}
}
