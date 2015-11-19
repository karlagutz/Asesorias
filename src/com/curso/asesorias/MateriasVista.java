package com.curso.asesorias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class MateriasVista extends Activity implements OnChildClickListener {
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_materias_vista);
		
		// get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvMaterias);
 
        // preparing list data
        prepareListData();
 
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);
        
        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
 
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                    int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });
 
        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
 
            @Override
            public void onGroupExpand(int groupPosition) {
              /*  Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
                        */
            }
        });
 
        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
 
            @Override
            public void onGroupCollapse(int groupPosition) {
            	
              /*  Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();
               */
            
            }
        });
 
        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {
 
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {

            	switch (childPosition) {
        		
        		case 0:
        			Intent i  = new Intent (this, HorariosVista.class);
        			startActivity(i);
        			break;
            	 }
        			
                // TODO Auto-generated method stub

                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                        listDataHeader.get(groupPosition)).get(
                                        childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
        
	}
	 private void prepareListData() {
	        listDataHeader = new ArrayList<String>();
	        listDataChild = new HashMap<String, List<String>>();
	 
	        // Adding child data
	        listDataHeader.add("CÁLCULO DIFERENCIAL E INTEGRAL I");
	        listDataHeader.add("CÁLCULO DIFERENCIAL E INTEGRAL II");
	        listDataHeader.add("CÁLCULO DIFERENCIAL E INTEGRAL III");
	 
	        // Adding child data
	        List<String> calculo1 = new ArrayList<String>();
	        calculo1.add("ÁVILA GODOY RAMIRO");
	        calculo1.add("BACA RAMIREZ ABEL");
	        calculo1.add("BRAVO TAPIA JOSÉ MARÍA");
	        calculo1.add("CAUDANA CAMACHO GERMÁN");

	        List<String> calculo2 = new ArrayList<String>();
	        calculo2.add("ÁVILA GODOY RAMIRO");
	        calculo2.add("BACA RAMIREZ ABEL");
	        calculo2.add("BRAVO TAPIA JOSÉ MARÍA");
	        calculo2.add("CAUDANA CAMACHO GERMÁN");

	        List<String> calculo3 = new ArrayList<String>();
	        calculo3.add("ÁVILA GODOY RAMIRO");
	        calculo3.add("BACA RAMIREZ ABEL");
	        calculo3.add("BRAVO TAPIA JOSÉ MARÍA");
	        calculo3.add("CAUDANA CAMACHO GERMÁN");
	 
	        listDataChild.put(listDataHeader.get(0), calculo1); // Header, Child data
	        listDataChild.put(listDataHeader.get(1), calculo2);
	        listDataChild.put(listDataHeader.get(2), calculo3);
	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.materias_vista, menu);
		return true;
	}
	@Override
	public boolean onChildClick(ExpandableListView arg0, View arg1, int arg2,
			int arg3, long arg4) {
		// TODO Auto-generated method stub
		return false;
	}

}
