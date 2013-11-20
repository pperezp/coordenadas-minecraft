package cl.coor.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import cl.coor.EditarActivity;
import cl.coor.ListarCoordenadasActivity;
import cl.coor.R;
import cl.coor.bd.Crear;
import cl.coor.model.*;

public class CoorAdapter extends BaseAdapter {
	protected Activity activity;
	protected List<Coordenada> items;

	public CoorAdapter(Activity activity, List<Coordenada> items) {
		this.activity = activity;
		this.items = items;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return items.get(arg0);
	}

	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return items.get(arg0).getId();
	}

	public View getView(int position, View contentView, ViewGroup parent) {
		View vi = contentView;

		if (contentView == null) {
			LayoutInflater inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			vi = inflater.inflate(R.layout.item_coordenada_layout, null);
		}

		Coordenada coordenada = items.get(position);

		TextView nombreCoor = (TextView) vi.findViewById(R.id.nomCor);
		nombreCoor.setText(coordenada.getNombre());

		TextView coor = (TextView) vi.findViewById(R.id.coordenadas);
		coor.setText(coordenada.toString());

		/* boton eliminar */
		Button btnEliminar = (Button) vi
				.findViewById(R.id.btnEliminarCoordenada);

		final Coordenada c = coordenada;

		btnEliminar.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// Mostrar un mensaje de confirmación antes de realizar el test
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(
						activity);
				alertDialog.setMessage("¿Desea eliminar la coordenada ["
						+ c.getNombre() + "]?");
				alertDialog.setTitle("Eliminar coordenada");
				alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
				alertDialog.setCancelable(false);
				alertDialog.setPositiveButton("Sí",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								// código Java si se ha pulsado sí
								Crear crear = new Crear(activity);
								crear.eliminarCoordenada(c);

								Intent i = new Intent(activity,
										ListarCoordenadasActivity.class);
								activity.startActivity(i);
							}
						});
				
				  alertDialog.setNegativeButton("No", new
				  DialogInterface.OnClickListener() { public void
				  onClick(DialogInterface dialog, int which) { //código java si se ha pulsado no
				  
				  } });
				 
				alertDialog.show();
			}
		});
		/* boton eliminar */
		
		
		/* boton actualizar */
		Button btnActualizar = (Button) vi
		.findViewById(R.id.btnEditarCoordenada);
		
		btnActualizar.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				K.coordenada = c;
				
				Intent i = new Intent(activity, EditarActivity.class);
        		activity.startActivity(i);
			}
		});
		/* boton actualizar */

		return vi;
	}

}
