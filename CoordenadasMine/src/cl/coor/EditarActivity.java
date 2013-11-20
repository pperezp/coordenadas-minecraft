package cl.coor;

import cl.coor.bd.Crear;
import cl.coor.model.Coordenada;
import cl.coor.model.K;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditarActivity extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_coordenada_layout);
        
        /*boton editar coordenada*/
        Button btnEditar = (Button)findViewById(R.id.btnEditarCoordenada);
        
        EditText tNombre = (EditText)findViewById(R.id.txtNombreCoordenadaEditar);
		EditText tX = (EditText)findViewById(R.id.tXEditar);
		EditText tY = (EditText)findViewById(R.id.tYEditar);
		EditText tZ = (EditText)findViewById(R.id.tZEditar);
		
		tNombre.setText(K.coordenada.getNombre());
		tX.setText(Integer.toString(K.coordenada.getX()));
		tY.setText(Integer.toString(K.coordenada.getY()));
		tZ.setText(Integer.toString(K.coordenada.getZ()));
		
        
        btnEditar.setOnClickListener(new OnClickListener(){
        	
			public void onClick(View v) {
				EditText tNombre = (EditText)findViewById(R.id.txtNombreCoordenadaEditar);
        		EditText tX = (EditText)findViewById(R.id.tXEditar);
        		EditText tY = (EditText)findViewById(R.id.tYEditar);
        		EditText tZ = (EditText)findViewById(R.id.tZEditar);
        		String nombreCoordenada;
        		int x,y,z;
        		
        		nombreCoordenada = tNombre.getText().toString();
        		x = Integer.parseInt(tX.getText().toString());
        		y = Integer.parseInt(tY.getText().toString());
        		z = Integer.parseInt(tZ.getText().toString());
        		
        		Coordenada c = new Coordenada(nombreCoordenada, x, y, z);
        		
        		Crear crear = new Crear(EditarActivity.this);
        		
        		crear.actualizarCoordenada(c);
        		
        		Intent i = new Intent(EditarActivity.this,
						ListarCoordenadasActivity.class);
				startActivity(i);
			}
        });
        /*boton editar coordenada*/
    }

}
