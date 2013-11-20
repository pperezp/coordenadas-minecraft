package cl.coor;

import cl.coor.bd.Get;
import cl.coor.model.K;
import cl.coor.model.Mapa;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*Listar mapas*/
        ListView listaMapas = (ListView)this.findViewById(R.id.listaMapa);
        Get get = new Get(this);
        ArrayAdapter<Mapa> adaptador = new ArrayAdapter<Mapa>(this,
										android.R.layout.simple_list_item_1, 
										get.getMapas());
        
        listaMapas.setAdapter(adaptador);
        
        /*Click a un item de una lista, a un mapa*/
        listaMapas.setOnItemClickListener(new OnItemClickListener() {
        	
        	public void onItemClick(AdapterView<?> a, View v, int position, long id) {
        		K.MAPA_INDEX = position;
        		//Toast toast = Toast.makeText(getApplicationContext(), map.toString(), Toast.LENGTH_SHORT);
        		//toast.show();
        		
        		Intent i = new Intent(MainActivity.this, ListarCoordenadasActivity.class);
        		startActivity(i);
        	}
        });
        
        /*Click a un item de una lista, a un mapa*/
        /*Listar mapas*/
        
        
        
        /*Boton crear mapa del main activity*/
        Button btnCrearMapa = (Button)this.findViewById(R.id.btnMenuMapa);
        
        btnCrearMapa.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		Intent i = new Intent(MainActivity.this, CrearMapaActivity.class);
        		startActivity(i);
        	}
        });
        /*Boton crear mapa del main activity*/
    }
    
    
}