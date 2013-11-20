package cl.coor;

import java.util.List;

import cl.coor.adapters.CoorAdapter;
import cl.coor.bd.Get;
import cl.coor.model.Coordenada;
import cl.coor.model.K;
import cl.coor.model.Mapa;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class ListarCoordenadasActivity extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_coordenadas_layout);
        
        /*Listar coordenadas*/
        Get g = new Get(this);
		Mapa map = g.getMapas().get(K.MAPA_INDEX);
		
		List<Coordenada> coordenadas = map.getCoordenadas();
		
		
		ListView listaCoordenadas = (ListView)this.findViewById(R.id.listaCoordenadas);
		
		/*ArrayAdapter<Coordenada> adaptador = new ArrayAdapter<Coordenada>(this,
				android.R.layout.simple_list_item_1, 
				coordenadas);*/
		
		//listaCoordenadas.setAdapter(adaptador); //adaptador simple
		listaCoordenadas.setAdapter(new CoorAdapter(this, coordenadas));//adapter personalizado
		/*Listar coordenadas*/
		
		
		/*Boton crear coordenada*/
		 Button btnCrearCoor = (Button)findViewById(R.id.btnCrearCoorMenu);
		 btnCrearCoor.setOnClickListener(new OnClickListener(){
			 public void onClick(View view){
				 Intent i = new Intent(ListarCoordenadasActivity.this, CrearCoordenadaActivity.class);
				 startActivity(i);
			 }
		 });
		/*Boton crear coordenada*/
		 
		 
	}
	
	
}
