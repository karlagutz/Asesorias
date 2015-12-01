package com.curso.asesorias;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends Activity  implements OnClickListener {

	
	ImageButton buscar;
	EditText ed;
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buscar = (ImageButton) findViewById(R.id.btBuscar);
        buscar.setOnClickListener(this);
        ed = (EditText) findViewById(R.id.etBuscar);
    	ActionBar bar = getActionBar();
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9a0000")));
		
		
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btBuscar:
				
				String filtro = ed.getText().toString();
				Intent i = new Intent(this, MateriasVista.class);
				i.putExtra("filtro", filtro);
				startActivity(i);
			break;
		}
	}
}
