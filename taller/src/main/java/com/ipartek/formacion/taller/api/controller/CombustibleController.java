package com.ipartek.formacion.taller.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.taller.api.pojo.Mensaje;
import com.ipartek.formacion.taller.modelo.pojo.Combustible;
import com.ipartek.formacion.taller.service.CombustibleService;
import com.ipartek.formacion.taller.service.exception.CombustibleException;

@RestController
@RequestMapping("api/combustible")
public class CombustibleController {

	@Autowired
	CombustibleService combustibleService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Combustible>> listar() {
		ResponseEntity<ArrayList<Combustible>> response = new ResponseEntity<ArrayList<Combustible>>(
				HttpStatus.NOT_FOUND);
		try {
			ArrayList<Combustible> combustibles = combustibleService.listar();
			if (!combustibles.isEmpty()) {
				response = new ResponseEntity<ArrayList<Combustible>>(combustibles, HttpStatus.OK);
			}

		} catch (Exception e) {
			response = new ResponseEntity<ArrayList<Combustible>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Combustible> detalle(@PathVariable String id) {
		ResponseEntity<Combustible> response = new ResponseEntity<Combustible>(HttpStatus.NOT_FOUND);
		try {
			int idInt = Integer.parseInt(id);
			Combustible combustible = combustibleService.detalle(idInt);
			if (combustible != null) {
				response = new ResponseEntity<Combustible>(combustible, HttpStatus.OK);
			}

		} catch (NumberFormatException e) {
			response = new ResponseEntity<Combustible>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			response = new ResponseEntity<Combustible>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Mensaje> delete(@PathVariable String id) {
		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);
		try {
			int idInt = Integer.parseInt(id);
			if (combustibleService.eliminar(idInt)) {
				response = new ResponseEntity<Mensaje>(HttpStatus.OK);
			}

		} catch (CombustibleException e) {
			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.CONFLICT);
		} catch (NumberFormatException e) {
			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			Mensaje mensaje = new Mensaje(e.getMessage());
			response = new ResponseEntity<Mensaje>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	
	@RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public ResponseEntity<Combustible> insert(@RequestBody Combustible combustible) {
		ResponseEntity<Combustible> response = new ResponseEntity<Combustible>(HttpStatus.NOT_FOUND);
		try {
			if (combustibleService.crear(combustible)) {
				response = new ResponseEntity<Combustible>(combustible,HttpStatus.OK);
			}

		} catch (CombustibleException e) {

			response = new ResponseEntity<Combustible>( HttpStatus.CONFLICT);
		} catch (Exception e) {
		
			response = new ResponseEntity<Combustible>( HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<Combustible> update(@PathVariable int id, @RequestBody Combustible combustible) {
		ResponseEntity<Combustible> response = new ResponseEntity<Combustible>(HttpStatus.NOT_FOUND);
		try {
			combustible.setId(id);
			if (combustibleService.modificar(combustible)) {
				response = new ResponseEntity<Combustible>(combustible,HttpStatus.OK);
			}

		} catch (CombustibleException e) {

			response = new ResponseEntity<Combustible>( HttpStatus.CONFLICT);
		} catch (Exception e) {
		
			response = new ResponseEntity<Combustible>( HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
