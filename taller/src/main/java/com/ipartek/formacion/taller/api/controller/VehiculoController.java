package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.service.PersonaService;


@CrossOrigin
@RestController
public class VehiculoController {
	
	@Autowired
	PersonaService  personaService;

	@RequestMapping(value = { "/api/persona/{id}/vehiculo" }, method = RequestMethod.GET)
	public ArrayList<Vehiculo> listar() {
		
		ArrayList<Vehiculo> vehiculos= new ArrayList<Vehiculo>();

		return vehiculos;
	

		

	}

}
