package com.curso.asesorias;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class ListObjects {
	
	private List<String> listDataHeader;
	private HashMap<String, List<String>> listDataChild;
	private List<Maestro> masters;
	private HashMap<String,Maestro> maestrosMap;
	
	public ListObjects(List<String> listDataHeader,
			HashMap<String, List<String>> listDataChild, List<Maestro> masters,
			HashMap<String, Maestro> maestrosMap) {
		super();
		this.listDataHeader = listDataHeader;
		this.listDataChild = listDataChild;
		this.masters = masters;
		this.maestrosMap = maestrosMap;
	}

	public List<String> getListDataHeader() {
		return listDataHeader;
	}

	public HashMap<String, List<String>> getListDataChild() {
		return listDataChild;
	}

	public List<Maestro> getMasters() {
		return masters;
	}

	public HashMap<String, Maestro> getMaestrosMap() {
		return maestrosMap;
	}

	
	
	
	
	
	
	
}
