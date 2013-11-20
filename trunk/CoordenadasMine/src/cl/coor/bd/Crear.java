package cl.coor.bd;

import cl.coor.model.Coordenada;
import cl.coor.model.K;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Crear {
	private Context contexto;
	
	public Crear(Context contexto) {
		super();
		this.contexto = contexto;
	}



	public void crearMapa(String nombre){
		BD conexion = new BD(contexto, "bdCoordenadas", null, 1);
        
        SQLiteDatabase db = conexion.getWritableDatabase();
        
        db.execSQL("insert into mapa(nombre) values('"+nombre+"')");
        db.close();
	}
	
	public void crearCoordenada(Coordenada c){
		BD conexion = new BD(contexto, "bdCoordenadas", null, 1);
        
        SQLiteDatabase db = conexion.getWritableDatabase();
        
        db.execSQL("insert into coordenada(nombre, x, y, z, mapa) " +
        		"values('"+c.getNombre()+"', '"+c.getX()+"','"+c.getY()+"','"+c.getZ()+"','"+c.getMapa().getId()+"')");
        db.close();
	}
	
	public void eliminarCoordenada(Coordenada c){
		BD conexion = new BD(contexto, "bdCoordenadas", null, 1);
        
        SQLiteDatabase db = conexion.getWritableDatabase();
        
        db.execSQL("delete from coordenada where id = '"+c.getId()+"'");
        db.close();
	}
	
	public void actualizarCoordenada(Coordenada c){
		BD conexion = new BD(contexto, "bdCoordenadas", null, 1);
        
        SQLiteDatabase db = conexion.getWritableDatabase();
        
        db.execSQL("update coordenada " +
        		"set nombre='"+c.getNombre()+"', x='"+c.getX()+"', y='"+c.getY()+"', z='"+c.getZ()+"' " +
        		"where id = '"+K.coordenada.getId()+"'");
        db.close();
	}
}