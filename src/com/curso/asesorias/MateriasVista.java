package com.curso.asesorias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;

import android.app.Activity;
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
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });
 
        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
 
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();
 
            }
        });
 
        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {
 
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
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
	        listDataHeader.add("Top 250");
	        listDataHeader.add("Now Showing");
	        listDataHeader.add("Coming Soon..");
	 
	        // Adding child data
	        List<String> top250 = new ArrayList<String>();
	        top250.add("The Shawshank Redemption");
	        top250.add("The Godfather");
	        top250.add("The Godfather: Part II");
	        top250.add("Pulp Fiction");
	        top250.add("The Good, the Bad and the Ugly");
	        top250.add("The Dark Knight");
	        top250.add("12 Angry Men");
	 
	        List<String> nowShowing = new ArrayList<String>();
	        nowShowing.add("The Conjuring");
	        nowShowing.add("Despicable Me 2");
	        nowShowing.add("Turbo");
	        nowShowing.add("Grown Ups 2");
	        nowShowing.add("Red 2");
	        nowShowing.add("The Wolverine");
	 
	        List<String> comingSoon = new ArrayList<String>();
	        comingSoon.add("2 Guns");
	        comingSoon.add("The Smurfs 2");
	        comingSoon.add("The Spectacular Now");
	        comingSoon.add("The Canyons");
	        comingSoon.add("Europa Report");
	 
	        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
	        listDataChild.put(listDataHeader.get(1), nowShowing);
	        listDataChild.put(listDataHeader.get(2), comingSoon);
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