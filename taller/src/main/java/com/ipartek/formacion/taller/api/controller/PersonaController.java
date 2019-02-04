package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.modelo.pojo.Persona;
import com.ipartek.formacion.taller.modelo.pojo.Vehiculo;
import com.ipartek.formacion.taller.service.PersonaService;

@CrossOrigin
@RestController
public class PersonaController {

	/* instacia e implementa patron sigleton - inyeccion de dependencias */
	@Autowired
	PersonaService personaService;

	@RequestMapping(value = { "/api/persona" }, method = RequestMethod.GET)
	public ArrayList<Persona> listar() {

		return personaService.listar();
	}

	@RequestMapping(value = { "/api/persona/{id}/vehiculo" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Vehiculo>> listarvehiculos(@PathVariable int id) {

		ResponseEntity<ArrayList<Vehiculo>> response = new ResponseEntity<ArrayList<Vehiculo>>(HttpStatus.NOT_FOUND);
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

		Vehiculo vehiculo = new Vehiculo();

		try {
			vehiculo.setId(4);
			vehiculo.setMatricula("HY4562JU");
			vehiculo.setNumeroBastidor("123456");
			vehiculos.add(vehiculo);

			vehiculo = new Vehiculo();

			vehiculo.setId(5);
			vehiculo.setMatricula("WWWWWWWU");
			vehiculo.setNumeroBastidor("1eeeee");
			vehiculos.add(vehiculo);
			response = new ResponseEntity<ArrayList<Vehiculo>>(vehiculos, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<ArrayList<Vehiculo>>(vehiculos, HttpStatus.CONFLICT);
		}
		return response;

	}

}
