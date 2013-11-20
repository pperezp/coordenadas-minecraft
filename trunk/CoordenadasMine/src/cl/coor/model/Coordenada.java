package cl.coor.model;

public class Coordenada {
	private int id;
	private String nombre;
	private int x;
	private int y;
	private int z;
	private Mapa mapa;
	
	public Coordenada(int id, String nombre, int x, int y, int z) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	

	public Coordenada(String nombre, int x, int y, int z) {
		super();
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		this.z = z;
	}



	public Coordenada(String nombre, int x, int y, int z, Mapa mapa) {
		super();
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		this.z = z;
		this.mapa = mapa;
	}



	public Mapa getMapa() {
		return mapa;
	}



	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		//return "---------------\n"+nombre+"   \n   x:  "+x+"   \n   y:  "+y+"   \n   z:  "+z+"\n---------------";
		return "[X: "+x+"]\n[Y: "+y+"]\n[Z: "+z+"]";
	}
	
	
}