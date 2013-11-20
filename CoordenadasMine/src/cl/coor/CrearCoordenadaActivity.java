package cl.coor;

import cl.coor.bd.Crear;
import cl.coor.bd.Get;
import cl.coor.model.Coordenada;
import cl.coor.model.K;
import cl.coor.model.Mapa;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearCoordenadaActivity extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_coordenada_layout);
        
        /*Programación boton para crear coordenada*/
        Button btnCrearCoordenada = (Button)this.findViewById(R.id.btnCrearCoordenada);
        
        btnCrearCoordenada.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		Get g = new Get(CrearCoordenadaActivity.this);
        		
        		Mapa mapa = g.getMapas().get(K.MAPA_INDEX);
        		
        		EditText tNombre = (EditText)findViewById(R.id.txtNombreCoordenada);
        		EditText tX = (EditText)findViewById(R.id.tX);
        		EditText tY = (EditText)findViewById(R.id.tY);
        		EditText tZ = (EditText)findViewById(R.id.tZ);
        		String nombreCoordenada;
        		int x,y,z;
        		
        		nombreCoordenada = tNombre.getText().toString();
        		x = Integer.parseInt(tX.getText().toString());
        		y = Integer.parseInt(tY.getText().toString());
        		z = Integer.parseInt(tZ.getText().toString());
        		
        		Coordenada c = new Coordenada(nombreCoordenada, x, y, z, mapa);
        		
        		Crear crear = new Crear(CrearCoordenadaActivity.this);
        		
        		crear.crearCoordenada(c);
        		
        		Toast toast = Toast.makeText(getApplicationContext(), "Coordenada creada", Toast.LENGTH_SHORT);
        		toast.show();
        		
        		Intent i = new Intent(CrearCoordenadaActivity.this, ListarCoordenadasActivity.class);
        		startActivity(i);
        		
        		/*System.out.println(mapa.getId());
        		System.out.println(nombreCoordenada);
        		System.out.println(x);
        		System.out.println(y);
        		System.out.println(z);*/
        	}
        });
        /*Programación boton para crear coordenada*/
    }
	
}
