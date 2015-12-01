package com.curso.asesorias;

public class Maestro {
	
	private String nombre;
	private String lugar;
	private String [] materias;
	private String [][] horario;
	
	
	public Maestro(String nombre,String lugar,String [] materias, String [][] horario){
		this.nombre = nombre;
		this.lugar = lugar;
		this.materias = materias;
		this.horario = horario;
	}


	public String getNombre() {
		return nombre;
	}


	public String getLugar() {
		return lugar;
	}


	public String[] getMaterias() {
		return materias;
	}


	public String[][] getHorario() {
		return horario;
	}
	
	public String getMateriasString(){
		String res = "";
		for (int i = 0; i < materias.length; i++) {
			if (i == materias.length - 1) {
				res = res + materias[i];
			} else {
				res = res + materias[i] + ",\n";
			}
			
		}
		
		return res;
	}
	
	
	
}
