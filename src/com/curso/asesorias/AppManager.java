package com.curso.asesorias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppManager {
	
	
	private List<Maestro> masters;
	private HashMap<String,Maestro> maestrosMap;
	
	public AppManager(){
		masters = new ArrayList<Maestro>();
		maestrosMap = new HashMap<String,Maestro>();
		fillData();
	}
	
	
	public void fillData(){
		
		String [][] horario = {{"10-12","","10-12","",""},
								{"12-14","","","","12-14"},
								{"","","","",""}};
		
		String [][] avilaGodoy = {{"","","11-13","11-13",""},
								{"12-13","","12-13","",""},
								{"","","","",""}};
		
		String [][] horario3 = {{"9-10","","9-10","",""},
									{"16-17","","16-17","",""},
									{"","","","","18-19"}};
		
		String [][] horario4 = {{"11-12","","11-12","",""},
								{"15-16","","15-16","","15-16"},
								{"","","","","18-19"}};
		
		
		masters.add(new Maestro("ÁVILA GODOY MICAELA GUADALUPE", "EDIF. 3K2, 2DO. PISO MÓDULO 1, CUB. 1",
							new String []{"INTRODUCCION AL ANALISIS MATEMATICO", "ANÁLISIS MATEMÁTICOS I","ANÁLISIS MATEMÁTICOS II","MODELOS ESTOCÁSTICOS","PROBABILIDAD"}, avilaGodoy));
		
		masters.add(new Maestro("ÁVILA GODOY RAMIRO", "EDIF. 3K2, 2DO. PISO MÓDULO 3, CUB. I", 
								new String []{"CÁLCULO I","SEMINARIO D PROFUNDISACION EN TEMAS MATEMATICOS"}, horario));
		
		masters.add(new Maestro("BACA RAMIREZ ABEL", "EDIF. 3K3, 2DO. PISO MODULO 2, CUB. 1", new String []{"CÁLCULO III"}, horario3));
		
		masters.add(new Maestro("BAUTISTA JACOBO ALEJANDRINA", "BIBLIOTECA DEL EDIFICIO 7C. “ESC. DE MEDICINA", new String []{"BIOESTADISTICA"}, horario));
		
		masters.add(new Maestro("BRAU ROJAS AGUSTÍN", "EDIF. 3K2, 2DO. PISO MÓDULO 9, CUB. 1", new String []{"ANÁLISIS MATEMÁTICOS I","ANÁLISIS MATEMÁTICOS I","PROBABILIDAD","PROBABILIDAD  ESTADISTICA"}, horario4));
		
		for (Maestro m: masters) {
			maestrosMap.put(m.getNombre(), m);
		}
	}
	
	
	public ListObjects buscar(String filtro){
		List<String> listDataHeader = new ArrayList<String>();;
		HashMap<String, List<String>> listDataChild = new HashMap<String,List<String>>();
		
		Object [] mas = masters.toArray();
		
		for (Maestro actual:masters) {
			
			String [] mats = actual.getMaterias();
			
			for (int i = 0; i < mats.length; i++) {
				
				if (mats[i].toLowerCase().contains(filtro.toLowerCase())) {
					
					if (!listDataHeader.contains(mats[i])) {
						listDataHeader.add(mats[i]);
					}
					
					if (!listDataChild.containsKey(mats[i])) {
						List<String> l = new ArrayList<String>();
						l.add(actual.getNombre());
						listDataChild.put(mats[i], l);
						
					} else {
						
						listDataChild.get(mats[i]).add(actual.getNombre());
					}
				}
				
			}
		}
		
		return new ListObjects(listDataHeader, listDataChild, masters, maestrosMap);
		
	}


	public HashMap<String, Maestro> getMaestrosMap() {
		return maestrosMap;
	}
	
	
	
	
}
