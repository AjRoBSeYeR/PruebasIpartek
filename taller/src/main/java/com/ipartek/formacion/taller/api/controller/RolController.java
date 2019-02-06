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
import com.ipartek.formacion.taller.modelo.pojo.Rol;
import com.ipartek.formacion.taller.service.RolService;
import com.ipartek.formacion.taller.service.exception.RolException;

@RestController
@RequestMapping("api/rol")
public class RolController {

	@Autowired
	RolService rolService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ResponseEntity<ArrayList<Rol>> listar() {
		ResponseEntity<ArrayList<Rol>> response = new ResponseEntity<ArrayList<Rol>>(
				HttpStatus.NOT_FOUND);
		try {
			ArrayList<Rol> roles = rolService.listar();
			if (!roles.isEmpty()) {
				response = new ResponseEntity<ArrayList<Rol>>(roles, HttpStatus.OK);
			}

		} catch (Exception e) {
			response = new ResponseEntity<ArrayList<Rol>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	public ResponseEntity<Rol> detalle(@PathVariable String id) {
		ResponseEntity<Rol> response = new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);
		try {
			int idInt = Integer.parseInt(id);
			Rol rol = rolService.detalle(idInt);
			if (rol != null) {
				response = new ResponseEntity<Rol>(rol, HttpStatus.OK);
			}

		} catch (NumberFormatException e) {
			response = new ResponseEntity<Rol>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			response = new ResponseEntity<Rol>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.DELETE)
	public ResponseEntity<Mensaje> delete(@PathVariable String id) {
		ResponseEntity<Mensaje> response = new ResponseEntity<Mensaje>(HttpStatus.NOT_FOUND);
		try {
			int idInt = Integer.parseInt(id);
			if (rolService.eliminar(idInt)) {
				response = new ResponseEntity<Mensaje>(HttpStatus.OK);
			}

		} catch (RolException e) {
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
	public ResponseEntity<Rol> insert(@RequestBody Rol rol) {
		ResponseEntity<Rol> response = new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);
		try {
			if (rolService.crear(rol)) {
				response = new ResponseEntity<Rol>(rol,HttpStatus.OK);
			}

		} catch (RolException e) {

			response = new ResponseEntity<Rol>( HttpStatus.CONFLICT);
		} catch (Exception e) {
		
			response = new ResponseEntity<Rol>( HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	
	@RequestMapping(value = { "/{id}" }, method = RequestMethod.PUT)
	public ResponseEntity<Rol> update(@PathVariable int id, @RequestBody Rol rol) {
		ResponseEntity<Rol> response = new ResponseEntity<Rol>(HttpStatus.NOT_FOUND);
		try {
			rol.setId(id);
			if (rolService.modificar(rol)) {
				response = new ResponseEntity<Rol>(rol,HttpStatus.OK);
			}

		} catch (RolException e) {

			response = new ResponseEntity<Rol>( HttpStatus.CONFLICT);
		} catch (Exception e) {
		
			response = new ResponseEntity<Rol>( HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
