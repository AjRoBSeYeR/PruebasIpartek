package com.ipartek.formacion.taller.service;

import java.util.ArrayList;

import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;

public interface PersonaService {
	
	
	/**
	 * listado personas
	 * @return lista personas
	 */
	ArrayList<Persona> listar();
	
	/**
	 * listado vehiculos de una persona
	 * @param idPersona identificador de persona
	 * @return listado personas
	 */
	ArrayList<Vehiculo> vehiculos(int idPersona);
	
	
	
	

}
