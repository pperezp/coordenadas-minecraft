package cl.coor.bd;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import cl.coor.model.*;

public class Get {
	
	private Context contexto;
	
	public Get(Context contexto) {
		super();
		this.contexto = contexto;
	}

	public List<Mapa> getMapas(){
		List<Mapa> lMapas = new ArrayList<Mapa>();
		
		BD conexion = new BD(contexto, "bdCoordenadas", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        
        BD conexion2 = new BD(contexto, "bdCoordenadas", null, 1);
        SQLiteDatabase db2 = conexion2.getWritableDatabase();
        
        Cursor c = db.rawQuery("select * from mapa", null);
        Cursor c2;
        
        Mapa mapa;
        Coordenada coor;
        if(c.moveToFirst()){
        	/*Ciclo para recorrer los mapas*/
        	do{
        		mapa = new Mapa(c.getInt(0), c.getString(1));
        		
        		/*selecciono las coordenadas de ese mapa en especifico*/
        		c2 = db2.rawQuery("select id, nombre, x, y, z from coordenada where mapa = "+mapa.getId(), null);
        		
        		if(c2.moveToFirst()){
                	do{
                		coor = new Coordenada(c2.getInt(0), c2.getString(1), c2.getInt(2), c2.getInt(3), c2.getInt(4));
	                	mapa.addCoordenada(coor);
                	}while(c2.moveToNext());
                }
        		
        		lMapas.add(mapa);
        	}while(c.moveToNext());
        }
        
        db.close();
        
        return lMapas;
	}
}
