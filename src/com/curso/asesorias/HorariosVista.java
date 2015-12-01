package com.curso.asesorias;

import java.util.HashMap;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class HorariosVista extends Activity {

	String nombre;
	String [][] horario;
	AppManager app;
	
	TextView tvNombre,tvMaterias,tvLugar;
	private HashMap<String,Maestro> maestrosMap;
	
	TableLayout tabla;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_horarios_vista);
		
		tabla = (TableLayout) findViewById(R.id.Tabla);
		tvNombre = (TextView) findViewById(R.id.tvNombre);
		tvMaterias = (TextView) findViewById(R.id.tvMateria);
		tvLugar = (TextView) findViewById(R.id.tvAula);
		
		app = new AppManager();
		ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9a0000")));
		bar.setTitle("Horarios");
		
		maestrosMap = app.getMaestrosMap();
		nombre = getIntent().getStringExtra("nombre");
		
		Maestro m = maestrosMap.get(nombre);
		horario = m.getHorario();
		tvNombre.setText(m.getNombre());
		tvMaterias.setText(m.getMateriasString());
		tvLugar.setText(m.getLugar());
		
		
		TableRow row;
		for (int i = 0; i < horario.length; i++) {
		    row = (TableRow) tabla.getChildAt(i+1);
			for (int j = 0; j < horario[i].length; j++) {
				TextView tv = (TextView)row.getChildAt(j);
				
				tv.setText(horario[i][j]);
				
			}
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.horarios_vista, menu);
		return true;
	}

}
