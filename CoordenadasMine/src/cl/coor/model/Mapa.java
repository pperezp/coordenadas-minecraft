package cl.coor.model;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
	private int id;
	private String nombre;
	private List<Coordenada> lCoordenadas;
	
	public Mapa(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		lCoordenadas = new ArrayList<Coordenada>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString(){
		return nombre;
	}
	
	public void addCoordenada(Coordenada coor){
		lCoordenadas.add(coor);
	}
	
	public Coordenada getCoordenada(int index){
		return lCoordenadas.get(index);
	}
	
	public List<Coordenada> getCoordenadas(){
		return this.lCoordenadas;
	}
}