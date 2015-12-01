package com.curso.asesorias;


import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registro extends Activity implements OnClickListener  {

	ActionBar titulo;
	EditText nombre, contra;
	Button confirmar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		
		titulo = this.getActionBar();
		titulo.hide();
		
		nombre = (EditText) findViewById (R.id.etUsuario);
		contra = (EditText) findViewById (R.id.etContra);
		confirmar = (Button) findViewById (R.id.btConfirmar);
		
		confirmar.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registro, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btConfirmar:
			boolean funciona = true;
			try {
				String nom = nombre.getText().toString();
				String con = contra.getText().toString();
				
				nombre.setText("");
				contra.setText("");
				
				DBAdapter reg = new DBAdapter (Registro.this);
				reg.open();
				reg.register(nom, con);
				reg.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				funciona = false;
				String error = e.toString();
				Dialog d = new Dialog (this);
				d.setTitle("No se pudo crear usuario");
				TextView tv = new TextView(this);
				//e.printStackTrace();
				tv.setText(error);
				d.setContentView(tv);
				d.show();
			}finally{
				if (funciona) {
					Dialog d = new Dialog(this);
					d.setTitle("¡Listo!");
					TextView tv = new TextView(this);
					tv.setText("Usuario Creado");
					d.setContentView(tv);
					d.show();
					
					Intent i2 = new Intent(this, LoginActivity.class);
					startActivity(i2);
					
				}
			}
			
			break;

		}
	}

}
