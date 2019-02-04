package com.ipartek.formacion.taller.service;

import java.util.ArrayList;

import com.ipartek.formacion.taller.modelo.pojo.Persona;

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
	ArrayList<Object> vehiculos(int idPersona);
	
	
	
	

}
