package cl.coor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ItemActivity extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_coordenada_layout);
        
        /*boton eliminar*/
		 Button btnEliminar = (Button)findViewById(R.id.btnEliminarCoordenada);
		 
		 btnEliminar.setOnClickListener(new OnClickListener(){
			 public void onClick(View view){
				 Toast toast = Toast.makeText(getApplicationContext(), "Eliminar", Toast.LENGTH_SHORT);
				 toast.show();
			 }
		 });
		 /*boton eliminar*/
    }
}
