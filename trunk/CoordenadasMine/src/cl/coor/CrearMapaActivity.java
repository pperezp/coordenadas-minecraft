package cl.coor;

import cl.coor.R;
import cl.coor.bd.Crear;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearMapaActivity extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_mapa_layout);
        
        Button btnCrearMapa = (Button)this.findViewById(R.id.btnCrearMapa);
        
        btnCrearMapa.setOnClickListener(new OnClickListener(){
        	
        	public void onClick(View view){
        		EditText txtNombre = (EditText)findViewById(R.id.txtNombreMapa);
        		Crear c = new Crear(CrearMapaActivity.this);
        		c.crearMapa(txtNombre.getText().toString());
        		
        		Toast toast = Toast.makeText(getApplicationContext(), "Mapa creado", Toast.LENGTH_SHORT);
        		toast.show();
        		
        		Intent i = new Intent(CrearMapaActivity.this, MainActivity.class);
        		startActivity(i);
        	}
        });
    }
	
	
}